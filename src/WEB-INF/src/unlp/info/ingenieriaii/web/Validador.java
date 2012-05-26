package unlp.info.ingenieriaii.web;

import java.util.ArrayList;
import java.util.HashMap;

import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class Validador {
	
	public static final String ERROR_GENERICO = "GENERICO";
	
	public static boolean esValidoTipoDeProducto (TipoDeProducto tipoDeProducto, HashMap<String, String> errores) {
		errores.clear();
		if (tipoDeProducto.getNombre() == null || tipoDeProducto.getNombre().length() == 0) {
			errores.put("nombre", "Complete el campo.");
			return false;
		}
		if (tipoDeProducto.getNombre().length() > 50) {
			errores.put("nombre", "Ingrese entre 1 y 50 caracteres.");
			return false;
		}
		if (tipoDeProducto.getDescripcion() != null && tipoDeProducto.getDescripcion().length() > 100) {
			errores.put("descripcion", "Ingrese entre 0 y 100 caracteres.");
			return false;
		}
		if (estaRepetido(tipoDeProducto)) {
			errores.put("nombre", "El tipo de producto ya existe.");
		}
		return true;
	}
	
	
	public static boolean esValidoProducto (Producto producto, HashMap<String, String> errores) {
		errores.clear();
		if (producto.getCodigo() == 0) {
			errores.put("Codigo", "Complete el campo.");
			return false;
		}
		if (producto.getNombre() == null || producto.getNombre().length() == 0) {
			errores.put("Nombre", "Complete el campo.");
			return false;
		}
		if (producto.getNombre().length() > 50) {
			errores.put("Nombre", "Ingrese entre 1 y 50 caracteres.");
			return false;
		}
		if (producto.getPrecio() == 0) {
			errores.put("Precio", "Complete el campo.");
			return false;
		}
		if (producto.getStock() == ' ') {
			errores.put("Stock", "Complete el campo.");
			return false;
		}
		if (producto.getStockMinimo() == ' ') {
			errores.put("Stock Minimo", "Complete el campo.");
			return false;
		}
		if (producto.getGarantía() != 'Y' || producto.getGarantía()!=  'N'  ) {
			errores.put("Garantia", "Complete el campo.");
			return false;
		}
		if (producto.getDescripcion().length() > 100) {
			errores.put("Descripcion", "Ingrese entre 1 y 100 caracteres.");
			return false;
		}
		if (estaRepetido(producto)) {
			errores.put("Nombre", "El producto ya existe.");
		}
		return true;
	}
	
	private static boolean estaRepetido (TipoDeProducto tipoDeProducto) {
		ArrayList<TipoDeProducto> todos = SucursalUno.getSingleInstance().getTiposDeProducto();
		for (TipoDeProducto tipoProducto : todos) {
			if (tipoProducto.getNombre().equalsIgnoreCase(tipoDeProducto.getNombre()) 
					&& tipoProducto.getId() != tipoDeProducto.getId()) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean estaRepetido (Producto producto) {
		ArrayList<Producto> todos = SucursalUno.getSingleInstance().getProductos();
		for (Producto productos : todos) {
			if (productos.getNombre().equalsIgnoreCase(producto.getNombre()) 
					&& productos.getId() != producto.getId()) {
				return true;
			}
		}
		return false;
	}
	

}
