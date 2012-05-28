package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarMarcaServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8780988681189936206L;

	private void setBuscador(String nombre, HttpServletRequest req,
			boolean validar) {
		BuscadorMarca buscadorMarca = new BuscadorMarca();

		buscadorMarca.setNombre(nombre);
		if (!validar || buscadorMarca.esValidoParaBuscar())
			buscadorMarca.ejecutarBusqueda();

		req.setAttribute("buscador", buscadorMarca);
	}

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.setBuscador(null, req, false);
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.setBuscador(req.getParameter("nombre"), req,
				req.getParameter("btnAceptar") != null);
		super.procesarPost(req, resp);
	}
}
