package unlp.info.ingenieriaii.modelo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Item extends ObjetoPersistente<Item, ParEntero>{

	private ParEntero idItem;
	private BigDecimal precio;
	private Integer cantidad;
	private Integer idProducto;
	
	private Producto producto;
	
	private static final String QUERY_BUSQUEDA_ITEMS = "{call buscarItemsDeOrden (?)}";
	
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
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setId(ResultSet rs) throws SQLException {
		ParEntero par = new ParEntero();
		
		par.setPrimero(this.getColumnaInt(rs, "idOrdenVenta"));
		par.setSegundo(this.getColumnaInt(rs, "numero"));
		
		this.setId(par);
	}
	@Override
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return null;
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
	
	
	
}
