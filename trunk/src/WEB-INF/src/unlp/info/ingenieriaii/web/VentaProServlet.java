package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VentaProServlet extends ServletPagina {

	private static final long serialVersionUID = -8532993373342222147L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
//		String unAttributo = (String) req.getAttribute("nombreAttributo");

//		try {
//
//			// Aca iria la logica de rediccion
//
//			if (unAttributo != null && unAttributo.equals("ir")) {
//				RequestDispatcher dispatcher = req
//						.getRequestDispatcher("/paginas/buscarTipoProducto.jsp");
//				dispatcher.forward(req, resp);
//			}
//
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// Comportamiento por default es mostrar el JSP propio, si hay que ir a otra parte 
		//usar super.despacharJsp ("super" no hace falta en este en realidad)
		super.doGet(req, resp); 
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
}