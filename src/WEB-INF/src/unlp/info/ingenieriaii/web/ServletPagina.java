package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletPagina extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1446047028129827257L;

	private static final String PATH_PAGINAS = "/WEB-INF/paginas/";

	private String nombreJsp(HttpServletRequest req) {
		String[] buff;

		buff = req.getRequestURI().split("/");

		return buff[buff.length - 1];
	}

	private void forzarUtf8(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	}

	protected final void despacharJsp(String nombre, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher(PATH_PAGINAS + nombre).forward(req, resp);
	}

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.forzarUtf8(req, resp);
		this.procesarGet(req, resp);
	}

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.forzarUtf8(req, resp);
		this.procesarPost(req, resp);
	}

	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.despacharJsp(this.nombreJsp(req), req, resp);
	}

	protected void procesarPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		despacharJsp(this.nombreJsp(req), req, resp);
	}
}
