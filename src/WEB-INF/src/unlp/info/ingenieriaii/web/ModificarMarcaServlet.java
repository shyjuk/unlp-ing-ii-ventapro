package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Marca;

public class ModificarMarcaServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4459235876274309436L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Te haces el pilluelo entrando derecho? Tomá:
		resp.sendRedirect("buscarMarca.jsp");
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException,
			SQLException {
		Marca marca = new Marca();
		Errores errores;

		marca.setId(Utiles.esVacio(req.getParameter("id")) ? null : Integer
				.parseInt(req.getParameter("id")));

		if ("editar".equals(req.getParameter("accion"))) {

			errores = marca.recuperar();
			req.setAttribute("marca", marca);
			req.setAttribute("errores", errores);
			super.procesarPost(req, resp);
		} else if (req.getParameter("btnAceptar") != null) {

			marca.setNombre(req.getParameter("nombre"));
			marca.setSitioWeb(req.getParameter("sitioWeb"));
			marca.setContacto(req.getParameter("contacto"));
			marca.setInfoAdicional(req.getParameter("infoAdicional"));

			errores = marca.guardar();

			if (errores.esVacio()) {

				resp.sendRedirect("buscarMarca.jsp");
			} else {

				req.setAttribute("marca", marca);
				req.setAttribute("errores", errores);
				super.procesarPost(req, resp);
			}
		} else
			resp.sendRedirect("buscarMarca.jsp");

	}
}
