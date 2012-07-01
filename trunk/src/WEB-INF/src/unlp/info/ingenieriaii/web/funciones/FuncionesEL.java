package unlp.info.ingenieriaii.web.funciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

public class FuncionesEL {
	private static final String DIR_BASE = "/VentaPro%20CODE";

	public static boolean esPaginaActual(PageContext context, String path) {
		final String uri = ((HttpServletRequest) context.getRequest())
				.getRequestURI();

		return !path.startsWith("/") ? uri.endsWith("/" + path) : uri
				.equals(path);
	}

	public static String concat(String pri, String sec) {

		return pri.concat(sec);
	}

	public static boolean matches(String input, String regex) {

		return input.matches(regex);
	}

	public static String getPath(String path) {

		return path.startsWith("/") ? DIR_BASE + path : path;
	}

	public static String siPathEmpiezaCon(PageContext context, String path,
			String stringTrue, String stringFalse) {
		String uri = ((HttpServletRequest) context.getRequest())
				.getRequestURI();

		if (uri.startsWith(DIR_BASE))
			uri = uri.replaceFirst("/VentaPro%20CODE", "");

		return uri.equals(path) ? stringTrue : stringFalse;
	}
}
