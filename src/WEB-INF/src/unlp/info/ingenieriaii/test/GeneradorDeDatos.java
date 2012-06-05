package unlp.info.ingenieriaii.test;

import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class GeneradorDeDatos {

	public static void generarTiposDeProductos() throws Exception {
		final String[] TIPOS_NOMBRE = { "Cocina", "Heladera", "Microondas",
				"TV", "Lavarropa", "Pequeños", "Accesorios" };
		final String[] TIPOS_DESCRIPCION = { null, null, null,
				null, null, "Artículos decorativos", "Accesorios" };

		for (int i = 0; i < TIPOS_NOMBRE.length; i++) {
			TipoProducto dato = new TipoProducto();
			
			dato.setNombre(TIPOS_NOMBRE[i]);
			dato.setDescripcion(TIPOS_DESCRIPCION[i]);
			dato.guardar();
		}
	}

	public static void generarMarcas() throws Exception {

		Marca dato = new Marca();
		dato.setNombre("Samsung");
		dato.setSitioWeb("www.samsung.com/ar/");
		dato.setContacto("SEASA CONTACT CENTER 0800 333 3733 (Lunes a Viernes de 9 a 18hs)");
		dato.setInfoAdicional("Rodolfo trabajó en atención al cliente de esta marca en Argentina.");
		dato.guardar();

		dato = new Marca();
		dato.setNombre("Philips");
		dato.setSitioWeb("www.philips.com.ar");
		dato.setContacto("0800-888-7532 (Línea Gratuita)\nLunes a Viernes de 8:00 a 20:00 hs\nSábados de 8:00 a 14:00 hs.");
		dato.guardar();
		
		dato = new Marca();
		dato.setNombre("Gafa");
		dato.setSitioWeb("www.gafa.com.ar");
		dato.guardar();

		dato = new Marca();
		dato.setNombre("Domec");
		dato.setContacto("Sitio: http://www.servicedomec.com.ar/\nTeléfono: (011) 4611-4882");
		dato.guardar();
	}
}
