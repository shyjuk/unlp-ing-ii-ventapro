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
import unlp.info.ingenieriaii.modelo.Usuario;

public class BuscarOrdenServlet extends ServletPagina{

	private static final long serialVersionUID = 2068570366807689353L;
	
	private String setListaId(BuscadorOrden buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (OrdenDeVenta object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}

	private void setBuscador(String dni, HttpServletRequest req,
			boolean validar) throws SQLException {
		BuscadorOrden buscador = new BuscadorOrden();
		Errores errores;
		// TODO FALTA
		buscador.setDni(dni);
		errores = buscador.buscar(validar);

		req.setAttribute("buscador", buscador);
		req.setAttribute("errores", errores);
		req.setAttribute("vendedores", Usuario.buscarUsuarios());
		req.setAttribute("estados", Estados.todosLosEstados());
		req.setAttribute("listaId", this.setListaId(buscador));
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		this.setBuscador(null, req, false);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if ("anular".equals(req.getParameter("accion"))) {
			OrdenDeVenta orden = new OrdenDeVenta();

			orden.setId(Integer.parseInt(req.getParameter("id")));
			// ACA VA PROCESO ANULAR UPDATE
			//req.setAttribute("erroresEliminar", orden.eliminar());

		} 

		this.setBuscador(req.getParameter("dni"), req, req.getParameter("btnBuscar") != null);
		super.procesarPost(req, resp);
	}

}
