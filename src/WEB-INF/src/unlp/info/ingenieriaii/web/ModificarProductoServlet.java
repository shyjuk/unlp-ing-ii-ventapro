package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class ModificarProductoServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6073212867636106868L;

	private void setCombos(HttpServletRequest req) throws SQLException {
		req.setAttribute("marcas", Marca.buscarMarcas(null));
		req.setAttribute("tiposProducto",
				TipoProducto.buscarTiposProducto(null));
	}
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Te haces el pilluelo entrando derecho? Tomá:
		resp.sendRedirect("buscarTipoProducto.jsp");
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException,
			SQLException {
		Producto producto = new Producto();
		Errores errores;

		producto.setId(Utiles.esVacio(req.getParameter("id")) ? null : Integer
				.parseInt(req.getParameter("id")));

		if ("editar".equals(req.getParameter("accion"))) {

			errores = producto.recuperar();
			req.setAttribute("producto", producto);
			req.setAttribute("errores", errores);
			this.setCombos(req);
			super.procesarPost(req, resp);
		} else if (req.getParameter("btnAceptar") != null) {
			String idMarca = req.getParameter("idMarca");
			String idTipoProducto = req.getParameter("idTipoProducto");
			
			producto.setNombre(req.getParameter("nombre"));
			producto.setCodigo(req.getParameter("codigo"));
			producto.setMarca(
					Utiles.esVacio(idMarca) ? null : new Integer(idMarca), false);
			producto.setTipoProducto(Utiles.esVacio(idTipoProducto) ? null
					: new Integer(idTipoProducto), false);
			producto.setPrecio(req.getParameter("precio"));
			producto.setGarantia(req.getParameter("garantia"));
			producto.setStock(req.getParameter("stock"));
			producto.setStockMinimo(req.getParameter("stockMinimo"));
			producto.setEnVenta(req.getParameter("chkPermitir"));
			producto.setDescripcion(req.getParameter("descripcion"));

			errores = producto.guardar();

			if (errores.esVacio()) {

				resp.sendRedirect("buscarProducto.jsp");
			} else {

				req.setAttribute("producto", producto);
				req.setAttribute("errores", errores);
				this.setCombos(req);
				super.procesarPost(req, resp);
			}
		} else
			resp.sendRedirect("buscarProducto.jsp");

	}
}