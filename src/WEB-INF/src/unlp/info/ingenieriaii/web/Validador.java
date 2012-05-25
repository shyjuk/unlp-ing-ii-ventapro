package unlp.info.ingenieriaii.web;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	
	

}
