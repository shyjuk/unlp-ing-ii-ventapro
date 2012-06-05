package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.Producto;

public class BuscarProductoServlet extends ServletPagina{

	private static final long serialVersionUID = 5874040150008001323L;
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException {
		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
//		String action = (String) req.getParameter("action");
//		
//		if (action != null) {
//			if (action.equals("editar")) {
//				// Ir a pag editar tipo de producto
//				despacharJsp("editarProducto.jsp", req, resp);
//			}else if (action.equals("borrar")) {
//				// Borrar tipo de producto
//				String id = (String) req.getParameter("id");
//				Producto object = SucursalUno.getSingleInstance().getProductoCon(id);
//				if (object.esValidoParaEliminar()) {
//					try {
//						SucursalUno.getSingleInstance().eliminar(object);
//						despacharJsp("buscarProducto.jsp", req, resp);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}else if (action.equals("buscar")) {
//				// Ejecutar busqueda de producto
//				String nombre = (String) req.getParameter("nombre");
//				BuscadorProducto buscador = new BuscadorProducto();
//				buscador.setNombre(nombre);
//				buscador.esValidoParaBuscar();
//				req.setAttribute("errores", buscador.getErrores());
//				despacharJsp("buscarProducto.jsp", req, resp);
//			} else if (action.equals("guardarEdicion")) {
//				// guardar datos de tipo de producto editado
//				String id = req.getParameter("id");
//				Producto object = new Producto();
//				object.setId(Integer.valueOf(id == null ? "0" : id));
//				object.setNombre(req.getParameter("nombre"));
//				object.setDescripcion(req.getParameter("descripcion"));
//				if (object.esValidoParaModificar()) {	
//					try {
//						SucursalUno.getSingleInstance().modificar(object);
//						this.despacharJsp("buscarProducto.jsp", req, resp);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}else {
//					req.setAttribute("errores", object.getErrores());
//					despacharJsp("editarProducto.jsp", req, resp);
//				}
//			}else if (action.equals("borrarSeleccionados")){
//				HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(req, "seleccionados_");
//				for (Entry<String, Boolean> row : checkboxValues.entrySet()) {
//					if (row.getValue()) { // value = TRUE (seleccionado)
//						String id = row.getKey();
//						Producto object = SucursalUno.getSingleInstance().getProductoCon(id);
//						if (object.esValidoParaEliminar()) {
//							try {
//								SucursalUno.getSingleInstance().eliminar(object);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				}
//				despacharJsp("buscarProducto.jsp", req, resp);
//			}else  {
//				super.procesarPost(req, resp);
//			}
//		}else {
//			// no deberia entrar por aca
//			super.procesarPost(req, resp);
//		}
		
	} 

}