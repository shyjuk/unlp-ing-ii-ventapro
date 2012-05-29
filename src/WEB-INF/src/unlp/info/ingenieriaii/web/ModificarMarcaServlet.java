package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.SucursalUno;

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
			throws ServletException, IOException {

		if ("editar".equals(req.getParameter("accion"))) {

			req.setAttribute("marca",
					SucursalUno.getMarcaCon(req.getParameter("id")));
			super.procesarPost(req, resp);
		} else if (req.getParameter("btnAceptar") != null) {
			Marca object = new Marca();

			object.setId(Integer.parseInt(req.getParameter("id")));
			object.setNombre(req.getParameter("nombre"));
			object.setSitioWeb(req.getParameter("sitioWeb"));
			object.setContacto(req.getParameter("contacto"));
			object.setInfoAdicional(req.getParameter("infoAdicional"));

			if (object.esValidoParaModificar()) {
				try {
					SucursalUno.modificar(object);
				} catch (Exception e) {
					e.printStackTrace();
				}
				resp.sendRedirect("buscarMarca.jsp");
			} else {

				req.setAttribute("marca", object);
				super.procesarPost(req, resp);
			}
		} else
			resp.sendRedirect("buscarMarca.jsp");
	}
}
