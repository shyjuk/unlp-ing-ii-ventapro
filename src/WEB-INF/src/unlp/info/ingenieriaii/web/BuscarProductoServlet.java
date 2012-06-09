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
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class BuscarProductoServlet extends ServletPagina {

	private static final long serialVersionUID = 5874040150008001323L;

	private String setListaId(BuscadorProducto buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (Producto object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}

	private void setBuscador(String nombre, String codigo, String idMarca,
			String idTipoProducto, String incluirOcultos,
			HttpServletRequest req, boolean validar) throws SQLException {
		BuscadorProducto buscadorProducto = new BuscadorProducto();
		Integer intIdMarca = Utiles.esVacio(idMarca) ? null : new Integer(
				idMarca);
		Integer intIdTipoProducto = Utiles.esVacio(idTipoProducto) ? null
				: new Integer(idTipoProducto);
		Boolean blnIncluirOcultos = Utiles.esVacio(incluirOcultos) ? Boolean.FALSE
				: new Boolean(incluirOcultos);
		Errores errores;

		buscadorProducto.setNombre(Utiles.esVacio(nombre) ? null:nombre);
		buscadorProducto.setCodigo(Utiles.esVacio(codigo) ? null: codigo);
		buscadorProducto.setIdMarca(intIdMarca);
		buscadorProducto.setIdTipoProducto(intIdTipoProducto);
		buscadorProducto.setEnVenta(blnIncluirOcultos ? null : Boolean.TRUE);
		errores = buscadorProducto.buscar(validar);

		req.setAttribute("buscador", buscadorProducto);
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscadorProducto));

		req.setAttribute("marcas", Marca.buscarMarcas(null));
		req.setAttribute("tiposProducto",
				TipoProducto.buscarTiposProducto(null));
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		this.setBuscador(null, null, null, null, null, req, false);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if ("borrar".equals(req.getParameter("accion"))) {
			Producto producto = new Producto();

			producto.setId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("erroresEliminar", producto.eliminar());

		} else if (req.getParameter("btnBorrar") != null) {
			HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(
					req, "seleccionados_");
			Producto producto = new Producto();

			for (Entry<String, Boolean> row : checkboxValues.entrySet()) {

				producto.setId(Integer.parseInt(row.getKey()));
				producto.eliminar();
			}
		}

		this.setBuscador(req.getParameter("nombre"),
				req.getParameter("codigo"), req.getParameter("idMarca"),
				req.getParameter("idTipoProducto"),
				req.getParameter("chkIncluir"), req,
				req.getParameter("btnAceptar") != null);
		super.procesarPost(req, resp);
	}
}