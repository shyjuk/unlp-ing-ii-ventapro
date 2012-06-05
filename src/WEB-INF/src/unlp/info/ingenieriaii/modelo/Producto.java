package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Validador;

public class Producto extends ObjetoPersistente<Producto, Integer>{

	private int codigo;
	private String nombre;
	private float precio;
	private String marca;
	private String tipoDeProducto;
	private int garantia;
	private int stock;
	private int stockMinimo;
	private String enVenta;
	private String descripcion;
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipoDeProducto() {
		return tipoDeProducto;
	}
	public void setTipoDeProducto(String tipoDeProducto) {
		this.tipoDeProducto = tipoDeProducto;
	}
	//Setters y Getters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public String isEnVenta() {
		return enVenta;
	}
	public void setEnVenta(String enVenta) {
		this.enVenta = enVenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	// Metodos
	
	public Producto() {
		super();
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
	protected Producto getCopia(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void setId(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void manejarErrorDuplicado(Errores errores, Producto copia) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void manejarErrorEnUso(Errores errores) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void manejarErrorReferencia(Errores errores) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
