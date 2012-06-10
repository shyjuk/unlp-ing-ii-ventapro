package unlp.info.ingenieriaii.modelo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	
	// input - esto deberia modificarse usando los objetos reales
	private String comprador;
	private String vendedor;
	
	
	private static final String QUERY_BUSQUEDA = "{call buscarOrden (?,?,?,?,?,?)}";
	private static final String QUERY_BUSQUEDA_ITEMS = "{call buscarItemsDeOrden (?)}";
	private static final String UPDATE_ESTADO = "{call modificarEstadoOrden(?,?)}";
	
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
		this.setComprador(rs);
		this.setVendedor(rs);
		this.setFecha(rs);
	}
	@Override
	protected OrdenDeVenta getCopia(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararAlta(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		db.prepararLlamada(UPDATE_ESTADO);
		db.setParamInt(1, this.getId());
		db.setParamInt(2, Integer.valueOf(this.getEstado()));
	}
	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setId(ResultSet rs) throws SQLException {
		this.setId(this.getColumnaInt(rs, "idOrdenVenta"));
	}
	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();
		// AGREGAR VALIDACIONES FALTANTES
		if (Utiles.esVacio(this.getEstado())) {
			errores.setErrorCampo("estado", "El estado es vacio");
		}else {
			try {
				int num = Integer.valueOf(this.getEstado());
				if (!(Estados.PENDIENTE.getId() == num) && !(Estados.ANULADA.getId() == num) && !(Estados.PAGADA.getId() == num)) {
					errores.setErrorCampo("estado", "El estado es invalido");
				}
			} catch (Exception e) {
				errores.setErrorCampo("estado", "El estado es invalido");
			}
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
		
	public static ArrayList<OrdenDeVenta> buscarOrdenes(AccesoDb db, BuscadorOrden buscador)
			throws SQLException {
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
	
	public void setEstado(ResultSet rs) throws SQLException {
		this.setEstado(this.getColumnaString(rs, "estado"));
	}

	public void setComprador(ResultSet rs) throws SQLException {
		this.setComprador(this.getColumnaString(rs, "comprador"));
	}
	
	public void setVendedor(ResultSet rs) throws SQLException {
		this.setVendedor(this.getColumnaString(rs, "vendedor"));
	}
	
	public void setFecha(ResultSet rs) throws SQLException {
		this.setFecha(this.getColumnaDate(rs, "fechaHora"));
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	public String getCantProductos () {
		int cantidadTotal = 0;
		for (Item item : this.getItems()) {
			cantidadTotal=+ item.getCantidad();
		}
		return String.valueOf(cantidadTotal);
	}
	
	public String getMontoTotal () {
		BigDecimal montoTotal = BigDecimal.ZERO;
		for (Item item : this.getItems()) {
			montoTotal= (item.getPrecio().multiply(new BigDecimal(item.getCantidad()))).add(montoTotal);
		}
		return String.valueOf(montoTotal);
	}
	
	public String getMontoDetalle () {
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
	
	public String getEstadoDescripcion () {
		if (Utiles.esVacio(this.getEstado())) {
			return "";
		}
		return Estados.getDescripcionPara(Integer.valueOf(this.getEstado()));
	}
	

}
