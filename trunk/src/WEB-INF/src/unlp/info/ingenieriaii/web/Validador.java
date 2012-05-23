package unlp.info.ingenieriaii.web;

import java.util.HashMap;

import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class Validador {
	
	public static boolean esValidoTipoDeProducto (TipoDeProducto tipoDeProducto) {
		HashMap<String, String> errores = new HashMap<String, String>();
		boolean esValido = (tipoDeProducto != null);
		
		return esValido;
	}
	
	
	
	

}
