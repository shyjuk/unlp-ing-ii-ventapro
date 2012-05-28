package unlp.info.ingenieriaii.test;

import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class GeneradorDeDatos {

	public static void generarTiposDeProductos() throws Exception {
		TipoDeProducto dato = new TipoDeProducto();
		dato.setNombre("Cocina");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		dato = new TipoDeProducto();
		dato.setNombre("Heladera");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		dato = new TipoDeProducto();
		dato.setNombre("Microondas");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		dato = new TipoDeProducto();
		dato.setNombre("TV");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		dato = new TipoDeProducto();
		dato.setNombre("Lavarropa");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		dato = new TipoDeProducto();
		dato.setNombre("Pequeños");
		dato.setDescripcion("aaaaaaaa");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		dato = new TipoDeProducto();
		dato.setNombre("Accesorios");
		dato.setDescripcion("bbbb bbbbbbbbb");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
	}

	public static void generarMarcas() throws Exception {

		Marca dato = new Marca();
		dato.setNombre("Samsung");
		dato.setSitioWeb("www.samsung.com/ar/");
		dato.setContacto("SEASA CONTACT CENTER 0800 333 3733 (Lunes a Viernes de 9 a 18hs)");
		dato.setInfoAdicional("Rodolfo trabajó en atención al cliente de esta marca en Argentina.");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}

		dato = new Marca();
		dato.setNombre("Philips");
		dato.setSitioWeb("www.philips.com.ar");
		dato.setContacto("0800-888-7532 (Línea Gratuita)\nLunes a Viernes de 8:00 a 20:00 hs\nSábados de 8:00 a 14:00 hs.");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
		
		dato = new Marca();
		dato.setNombre("Gafa");
		dato.setSitioWeb("www.gafa.com.ar");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}

		dato = new Marca();
		dato.setNombre("Domec");
		dato.setContacto("Sitio: http://www.servicedomec.com.ar/\nTeléfono: (011) 4611-4882");
		if (dato.esValidoParaCrear()) {
			SucursalUno.agregar(dato);
		}
	}
}
