package unlp.info.ingenieriaii.modelo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class Item extends ObjetoPersistente<Item, ParEntero>{

	private ParEntero idItem;
	private BigDecimal precio;
	private Integer cantidad;
	private Integer idProducto;
	
	private Producto producto;
	private OrdenDeVenta ordenDeVenta;
	
	private Errores errores;
	
	private static final String QUERY_BUSQUEDA_ITEMS = "{call buscarItemsDeOrden (?)}";
	private static final String SQL_GENERAR_ITEM = "{call generarOrdenItem (?,?,?,?,?)}";
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item (ResultSet rs) throws SQLException {
		this.setDatos(rs);
		
	}
	
	
	public ParEntero getIdItem() {
		return idItem;
	}
	public void setIdItem(ParEntero idItem) {
		this.idItem = idItem;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdOrden() {
		return this.getId().getPrimero();
	}
	public void setIdOrden(Integer idOrden) {
		this.getId().setPrimero(idOrden);
	}
	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		this.setId(rs);
		this.setProducto(rs);
		this.setPrecio(rs);
		this.setCantidad(rs);
	}
	@Override
	protected Item getCopia(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararAlta(AccesoDb db) throws SQLException {
		db.prepararLlamada(SQL_GENERAR_ITEM);
		db.setParamInt(1, this.getOrdenDeVenta().getId());
		db.setParamInt(2, this.getProducto().getId());
		db.setParamInt(3, this.getCantidad());
		db.setParamInt(4, 1); // ver si esto lo usamos en algun lado
		db.setParamDecimal(5, this.getPrecio());
	}
	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		// NO HAY MODIFICACIONES DE ITEMS
	}
	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {
		// NO HAY BAJAS DE ITEMS
	}
	@Override
	protected void setId(ResultSet rs) throws SQLException {
		ParEntero par = new ParEntero();
		
		par.setPrimero(this.getColumnaInt(rs, "idOrdenVenta"));
		par.setSegundo(this.getColumnaInt(rs, "idProducto"));
		
		this.setId(par);
	}
	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();
		Validador.validarDecimal(errores, "precio", Utiles.getNotNullValue(this.getPrecio()), 0, 50000, 2, false);
		if (this.getProducto() == null || this.getProducto().getId() == null) {
			errores.setErrorCampo("producto", "El producto no es valido");
			return errores;
		}
		errores = this.getProducto().recuperar(); // Debo obtener el producto actualizado (stock)
		if (!errores.esVacio()) {
			errores.setErrorCampo("producto", "El producto no es valido");
			return  errores;
		}
		
		if (Integer.valueOf(this.getProducto().getStock()) < 1) {
			errores.setErrorCampo("cantidad", "Este producto no esta en stock.");
			return errores;
		}
		
		Validador.validarEntero(errores, "cantidad", Utiles.getNotNullValue(this.getCantidad()), 1, Integer.valueOf(this.getProducto().getStock()), false);
		
		
		return errores;
	}
	
	public Errores esValido () {
		return this.validarCampos();
	}
	
	@Override
	protected void manejarErrorDuplicado(Errores errores, Item copia) {
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
	
	public static ArrayList<Item> buscarItems(int idOrden) throws SQLException {
		return buscarItem(new AccesoDb(), idOrden);
	}
	
	public static ArrayList<Item> buscarItem(AccesoDb db, int idOrden) throws SQLException {
		ArrayList<Item> resultado = new ArrayList<Item>();
		ResultSet rs;
		 
		db.prepararLlamada(QUERY_BUSQUEDA_ITEMS);
		db.setParamInt(1,idOrden);
		
		rs = db.ejecutarQuery();

		while (rs.next()) {
			resultado.add(new Item(rs));
		}
		
		db.cerrarQuery();
		return resultado;
	}
	
	public void setCantidad (ResultSet rs) throws SQLException {
		this.setCantidad(this.getColumnaInt(rs, "cantidad"));
	}
	
	public void setPrecio (ResultSet rs) throws SQLException {
		this.setPrecio(this.getColumnaDecimal(rs, "precioUnitario"));
	}
	
	public void setProducto (ResultSet rs) throws SQLException {
		this.setProducto(new Producto(rs));
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public OrdenDeVenta getOrdenDeVenta() {
		return ordenDeVenta;
	}

	public void setOrdenDeVenta(OrdenDeVenta ordenDeVenta) {
		this.ordenDeVenta = ordenDeVenta;
	}

	public Errores getErrores() {
		return errores;
	}

	public void setErrores(Errores errores) {
		this.errores = errores;
	}
	
	
	
}
