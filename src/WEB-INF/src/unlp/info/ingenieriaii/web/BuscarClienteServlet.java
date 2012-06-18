package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Cliente;

public class BuscarClienteServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -100289560054782101L;

	private String setListaId(BuscadorCliente buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (Cliente object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}

	private void setBuscador(String nombre, String apellido, String nroDocumento, HttpServletRequest req,
			boolean validar) throws SQLException {
		BuscadorCliente buscadorCliente = new BuscadorCliente();
		Errores errores;

		buscadorCliente.setNombre(nombre);
		buscadorCliente.setApellido(apellido);
		buscadorCliente.setNroDocumento(nroDocumento);
		errores = buscadorCliente.buscar(validar);

		req.setAttribute("buscador", buscadorCliente);
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscadorCliente));
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		this.setBuscador(null, null, null, req, false);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if ("borrar".equals(req.getParameter("accion"))) {
			Cliente cliente = new Cliente();

			cliente.setId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("erroresEliminar", cliente.eliminar());

		} else if (req.getParameter("btnBorrar") != null) {
			HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(
					req, "seleccionados_");
			Cliente cliente = new Cliente();

			for (Entry<String, Boolean> row : checkboxValues.entrySet()) {

				cliente.setId(Integer.parseInt(row.getKey()));
				cliente.eliminar();
			}
		}

		this.setBuscador(req.getParameter("nombre"), req.getParameter("apellido"), req.getParameter("nroDocumento"), req,
				req.getParameter("btnAceptar") != null);
		
		super.procesarPost(req, resp);
	}
}
