package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class AgregarTipoDeProductoServlet extends ServletPagina{

	private static final long serialVersionUID = -6737178893187649667L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TipoDeProducto object = new TipoDeProducto();
		object.setNombre((String) req.getParameter("nombre"));
		object.setDescripcion((String) req.getParameter("descripcion"));
		if (object.esValidoParaCrear()) {
			try {
				SucursalUno.getSingleInstance().agregar(object);
				despacharJsp("buscarTipoProducto.jsp", req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("errores", object.getErrores());
			super.doPost(req, resp);
		}
	}

}
