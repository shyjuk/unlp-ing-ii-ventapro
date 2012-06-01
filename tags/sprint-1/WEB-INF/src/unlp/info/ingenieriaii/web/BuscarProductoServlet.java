package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.ObjetoPersistente;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.Producto;

public class BuscarProductoServlet extends ServletPagina{

	private static final long serialVersionUID = 5874040150008001323L;
	
	private BuscadorProducto setBuscador(String nombre, HttpServletRequest req,
			boolean validar) {
		BuscadorProducto buscadorProd = new BuscadorProducto();

		buscadorProd.setNombre(nombre);
		if (!validar || buscadorProd.esValidoParaBuscar())
			buscadorProd.ejecutarBusqueda();

		req.setAttribute("buscador", buscadorProd);
		return buscadorProd;
	}

	private String setListaId(BuscadorProducto buscador, HttpServletRequest req) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (ObjetoPersistente object : buscador.getResultado())
			lista.add(object.getId());

		req.setAttribute("listaId", lista);
		return lista.toString();
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BuscadorProducto buscador;

		buscador = this.setBuscador(null, req, false);
		this.setListaId(buscador, req);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BuscadorProducto buscador;

		if ("borrar".equals(req.getParameter("accion"))) {
			Producto object = SucursalUno.getProductoCon(req.getParameter("id"));

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
					Producto object = SucursalUno.getProductoCon(row.getKey());
					
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