package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import unlp.info.ingenieriaii.test.GeneradorDeDatos;
import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Utiles;

public class SucursalUno {

	private static SucursalUno instance;

	private String nombre;

	private ArrayList<Producto> productos;
	private ArrayList<TipoProducto> tiposDeProducto;

	public static final SucursalUno getSingleInstance() {
		if (instance == null) {
			SucursalUno.setInstance(new SucursalUno());
			instance.setNombre("Sucursal La Loma I");
			instance.setProductos(new ArrayList<Producto>());
			instance.setTiposDeProducto(new ArrayList<TipoProducto>());
		}
		return instance;
	}

	/* ------------ variables de instancia --------------- */

	public static SucursalUno getInstance() {
		return instance;
	}

	public static void setInstance(SucursalUno instance) {
		SucursalUno.instance = instance;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<TipoProducto> getTiposDeProducto() {
		return tiposDeProducto;
	}

	public void setTiposDeProducto(ArrayList<TipoProducto> tiposProductos) {
		this.tiposDeProducto = tiposProductos;
	}

}
