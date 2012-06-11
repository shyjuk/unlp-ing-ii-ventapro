package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Marca;

public class AgregarMarcaServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3050633547558002236L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		req.setAttribute("marca", new Marca());

		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if (req.getParameter("btnAceptar") != null) {
			Marca marca = new Marca();
			Errores errores;

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
