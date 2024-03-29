package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Estados;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;

public class CobrarOrdenServlet extends ServletPagina{

	
	private static final long serialVersionUID = 8419657161587764774L;
	
	private String setListaId(BuscadorOrden buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (OrdenDeVenta object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}

	private void setBuscador(HttpServletRequest req,
			boolean validar) throws SQLException {
		BuscadorOrden buscador = new BuscadorOrden();
		Errores errores;
		buscador.setEstado("1"); // solo muestro estado PENDIENTE
		errores = buscador.buscar(validar);

		req.setAttribute("buscador", buscador);
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscador));
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		this.setBuscador(req, false);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if ("pagar".equals(req.getParameter("accion"))) {
			OrdenDeVenta orden = new OrdenDeVenta();
			String id = req.getParameter("id");
			orden.setId(Utiles.esVacio(id) ? null : Integer.parseInt(id));
			orden.setEstado(String.valueOf(Estados.PAGADA.getId()));
			orden.guardar(); // no hay errores
			resp.sendRedirect("facturaGenerada.jsp?num_orden=" + id);
		}else {
			// agrgar boton refrescar
			this.setBuscador(req, req.getParameter("btnAceptar") != null);
			super.procesarPost(req, resp);
		}
		
	}

}
