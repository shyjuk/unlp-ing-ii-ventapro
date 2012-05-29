package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.ObjetoPersistente;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.Marca;

public class BuscarMarcaServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8780988681189936206L;

	private BuscadorMarca setBuscador(String nombre, HttpServletRequest req,
			boolean validar) {
		BuscadorMarca buscadorMarca = new BuscadorMarca();

		buscadorMarca.setNombre(nombre);
		if (!validar || buscadorMarca.esValidoParaBuscar())
			buscadorMarca.ejecutarBusqueda();

		req.setAttribute("buscador", buscadorMarca);
		return buscadorMarca;
	}

	private String setListaId(BuscadorMarca buscador, HttpServletRequest req) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (ObjetoPersistente object : buscador.getResultado())
			lista.add(object.getId());

		req.setAttribute("listaId", lista);
		return lista.toString();
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BuscadorMarca buscador;

		buscador = this.setBuscador(null, req, false);
		this.setListaId(buscador, req);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BuscadorMarca buscador;

		if ("borrar".equals(req.getParameter("accion"))) {
			Marca object = SucursalUno.getMarcaCon(req.getParameter("id"));

			if (object.esValidoParaEliminar()) {
				try {
					SucursalUno.eliminar(object);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else if (req.getParameter("btnBorrar") != null) {
			HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(
					req, "seleccionados_");

			for (Entry<String, Boolean> row : checkboxValues.entrySet()) {
				
				if (row.getValue()) {
					Marca object = SucursalUno.getMarcaCon(row.getKey());
					
					if (object.esValidoParaEliminar()) {
						try {
							SucursalUno.eliminar(object);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		buscador = this.setBuscador(req.getParameter("nombre"), req,
				req.getParameter("btnAceptar") != null);
		this.setListaId(buscador, req);
		super.procesarPost(req, resp);
	}
}
