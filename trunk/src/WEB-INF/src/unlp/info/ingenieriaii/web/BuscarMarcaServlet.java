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

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BuscadorMarca buscadorMarca = new BuscadorMarca();

		buscadorMarca.setNombre(null);
		buscadorMarca.ejecutarBusqueda();

		req.setAttribute("buscador", buscadorMarca);

		super.procesarGet(req, resp);
	}

}
