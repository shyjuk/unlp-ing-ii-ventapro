package unlp.info.ingenieriaii.modelo;

import unlp.info.ingenieriaii.web.Validador;

public class Producto extends ObjetoPersistente{

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
	
	public boolean esValidoParaCrear()	{
		return super.esValidoParaCrear() && Validador.esValidoProducto(this, this.getErrores());
	}
	
	@Override
	public boolean esValidoParaModificar() {
		return super.esValidoParaModificar() && Validador.esValidoProducto(this, this.getErrores());
	}
	
	@Override
	public boolean esValidoParaEliminar() {
		// AGREGAR TODAS LAS VALIDACIONES DE DATOS REFERENCIALES
		return super.esValidoParaEliminar();
	}

	
}
