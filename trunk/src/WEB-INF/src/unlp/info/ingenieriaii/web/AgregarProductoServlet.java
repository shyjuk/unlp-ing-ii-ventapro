package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.TipoProducto;

import java.sql.SQLException;

public class AgregarProductoServlet extends ServletPagina {

	private static final long serialVersionUID = -6737178893187649667L;

	private void setCombos(HttpServletRequest req) throws SQLException {
		req.setAttribute("marcas", Marca.buscarMarcas(null));
		req.setAttribute("tiposProducto",
				TipoProducto.buscarTiposProducto(null));
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		req.setAttribute("producto", new Producto());
		this.setCombos(req);

		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		Producto producto = new Producto();
		String idMarca = req.getParameter("idMarca");
		String idTipoProducto = req.getParameter("idTipoProducto");
		Errores errores;

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
		producto.setEnVenta("true");
		producto.setDescripcion(req.getParameter("descripcion"));

		errores = producto.guardar();

		if (errores.esVacio()) {

			resp.sendRedirect("buscarProducto.jsp");
		} else {

			req.setAttribute("producto", producto);
			req.setAttribute("tipoProducto", producto);
			req.setAttribute("errores", errores);
			this.setCombos(req);

			super.procesarPost(req, resp);
		}
	}
}