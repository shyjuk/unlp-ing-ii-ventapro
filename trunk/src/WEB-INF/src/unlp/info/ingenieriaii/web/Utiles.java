package unlp.info.ingenieriaii.web;

import java.util.Calendar;
import java.util.HashMap;

public class Utiles {

	public static String getNotNullValue(Object object) {
		return object == null ? "" : object.toString();
	}

	public static boolean esFecha(String dia, String mes, String anio) {
		if (Utiles.esVacio(dia) || Utiles.esVacio(mes) || Utiles.esVacio(anio)) {
			return false;
		} else {
			if (!dia.trim().matches("[0-9]*") || !mes.trim().matches("[0-9]*") || !anio.trim().matches("[0-9]*")) {
				return false;
			} else if (dia.trim().length() > 2 || mes.trim().length() > 2 || anio.trim().length() != 4) {
				return false;
			} else {
				try {
					java.util.Date aDate = new java.util.Date(Integer.valueOf(anio.trim()) - 1900,Integer.valueOf(mes.trim()) - 1, Integer.valueOf(dia.trim()));
					String[] answer = new String[3];
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(aDate);
					answer[0] = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
					answer[1] = String.valueOf(calendar.get(Calendar.MONTH) + 1);
					answer[2] = String.valueOf(calendar.get(Calendar.YEAR));
					if (!dia.trim().endsWith(answer[0]) || !mes.trim().equals(answer[1]) || !anio.trim().equals(answer[2])) {
						return false;
					}
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

	public static String trim(String valor) {

		return valor != null ? valor.trim().replaceAll("\\s+", " ") : null;
	}
	
	public static boolean esAlfa(String valor){
		
		if (valor == null) return false;
		
		valor.replaceAll("\\s+", "");
		
		for (int i = 0; i < valor.length(); i++)
			if (!Character.isLetter(valor.charAt(i)))
				return false;
		
		return true;
	}
}
