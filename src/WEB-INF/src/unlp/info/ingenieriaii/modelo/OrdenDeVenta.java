package unlp.info.ingenieriaii.modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.BuscadorOrden;
import unlp.info.ingenieriaii.web.Utiles;

public class OrdenDeVenta extends ObjetoPersistente<OrdenDeVenta, Integer> {

	private String numero;
	private Date fecha;
	private String estado;
	private Integer idCliente;
	private Integer idUsuario;
	private Integer idFactura;
	private List<Item> items;
	private Factura factura;
	private Cliente cliente;
	
	private Errores erroresCliente;
	private Errores errores;

	// input - esto deberia modificarse usando los objetos reales
	private String vendedor;

	private static final String QUERY_BUSQUEDA = "{call buscarOrden (?,?,?,?,?,?)}";
	private static final String QUERY_BUSQUEDA_ORDEN_ACTUAL = "{call buscarOrdenActual (?)}";
	private static final String QUERY_BUSQUEDA_ITEMS = "{call buscarItemsDeOrden (?)}";
	private static final String UPDATE_ESTADO = "{call modificarEstadoOrden(?,?)}";
	private static final String GENERAR_ORDEN = "{call generarOrden(?,?)}";
	private static final String QUERY_ALTA = "{call agregarOrden(?)}";
	private static final String QUERY_BAJA = "{call eliminarOrden (?)}";
	private static final String LEER = "{call leerOrden (?)}";
	public static final String QUERY_ROLLBACK_GENERACION_ORDEN = "{call rollbackGeneracionOrden(?)}";
	

	public OrdenDeVenta(ResultSet rs) throws SQLException {

		this.setDatos(rs);
	}

	public OrdenDeVenta() {
		// TODO Auto-generated constructor stub
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		this.setId(rs);
		this.setEstado(rs);
		this.setVendedor(rs);
		this.setFecha(rs);
		this.setFactura(rs);
		this.setCliente(new Cliente(rs));
	}

	@Override
	protected OrdenDeVenta getCopia(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		db.prepararLlamada(LEER);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void prepararAlta(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_ALTA);
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
		db.setParamTimestamp(1, timestamp);
	}

	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		
		if (this.getEstado().equals(String.valueOf(Estados.PENDIENTE.getId()))) {
			// actualizar orden
			db.prepararLlamada(GENERAR_ORDEN);
			db.setParamInt(1, this.getId());
			db.setParamInt(2, this.getCliente().getId());
		}else {
			// Actualizacion de estado
			db.prepararLlamada(UPDATE_ESTADO);
			db.setParamInt(1, this.getId());
			db.setParamInt(2, Integer.valueOf(this.getEstado()));
		}
	}

	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {
		db.prepararLlamada(QUERY_BAJA);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void setId(ResultSet rs) throws SQLException {
		this.setId(this.getColumnaInt(rs, "idOrdenVenta"));
	}

	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();
		
		if (this.getId() == null) { // no validar nada solo se da de alta con los datos de vendedor y fecha
			return errores; 
		}
		
		
		if (Utiles.esVacio(this.getEstado())) {
			errores.setErrorCampo("estado", "El estado es vacio");
		} else {
			try {
				int num = Integer.valueOf(this.getEstado());
				if (!(Estados.PENDIENTE.getId() == num)
						&& !(Estados.ANULADA.getId() == num)
						&& !(Estados.PAGADA.getId() == num)) {
					errores.setErrorCampo("estado", "El estado es invalido");
				}
				
				if ((Estados.ANULADA.getId() == num) || (Estados.PAGADA.getId() == num)) {
					// si estoy anulando no valido nada mas
					return errores;
				}
				
			} catch (Exception e) {
				errores.setErrorCampo("estado", "El estado es invalido");
			}
		}
		
		if (this.getCliente() == null) { // CAPAZ SE PUEDE COSULTAR POR ID, A ESTA ALTURA EL CLIENTE YA DEBERIA ESTAR REGISTRADO EN LA BD
			errores.setErrorCampo("cliente", "Ingrese el cliente.");
		}else{
			this.setErroresCliente(this.getCliente().validarCampos());
			if (!this.getErroresCliente().esVacio()) {
				errores.setErrorCampo("cliente", "Verifique los datos del cliente.");
			}
		}
		
		if (this.getItems() == null || this.getItems().isEmpty()) {
			errores.setErrorCampo("items", "No ha agregado ningun producto a la orden.");
		}else{
			// validacion para cada item
		}
		
		return errores;
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, OrdenDeVenta copia) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void manejarErrorReferencia(Errores errores, ResultSet rs)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	public static ArrayList<OrdenDeVenta> buscarOrdenes(AccesoDb db,
			BuscadorOrden buscador) throws SQLException {
		ArrayList<OrdenDeVenta> resultado = new ArrayList<OrdenDeVenta>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, buscador.getDni());
		db.setParamVarchar(2, buscador.getNombre());
		db.setParamVarchar(3, buscador.getVendedor());
		db.setParamVarchar(4, buscador.getProducto());
		db.setParamDate(5, buscador.getFecha());
		db.setParamVarchar(6, buscador.getEstado());

		rs = db.ejecutarQuery();

		while (rs.next()) {
			resultado.add(new OrdenDeVenta(rs));
		}

		for (OrdenDeVenta orden : resultado) {
			db.prepararLlamada(QUERY_BUSQUEDA_ITEMS);
			db.setParamInt(1, orden.getId());
			rs = db.ejecutarQuery();
			while (rs.next()) {
				orden.getItems().add(new Item(rs));
			}
		}

		db.cerrarQuery();
		return resultado;
	}

	public static ArrayList<OrdenDeVenta> buscarOrdenes(BuscadorOrden buscador)
			throws SQLException {

		return buscarOrdenes(new AccesoDb(), buscador);
	}
	
	public static OrdenDeVenta buscarOrdenActual() throws SQLException {
		ArrayList<OrdenDeVenta> resultado = buscarOrdenActual(new AccesoDb(), Estados.ARMANDOSE);
		return resultado.isEmpty()? null : resultado.get(0);
	}
	
	public static ArrayList<OrdenDeVenta> buscarOrdenActual(AccesoDb db, Estados estado) throws SQLException {
		ArrayList<OrdenDeVenta> resultado = new ArrayList<OrdenDeVenta>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA_ORDEN_ACTUAL);
		db.setParamInt(1, 1); // ID DEL UNICO VENDEDOR
		rs = db.ejecutarQuery();

		while (rs.next()) {
			resultado.add(new OrdenDeVenta(rs));
		}

		// ESTO PARECE NO SER NECESARIO, VER SI SACARLO
		for (OrdenDeVenta orden : resultado) {
			db.prepararLlamada(QUERY_BUSQUEDA_ITEMS);
			db.setParamInt(1, orden.getId());
			rs = db.ejecutarQuery();
			while (rs.next()) {
				orden.getItems().add(new Item(rs));
			}
		}

		db.cerrarQuery();
		return resultado;
	}

	public void rollbackGeneracion () {
		AccesoDb db = new AccesoDb();
		try {
			db.prepararLlamada(QUERY_ROLLBACK_GENERACION_ORDEN);
			db.setParamInt(1, this.getId()); 
			db.ejecutarQuery();
			db.cerrarQuery();
			this.getFactura().setId((Integer)null);
			for (Item items : this.getItems()) {
				items.setId((ParEntero)null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setEstado(ResultSet rs) throws SQLException {
		this.setEstado(this.getColumnaString(rs, "estado"));
	}

	public void setVendedor(ResultSet rs) throws SQLException {
		this.setVendedor(this.getColumnaString(rs, "vendedor"));
	}

	public void setFecha(ResultSet rs) throws SQLException {
		Timestamp timestamp = this.getColumnaTimestamp(rs, "fechaHora");
		if (timestamp != null) {
			
		}
		this.setFecha(timestamp != null ? new Date(timestamp.getTime()) : null);
	}

	public String getComprador() {
		return this.getCliente().getNroDocumento() + " - " + this.getCliente().getNombre();
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getCantProductos() {
		int cantidadTotal = 0;
		for (Item item : this.getItems()) {
			cantidadTotal = cantidadTotal + item.getCantidad();
		}
		return String.valueOf(cantidadTotal);
	}

	public String getMontoDetalle() {
		if (this.getFactura() != null) {
			Integer mp = this.getFactura().getMedioPago();
			return mp != null ? MediosDePago.getDescripcionPara(mp) : "";
		}
		return "";
	}

	public List<Item> getItems() {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getEstadoDescripcion() {
		if (Utiles.esVacio(this.getEstado())) {
			return "";
		}
		return Estados.getDescripcionPara(Integer.valueOf(this.getEstado()));
	}

	public Factura getFactura() {
		if (factura == null && this.getId() != null) {
			factura = new Factura();
			factura.setOrdenDeVenta(this);
		}
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	protected void setFactura(ResultSet rs) throws SQLException {

		this.setFactura(new Factura(rs));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getFechaString () {
		if (this.getFecha() != null) {
		     SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy hh:mm aaa");		        
		     return formateador.format(this.getFecha());
		}
		return "";
	}

	public Errores getErroresCliente() {
		return erroresCliente;
	}

	public void setErroresCliente(Errores erroresCliente) {
		this.erroresCliente = erroresCliente;
	}

	public Errores getErrores() {
		return errores;
	}

	public void setErrores(Errores errores) {
		this.errores = errores;
	}
	
}
