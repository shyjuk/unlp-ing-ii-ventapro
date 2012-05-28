package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class BuscarTipoDeProductoServelt extends ServletPagina{

	private static final long serialVersionUID = 5874040150008001323L;
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = (String) req.getParameter("action");
		if (action != null) {
			if (action.equals("editar")) {
				// Ir a pag editar tipo de producto
				despacharJsp("editarTipoProducto.jsp", req, resp);
			}else if (action.equals("borrar")) {
				// Borrar tipo de producto
				String id = (String) req.getParameter("id");
				TipoDeProducto object = SucursalUno.getSingleInstance().getTipoDeProductoCon(id);
				if (object.esValidoParaEliminar()) {
					try {
						SucursalUno.getSingleInstance().eliminar(object);
						despacharJsp("buscarTipoProducto.jsp", req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else if (action.equals("buscar")) {
				// Ejecutar busqueda de producto
				despacharJsp("buscarTipoProducto.jsp", req, resp);
			} else if (action.equals("guardarEdicion")) {
				// guardar datos de tipo de producto editado
				String id = req.getParameter("id");
				TipoDeProducto object = new TipoDeProducto();
				object.setId(Integer.valueOf(id == null ? "0" : id));
				object.setNombre(req.getParameter("nombre"));
				object.setDescripcion(req.getParameter("descripcion"));
				if (object.esValidoParaModificar()) {	
					try {
						SucursalUno.getSingleInstance().modificar(object);
						this.despacharJsp("buscarTipoProducto.jsp", req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					req.setAttribute("errores", object.getErrores());
					despacharJsp("editarTipoProducto.jsp", req, resp);
				}
			}else  {
				super.procesarPost(req, resp);
			}
		}else {
			// no deberia entrar por aca
			super.procesarPost(req, resp);
		}
		
	} 

}
