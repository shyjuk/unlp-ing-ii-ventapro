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
import unlp.info.ingenieriaii.modelo.Marca;

public class BuscarMarcaServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8780988681189936206L;

	private String setListaId(BuscadorMarca buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (Marca object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}

	private void setBuscador(String nombre, HttpServletRequest req,
			boolean validar) throws SQLException {
		BuscadorMarca buscadorMarca = new BuscadorMarca();
		Errores errores;

		buscadorMarca.setNombre(nombre);
		errores = buscadorMarca.buscar(validar);

		req.setAttribute("buscador", buscadorMarca);
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscadorMarca));
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
			Marca marca = new Marca();

			marca.setId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("erroresEliminar", marca.eliminar());

		} else if (req.getParameter("btnBorrar") != null) {
			HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(
					req, "seleccionados_");
			Marca marca = new Marca();
			Errores errores = new Errores();
			int i = 0;

			for (Entry<String, Boolean> row : checkboxValues.entrySet()) {

				marca.setId(Integer.parseInt(row.getKey()));
				i += marca.eliminar().esVacio() ? 0 : 1;
			}

			if (i > 0) {
				errores.setGeneral("Advertencia: Hubo marcas que no han podido ser eliminadas.");
				req.setAttribute("erroresEliminar", errores);
			}
		}

		this.setBuscador(req.getParameter("nombre"), req,
				req.getParameter("btnAceptar") != null);

		super.procesarPost(req, resp);
	}
}
