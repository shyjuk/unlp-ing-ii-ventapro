package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class AgregarTipoProductoServlet extends ServletPagina {

	private static final long serialVersionUID = -6737178893187649667L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		req.setAttribute("tipoProducto", new TipoProducto());

		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if (req.getParameter("btnAceptar") != null) {
			TipoProducto tipoProducto= new TipoProducto();
			Errores errores;
			
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
