package unlp.info.ingenieriaii.test;

import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class GeneradorDeDatos {
	
	public static void generarTiposDeProductos () throws Exception {
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
}
