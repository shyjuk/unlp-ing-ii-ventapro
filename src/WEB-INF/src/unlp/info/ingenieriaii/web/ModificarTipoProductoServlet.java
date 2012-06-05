package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class ModificarTipoProductoServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 835526157190230619L;

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
		TipoProducto tipoProducto = new TipoProducto();
		Errores errores;

		tipoProducto.setId(Utiles.esVacio(req.getParameter("id")) ? null : Integer
				.parseInt(req.getParameter("id")));

		if ("editar".equals(req.getParameter("accion"))) {

			errores = tipoProducto.recuperar();
			req.setAttribute("tipoProducto", tipoProducto);
			req.setAttribute("errores", errores);
			super.procesarPost(req, resp);
		} else if (req.getParameter("btnAceptar") != null) {

			tipoProducto.setNombre(req.getParameter("nombre"));
			tipoProducto.setDescripcion(req.getParameter("descripcion"));

			errores = tipoProducto.guardar();

			if (errores.esVacio()) {

				resp.sendRedirect("buscarTipoProducto.jsp");
			} else {

				req.setAttribute("tipoProducto", tipoProducto);
				req.setAttribute("errores", errores);
				super.procesarPost(req, resp);
			}
		} else
			resp.sendRedirect("buscarTipoProducto.jsp");

	}
}
