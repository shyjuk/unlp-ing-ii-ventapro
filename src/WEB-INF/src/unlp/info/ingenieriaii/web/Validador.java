package unlp.info.ingenieriaii.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class Validador {

	public static final String ERROR_GENERICO = "GENERICO";

	public static boolean esValidoTipoDeProducto(TipoDeProducto tipoDeProducto,
			HashMap<String, String> errores) {
		errores.clear();
		if (tipoDeProducto.getNombre() == null
				|| tipoDeProducto.getNombre().length() == 0) {
			errores.put("nombre", "Complete el campo.");
			return false;
		}
		if (tipoDeProducto.getNombre().length() > 50) {
			errores.put("nombre", "Ingrese entre 1 y 50 caracteres.");
			return false;
		}
		if (tipoDeProducto.getDescripcion() != null
				&& tipoDeProducto.getDescripcion().length() > 100) {
			errores.put("descripcion", "Ingrese entre 0 y 100 caracteres.");
			return false;
		}
		if (estaRepetido(tipoDeProducto)) {
			errores.put("nombre", "El tipo de producto ya existe.");
			return false;
		}
		return true;
	}

	public static boolean esValidoMarca(Marca marca,
			HashMap<String, String> errores) {
		boolean resultado;
		int longitud;
		String sitioWeb;

		errores.clear();

		if ((resultado = estaCompletado("nombre", marca.getNombre(), errores))
				&& Utiles.longitud(marca.getNombre()) > 50) {

			errores.put("nombre", "El nombre excede los 50 caracteres.");
			resultado = false;
		}

		if ((longitud = Utiles.longitud(sitioWeb = marca.getSitioWeb())) > 0) {

			if (longitud > 100) {

				errores.put("sitioWeb",
						"La URL del sitio web excede los 100 caracteres.");
				resultado = false;
			} 

			try {
				new URL(sitioWeb);
			} catch (MalformedURLException e) {

				errores.put("sitioWeb", "La URL del sitio web no es válida.");
				resultado = false;
			}
		}

		if (Utiles.longitud(marca.getContacto()) > 1000) {

			errores.put("contacto",
					"La información de contacto excede los 1000 caracteres");
			resultado = false;
		} 

		if (Utiles.longitud(marca.getInfoAdicional()) > 1000) {

			errores.put("infoAdicional",
					"La información adicional excede los 1000 caracteres");
			resultado = false;
		} 

		if (resultado & estaRepetido(marca)) {

			errores.put("nombre", "La marca ya existe.");
			resultado = false;
		}

		return resultado;
	}
	

	public static boolean esValidoProducto(Producto producto,
			HashMap<String, String> errores) {
		errores.clear();
		boolean resultado;
		
		resultado=true;
		if (producto.getCodigo() == 0) {
			errores.put("codigo", "Codigo: Complete el campo.");
			resultado = false;
		}
		if (producto.getNombre() == null || producto.getNombre().length() == 0) {
			errores.put("nombre", "Nombre: Complete el campo.");
			resultado = false;
		}
		if (producto.getMarca() == null || producto.getMarca().length() == 0) {
			errores.put("marca", "Marca: Complete el campo.");
			resultado = false;
		}
		if (producto.getTipoDeProducto() == null || producto.getTipoDeProducto().length() == 0 || producto.getTipoDeProducto() == " ") {
			errores.put("tipoDeProducto", "Tipo: Complete el campo.");
			resultado = false;
		}
		if (producto.getNombre().length() > 50) {
			errores.put("mombre", "Nombre: Ingrese entre 1 y 50 caracteres.");
			resultado = false;
		}
		if (producto.getPrecio() == 0) {
			errores.put("precio", "Precio: Complete el campo.");
			resultado = false;
		}
		if (producto.getStock() == 0) {
			errores.put("stock", "Stock: Complete el campo.");
			resultado = false;
		}
		if (producto.getGarantia()==0) {
			errores.put("garantia", "Garantia: Complete el campo.");
			resultado = false;
		}
		if (producto.getDescripcion() != null && producto.getDescripcion().length()>255) {
			errores.put("descripcion", "Descripcion: Coloque entre 1 y 255 caracteres.");
			resultado = false;
		}
		if (estaRepetido(producto)) {
			errores.put("nombre", "El producto ya existe.");
			resultado = false;
		}
		return resultado;
	}

	public static boolean estaCompletado(String nombreCampo, String valor,
			HashMap<String, String> errores) {

		if (!Utiles.esVacio(valor))
			return true;

		errores.put(nombreCampo, "Complete el campo.");
		return false;
	}

	private static boolean estaRepetido(TipoDeProducto tipoDeProducto) {
		ArrayList<TipoDeProducto> todos = SucursalUno.getSingleInstance()
				.getTiposDeProducto();
		for (TipoDeProducto tipoProducto : todos) {
			if (tipoProducto.getNombre().equalsIgnoreCase(
					tipoDeProducto.getNombre())
					&& tipoProducto.getId() != tipoDeProducto.getId()) {
				return true;
			}
		}
		return false;
	}

	private static boolean estaRepetido(Marca marca) {
		ArrayList<Marca> todos = SucursalUno.getSingleInstance().getMarcas();
		String nombre = marca.getNombre();
		int id = marca.getId();

		for (Marca m : todos) {

			if (m.getNombre().equalsIgnoreCase(nombre) && m.getId() != id)
				return true;
		}

		return false;
	}

	private static boolean estaRepetido(Producto producto) {
		ArrayList<Producto> todos = SucursalUno.getSingleInstance()
				.getProductos();
		for (Producto productos : todos) {
			if (productos.getNombre().equalsIgnoreCase(producto.getNombre())
					&& productos.getId() != producto.getId()) {
				return true;
			}
		}
		return false;
	}

}
