package unlp.info.ingenieriaii.modelo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Validador;

public class Producto extends ObjetoPersistente<Producto, Integer> {

	private static final String TABLA_PRODUCTOS = "tbl_productos";

	private static final String QUERY_LECTURA = "{call leerProducto (?)}";

	private static final String QUERY_BUSQUEDA = "{call buscarProducto (?, ?, ?, ?, ?)}";

	private static final String QUERY_ALTA = "{call agregarProducto (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	private static final String QUERY_MODIFICACION = "{call modificarProducto (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	private static final String QUERY_BAJA = "{call eliminarProducto (?)}";

	private String codigo;
	private String nombre;
	private String precio;
	private Marca marca;
	private TipoProducto tipoProducto;
	private String garantia;
	private String stock;
	private String stockMinimo;
	private String enVenta;
	private String descripcion;

	@Override
	protected void setDatos(ResultSet rs) throws SQLException {

		this.setId(rs);
		this.setCodigo(rs);
		this.setPrecio(rs);
		this.setMarca(rs);
		this.setTipoProducto(rs);
		this.setGarantia(rs);
		this.setStock(rs);
		this.setStockMinimo(rs);
		this.setEnVenta(rs);
		this.setDescripcion(rs);
	}

	@Override
	protected Producto getCopia(ResultSet rs) throws SQLException {

		return new Producto(rs);
	}

	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_LECTURA);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void prepararAlta(AccesoDb db) throws SQLException {
		String tmp;

		db.prepararLlamada(QUERY_ALTA);
		db.setParamInt(1, this.getMarca().getId());
		db.setParamInt(2, this.getTipoProducto().getId());
		db.setParamVarchar(3, this.getCodigo());
		db.setParamVarchar(4, this.getNombre());
		db.setParamDecimal(5, new BigDecimal(this.getPrecio()));
		db.setParamInt(6, (tmp = this.getGarantia()) != null ? new Integer(tmp)
				: null);
		db.setParamInt(7, new Integer(this.getStock()));
		db.setParamInt(8, (tmp = this.getStockMinimo()) != null ? new Integer(
				tmp) : null);
		db.setParamBoolean(9, new Boolean(this.getEnVenta()));
		db.setParamVarchar(10, this.getDescripcion());
	}

	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		String tmp;

		db.prepararLlamada(QUERY_MODIFICACION);
		db.setParamInt(1, this.getId());
		db.setParamInt(2, this.getMarca().getId());
		db.setParamInt(3, this.getTipoProducto().getId());
		db.setParamVarchar(4, this.getCodigo());
		db.setParamVarchar(5, this.getNombre());
		db.setParamDecimal(6, new BigDecimal(this.getPrecio()));
		db.setParamInt(7, (tmp = this.getGarantia()) != null ? new Integer(tmp)
				: null);
		db.setParamInt(8, new Integer(this.getStock()));
		db.setParamInt(9, (tmp = this.getStockMinimo()) != null ? new Integer(
				tmp) : null);
		db.setParamBoolean(10, new Boolean(this.getEnVenta()));
		db.setParamVarchar(11, this.getDescripcion());
	}

	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_BAJA);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void setId(ResultSet rs) throws SQLException {

		this.setId(AccesoDb.getColumnaInt(rs, TABLA_PRODUCTOS, "idProducto"));
	}

	@Override
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return new Errores();
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, Producto copia) {

		errores.setErrorCampo("codigo",
				"Ya existe un producto con este código.");
	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {

		errores.setGeneral("No es posible eliminar un producto cuando hay ventas registradas del mismo.");
	}

	@Override
	protected void manejarErrorReferencia(Errores errores, ResultSet rs)
			throws SQLException {
		// TODO Auto-generated method stub
		rs.getInt("idMarca");
		if (rs.wasNull())
			errores.setErrorCampo("marca",
					"La marca que había seleccionado ya no se encuentra disponible.");

		rs.getInt("idTipoProducto");
		if (rs.wasNull())
			errores.setErrorCampo("tipoProducto",
					"El tipo de producto que había seleccionado ya no se encuentra disponible.");
	}

	protected void setCodigo(ResultSet rs) throws SQLException {

		this.setCodigo(String.valueOf(AccesoDb.getColumnaInt(rs,
				TABLA_PRODUCTOS, "codigo")));
	}

	protected void setNombre(ResultSet rs) throws SQLException {

		this.setNombre(AccesoDb.getColumnaString(rs, TABLA_PRODUCTOS, "nombre"));
	}

	protected void setPrecio(ResultSet rs) throws SQLException {

		this.setPrecio(AccesoDb
				.getColumnaDecimal(rs, TABLA_PRODUCTOS, "precio").toString());
	}

	protected void setMarca(ResultSet rs) throws SQLException {

		this.setMarca(new Marca(rs));
	}

	protected void setTipoProducto(ResultSet rs) throws SQLException {

		this.setTipoProducto(new TipoProducto(rs));
	}

	protected void setGarantia(ResultSet rs) throws SQLException {
		Integer valor = AccesoDb.getColumnaInt(rs, TABLA_PRODUCTOS, "garantia");

		this.setGarantia(valor != null ? valor.toString() : null);
	}

	protected void setStock(ResultSet rs) throws SQLException {

		this.setStock(String.valueOf(AccesoDb.getColumnaInt(rs,
				TABLA_PRODUCTOS, "stock")));
	}

	protected void setStockMinimo(ResultSet rs) throws SQLException {
		Integer valor = AccesoDb.getColumnaInt(rs, TABLA_PRODUCTOS,
				"stockMinimo");

		this.setStockMinimo(valor != null ? valor.toString() : null);
	}

	protected void setEnVenta(ResultSet rs) throws SQLException {

		this.setEnVenta(String.valueOf(AccesoDb.getColumnaBoolean(rs,
				TABLA_PRODUCTOS, "enVenta")));
	}

	protected void setDescripcion(ResultSet rs) throws SQLException {

		this.setDescripcion(AccesoDb.getColumnaString(rs, TABLA_PRODUCTOS,
				"descripcion"));
	}

	public static ArrayList<Producto> buscarProductos(AccesoDb db, Integer idMarca,
			Integer idTipoProducto, String codigo, String nombre, Boolean enVenta)
			throws SQLException {
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamInt(1, idMarca);
		db.setParamInt(2, idTipoProducto);
		db.setParamVarchar(3, codigo);
		db.setParamVarchar(4, nombre);
		db.setParamBoolean(5, enVenta);

		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new Producto(rs));
		}

		db.cerrarQuery();
		return resultado;
	}

	public Producto() {

		super();
	}

	public Producto(ResultSet rs) throws SQLException {

		this.setDatos(rs);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(String stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getEnVenta() {
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

}
