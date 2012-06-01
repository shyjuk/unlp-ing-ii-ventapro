package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.SucursalUno;

public class AgregarMarcaServlet extends ServletPagina {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3050633547558002236L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setAttribute("marca", new Marca());
		
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Marca object = new Marca();
		
		
		object.setNombre(req.getParameter("nombre"));
		object.setSitioWeb(req.getParameter("sitioWeb"));
		object.setContacto(req.getParameter("contacto"));
		object.setInfoAdicional(req.getParameter("infoAdicional"));
		
		if (object.esValidoParaCrear()) {
			try {
				SucursalUno.agregar(object);
				//despacharJsp("buscarTipoProducto.jsp", req, resp);
				resp.sendRedirect("buscarMarca.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("marca", object);
			super.procesarPost(req, resp);
		}
	}
}
