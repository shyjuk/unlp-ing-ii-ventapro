package unlp.info.ingenieriaii.web;

import java.util.HashMap;

public class Utiles {

	public static String getNotNullValue(Object object) {
		return object == null ? "" : object.toString();
	}

	public static boolean esFecha(String dia, String mes, String anio) {
		if (Utiles.esVacio(dia) || Utiles.esVacio(mes) || Utiles.esVacio(anio) ) {
			return false;
		}else{
			if (!dia.trim().matches("[0-9]*") ||
					!mes.trim().matches("[0-9]*") ||
					!anio.trim().matches("[0-9]*")) {
				return false;
			}else{
				try {
					java.util.Date date = new java.util.Date(Integer.valueOf(anio)-1900,Integer.valueOf(mes) -1 , Integer.valueOf(dia));
				} catch (Exception e) {
					return false;
				}
				
			}
		}
		return true;
	}

	public static boolean esVacio(String valor) {

		return valor == null || valor.isEmpty();
	}

	public static int longitud(String valor) {

		return valor != null ? valor.length() : -1;
	}

	public static String join(String delim, String... strings) {
		StringBuilder sb = new StringBuilder();
		int i;

		for (i = 0; i < strings.length - 1; i++) {
			sb.append(strings[i]);
			sb.append(delim);
		}

		sb.append(strings[i]);
		return sb.toString();
	}

	public static boolean estaCompletado(String nombreCampo, String valor,
			HashMap<String, String> errores) {
	
		if (!esVacio(valor))
			return true;
	
		errores.put(nombreCampo, "Complete el campo.");
		return false;
	}
}
