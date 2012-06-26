package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdInactivosServlet extends ServletPagina {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3669122280388069342L;
	private static final String QUERY_LECTURA = "{call productosInactivos}";
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		req.setAttribute("query",QUERY_LECTURA);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		resp.sendRedirect("productosInactivos.jsp");
	}
}
