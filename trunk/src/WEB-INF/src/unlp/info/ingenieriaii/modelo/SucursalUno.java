package unlp.info.ingenieriaii.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import unlp.info.ingenieriaii.test.GeneradorDeDatos;

public class SucursalUno {
	
	private static SucursalUno instance;
	
	private String nombre;
	
	private ArrayList<Producto> productos;
	private ArrayList<Marca> marcas;
	private ArrayList<TipoDeProducto> tiposDeProducto;
	
	public static final SucursalUno getSingleInstance () {
		if (instance == null) {
			SucursalUno.setInstance(new SucursalUno());
			instance.setNombre("Sucursal La Loma I");
			instance.setProductos(new ArrayList<Producto>());
			instance.setMarcas(new ArrayList<Marca>());
			instance.setTiposDeProducto(new ArrayList<TipoDeProducto>());
			try {
				GeneradorDeDatos.generarTiposDeProductos();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	private static void prepararObjetoPersistenteParaCreacion (ObjetoPersistente objetoPersistente) throws Exception {
		if (objetoPersistente == null) {
			throw new Exception("es null");
		}
		if (objetoPersistente.getId() != -1) {
			throw new Exception("ya tiene ID generado");
		}
		objetoPersistente.generarIDAutomatico();
		objetoPersistente.setFechaCreacion(new Date()); // new Date() me da la fecha de hoy
	}
	
	private static void prepararObjetoPersistenteParaEdicion (ObjetoPersistente objetoPersistente) throws Exception {
		if (objetoPersistente == null) {
			throw new Exception("es null");
		}
		if (objetoPersistente.getId() == -1) {
			throw new Exception("el ID no fue generado");
		}
		objetoPersistente.setFechaModificacion(new Date()); // new Date() me da la fecha de hoy
	}
	
	private static void agregarAlHistorialObjetoPersistente (TipoDeAccion tipoAccion, ObjetoPersistente objetoPersistente) throws Exception {
		// ???? completar
	}
	
	public static final void agregar(TipoDeProducto tipoDeProducto) throws Exception {
		prepararObjetoPersistenteParaCreacion(tipoDeProducto);
		getSingleInstance().getTiposDeProducto().add(tipoDeProducto);
		agregarAlHistorialObjetoPersistente(TipoDeAccion.ALTA, tipoDeProducto);
		System.out.println(tipoDeProducto.getId() + tipoDeProducto.getNombre() + tipoDeProducto.getDescripcion());
	}
	
	public static final void modificar (TipoDeProducto tipoDeProducto) throws Exception {
		prepararObjetoPersistenteParaEdicion(tipoDeProducto);
		getSingleInstance().getTiposDeProducto().add(tipoDeProducto);
		agregarAlHistorialObjetoPersistente(TipoDeAccion.EDICION, tipoDeProducto);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<TipoDeProducto> tiposDeProductosOrdenadosPorFecha (){
		ArrayList<TipoDeProducto> lista = (ArrayList<TipoDeProducto>) getSingleInstance().getTiposDeProducto().clone();
		Collections.sort(lista, new ComparableFechaCreacion());
		return lista;
	}
	
	
	/* ------------ variables de instancia ---------------*/

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

	public ArrayList<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(ArrayList<Marca> marcas) {
		this.marcas = marcas;
	}

	public ArrayList<TipoDeProducto> getTiposDeProducto() {
		return tiposDeProducto;
	}

	public void setTiposDeProducto(ArrayList<TipoDeProducto> tiposProductos) {
		this.tiposDeProducto = tiposProductos;
	}
	
	

}
