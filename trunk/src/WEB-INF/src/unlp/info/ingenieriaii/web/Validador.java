package unlp.info.ingenieriaii.web;

import java.math.BigDecimal;
import java.math.BigInteger;

import unlp.info.ingenieriaii.modelo.Errores;

public class Validador {

	public static boolean validarLongitud(Errores errores, String nombre,
			String valor, int min, int max) {
		int longitud = Utiles.longitud(valor);

		if (longitud < min && min > 0) {
			if (longitud <= 0)
				errores.setErrorCampo(nombre, "Debe completar este campo.");
			else
				errores.setErrorCampo(nombre, String.format(
						"Debe ingresar al menos %d caracteres.", min));
		} else if (longitud > max)
			errores.setErrorCampo(nombre, String.format(
					"No debe ingresar más de %d caracteres. Usted ingresó %d.",
					max, longitud));
		else
			return true;

		return false;
	}

	public static boolean validarEntero(Errores errores, String nombre,
			String valor, long min, long max, int minDigitos, boolean opcional) {
		boolean esVacio = Utiles.esVacio(valor);
		int maxDigitos = String.valueOf(max).length();
		BigInteger v;
		int longitud;

		if (esVacio) {

			if (opcional)
				return true;

			errores.setErrorCampo(nombre, "Debe completar este campo.");
			return false;
		}

		if (!valor.matches("^\\d+$")) {

			errores.setErrorCampo(nombre, "Debe ingresar dígitos únicamente.");
		} else {

			try {
				v = new BigInteger(valor);
			} catch (Exception e) {
				v = null;
			}
			if (v == null) {

				errores.setErrorCampo(nombre,
						"El valor ingresado no es válido.");
			} else {
				longitud = valor.length();

				if (longitud < minDigitos || longitud > maxDigitos) {

					errores.setErrorCampo(
							nombre,
							String.format(
									"El valor ingresado debe contener entre %d y %d dígitos.",
									minDigitos, maxDigitos));
				} else if (v.compareTo(BigInteger.valueOf(min)) < 0) {

					errores.setErrorCampo(
							nombre,
							String.format(
									"El valor ingresado es menor al mínimo permitido (%d).",
									min));
				} else if (v.compareTo(BigInteger.valueOf(max)) > 0) {

					errores.setErrorCampo(
							nombre,
							String.format(
									"El valor ingresado es mayor al máximo permitido (%d).",
									max));
				} else
					return true;
			}
		}
		return false;
	}

	public static boolean validarEntero(Errores errores, String nombre,
			String valor, long min, long max, boolean opcional) {

		return Validador.validarEntero(errores, nombre, valor, min, max, String
				.valueOf(min).length(), opcional);
	}

	public static boolean validarDecimal(Errores errores, String nombre,
			String valor, int min, int max, int maxDigitosFraccion,
			boolean opcional) {
		boolean esVacio = Utiles.esVacio(valor);
		int minDigitos = String.valueOf(min).length();
		int maxDigitos = String.valueOf(max).length();
		BigDecimal v;
		int longitudV;

		if (esVacio) {

			if (opcional)
				return true;

			errores.setErrorCampo(nombre, "Debe completar este campo.");
			return false;
		}

		if (maxDigitosFraccion < 1)
			maxDigitosFraccion = 1;

		if (!valor.matches("^\\d+(\\.\\d+)?$")) {

			errores.setErrorCampo(nombre,
					"El formato del número no es correcto. Ejemplo de número válido: 101.5");
		} else if (valor.indexOf('.') > 0
				&& valor.length() - valor.indexOf('.') - 1 > maxDigitosFraccion) {

			errores.setErrorCampo(
					nombre,
					String.format(
							"No debe ingresar más de %d dígitos después de la coma/punto.",
							maxDigitosFraccion));
		} else {

			try {
				v = new BigDecimal(valor);
			} catch (Exception e) {
				v = null;
			}
			if (v == null) {

				errores.setErrorCampo(nombre,
						"El valor ingresado no es válido.");
			} else {
				longitudV = v.toPlainString().indexOf('.');
				if (longitudV < 1)
					longitudV = v.toPlainString().length();

				if (longitudV < minDigitos || longitudV > maxDigitos) {

					errores.setErrorCampo(
							nombre,
							String.format(
									"El valor ingresado debe contener entre %d y %d dígitos antes de la coma/punto.",
									minDigitos, maxDigitos));
				} else if (v.compareTo(BigDecimal.valueOf(min)) < 0) {

					errores.setErrorCampo(
							nombre,
							String.format(
									"El valor ingresado es menor al mínimo permitido (%d).",
									min));
				} else if (v.compareTo(BigDecimal.valueOf(max)) > 0) {

					errores.setErrorCampo(
							nombre,
							String.format(
									"El valor ingresado es mayor al máximo permitido (%d).",
									max));
				} else
					return true;
			}
		}
		return false;
	}
	
	public static boolean validarFecha (Errores errores, String nombre, String dia, String mes, String anio, boolean opcional) {
		if (Utiles.esVacio(dia) && Utiles.esVacio(mes) && Utiles.esVacio(anio)) {
			if (!opcional) {
				errores.setErrorCampo(nombre, "Complete la fecha.");
				return false;
			}
		}else {
			if (!Utiles.esFecha(dia, mes, anio)) {
				errores.setErrorCampo(nombre, "La fecha es invalida.");
				return false;
			}
		}
		return true;
	}
}
