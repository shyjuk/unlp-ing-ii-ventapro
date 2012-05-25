package unlp.info.ingenieriaii.web;

public class Utiles {
	
	public static String getNotNullValue (Object object) {
		return object == null ? "" : object.toString();
	}
	
	// ESTO VUELA CUANDO TENGAMOS LA BD FUNCIONANDO
	public static boolean like (String string1, String string2){
		//You could turn '%string%' to contains(), 'string%' to startsWith() and '%string"' to endsWith().
		if (string1 != null && string2 != null) {
			if (string1.toUpperCase().contains(string2.toUpperCase())) {
				return true;
			}
			if (string1.toUpperCase().startsWith(string2.toUpperCase())) {
				return true;
			}
			if (string1.toUpperCase().endsWith(string2.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

}
