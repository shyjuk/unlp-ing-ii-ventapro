package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class BuscarTipoDeProductoServelt extends ServletPagina{

	private static final long serialVersionUID = 5874040150008001323L;
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		BuscadorTipoDeProducto buscador = new BuscadorTipoDeProducto();
		buscador.ejecutarBusqueda();
		req.setAttribute("buscador", buscador);
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
				TipoDeProducto object = SucursalUno.getTipoDeProductoCon(id);
				if (object.esValidoParaEliminar()) {
					try {
						SucursalUno.eliminar(object);
						despacharJsp("buscarTipoProducto.jsp", req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else if (action.equals("buscar")) {
				// Ejecutar busqueda de producto
				String nombre = (String) req.getParameter("nombre");
				BuscadorTipoDeProducto buscador = new BuscadorTipoDeProducto();
				buscador.setNombre(nombre);
				buscador.esValidoParaBuscar();
				buscador.ejecutarBusqueda();
				req.setAttribute("buscador", buscador);
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
						SucursalUno.modificar(object);
						this.despacharJsp("buscarTipoProducto.jsp", req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					req.setAttribute("errores", object.getErrores());
					despacharJsp("editarTipoProducto.jsp", req, resp);
				}
			}else if (action.equals("borrarSeleccionados")){
				HashMap<String, Boolean> checkboxValues = getAllParameterCheckBox(req, "seleccionados_");
				for (Entry<String, Boolean> row : checkboxValues.entrySet()) {
					if (row.getValue()) { // value = TRUE (seleccionado)
						String id = row.getKey();
						TipoDeProducto object = SucursalUno.getTipoDeProductoCon(id);
						if (object.esValidoParaEliminar()) {
							try {
								SucursalUno.eliminar(object);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
				despacharJsp("buscarTipoProducto.jsp", req, resp);
			}else  {
				super.procesarPost(req, resp);
			}
		}else {
			// no deberia entrar por aca
			super.procesarPost(req, resp);
		}
		
	} 

}
