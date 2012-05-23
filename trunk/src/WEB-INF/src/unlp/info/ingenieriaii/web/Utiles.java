package unlp.info.ingenieriaii.web;

public class Utiles {
	
	public static String getNotNullValue (Object object) {
		return object == null ? "" : object.toString();
	}

}
