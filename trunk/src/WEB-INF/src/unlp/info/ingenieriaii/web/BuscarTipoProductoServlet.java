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
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class BuscarTipoProductoServlet extends ServletPagina {

	private static final long serialVersionUID = 5874040150008001323L;

	private String setListaId(BuscadorTipoProducto buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (TipoProducto object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}

	private void setBuscador(String nombre, HttpServletRequest req,
			boolean validar) throws SQLException {
		BuscadorTipoProducto buscadorTipoProducto = new BuscadorTipoProducto();
		Errores errores;

		buscadorTipoProducto.setNombre(nombre);
		errores = buscadorTipoProducto.buscar(validar);

		req.setAttribute("buscador", buscadorTipoProducto);
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscadorTipoProducto));
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

		if ("borrar".equals(req.getParameter("accion"))) {
			TipoProducto tipoProducto = new TipoProducto();

			tipoProducto.setId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("erroresEliminar", tipoProducto.eliminar());

		} else if (req.getParameter("btnBorrar") != null) {
			HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(
					req, "seleccionados_");
			TipoProducto tipoProducto = new TipoProducto();

			for (Entry<String, Boolean> row : checkboxValues.entrySet()) {

				tipoProducto.setId(Integer.parseInt(row.getKey()));
				tipoProducto.eliminar();
			}
		}

		this.setBuscador(req.getParameter("nombre"), req,
				req.getParameter("btnAceptar") != null);
		super.procesarPost(req, resp);
	}
}
