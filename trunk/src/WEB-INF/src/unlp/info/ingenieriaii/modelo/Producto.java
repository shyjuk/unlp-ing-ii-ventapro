package unlp.info.ingenieriaii.modelo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class Producto extends ObjetoPersistente<Producto, Integer> {

	private static final String QUERY_LECTURA = "{call leerProducto (?)}";
	private static final String QUERY_PROD_TODOS = "{call traerProductos (?)}";
	
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
		this.setNombre(rs);
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
		String garantia = this.getGarantia();
		String stockMinimo = this.getStockMinimo();

		db.prepararLlamada(QUERY_ALTA);
		db.setParamInt(1, this.getMarca().getId());
		db.setParamInt(2, this.getTipoProducto().getId());
		db.setParamVarchar(3, this.getCodigo());
		db.setParamVarchar(4, this.getNombre());
		db.setParamDecimal(5, new BigDecimal(this.getPrecio()));
		db.setParamInt(6, !Utiles.esVacio(garantia) ? new Integer(garantia)
				: null);
		db.setParamInt(7, new Integer(this.getStock()));
		db.setParamInt(8, !Utiles.esVacio(stockMinimo) ? new Integer(
				stockMinimo) : null);
		db.setParamBoolean(9, new Boolean(this.getEnVenta()));
		db.setParamVarchar(10, this.getDescripcion());
	}

	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		String garantia = this.getGarantia();
		String stockMinimo = this.getStockMinimo();

		db.prepararLlamada(QUERY_MODIFICACION);
		db.setParamInt(1, this.getId());
		db.setParamInt(2, this.getMarca().getId());
		db.setParamInt(3, this.getTipoProducto().getId());
		db.setParamVarchar(4, this.getCodigo());
		db.setParamVarchar(5, this.getNombre());
		db.setParamDecimal(6, new BigDecimal(this.getPrecio()));
		db.setParamInt(7, !Utiles.esVacio(garantia) ? new Integer(garantia)
				: null);
		db.setParamInt(8, new Integer(this.getStock()));
		db.setParamInt(9, !Utiles.esVacio(stockMinimo) ? new Integer(
				stockMinimo) : null);
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

		this.setId(this.getColumnaInt(rs, "idProducto"));
	}

	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();

		if (this.getMarca() == null)
			errores.setErrorCampo("idMarca", "Debe seleccionar una marca.");

		if (this.getTipoProducto() == null)
			errores.setErrorCampo("idTipoProducto",
					"Debe seleccionar un tipo de producto.");

		Validador.validarEntero(errores, "codigo", this.getCodigo(), 0,
				9999999999999L, 12, false);
		Validador.validarLongitud(errores, "nombre", this.getNombre(), 1, 100);
		Validador.validarDecimal(errores, "precio", this.getPrecio(), 0, 50000,
				2, false);
		Validador.validarEntero(errores, "garantia", this.getGarantia(), 0,
				12 * 5, true);
		Validador.validarEntero(errores, "stock", this.getStock(), 0, 1000,
				false);
		Validador.validarEntero(errores, "stockMinimo", this.getStockMinimo(),
				0, 1000, true);
		Validador.validarLongitud(errores, "descripcion",
				this.getDescripcion(), 0, 1000);

		return errores;
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

		this.setCodigo(this.getColumnaString(rs, "codigo"));
	}

	protected void setNombre(ResultSet rs) throws SQLException {

		this.setNombre(this.getColumnaString(rs, "nombre"));
	}

	protected void setPrecio(ResultSet rs) throws SQLException {

		this.setPrecio(this.getColumnaDecimal(rs, "precio").toString());
	}

	protected void setMarca(ResultSet rs) throws SQLException {

		this.setMarca(new Marca(rs));
	}

	protected void setTipoProducto(ResultSet rs) throws SQLException {

		this.setTipoProducto(new TipoProducto(rs));
	}

	protected void setGarantia(ResultSet rs) throws SQLException {
		Integer valor = this.getColumnaInt(rs, "garantia");

		this.setGarantia(valor != null ? valor.toString() : null);
	}

	protected void setStock(ResultSet rs) throws SQLException {

		this.setStock(String.valueOf(this.getColumnaInt(rs, "stock")));
	}

	protected void setStockMinimo(ResultSet rs) throws SQLException {
		Integer valor = this.getColumnaInt(rs, "stockMinimo");

		this.setStockMinimo(valor != null ? valor.toString() : null);
	}

	protected void setEnVenta(ResultSet rs) throws SQLException {

		this.setEnVenta(String.valueOf(this.getColumnaBoolean(rs, "enVenta")));
	}

	protected void setDescripcion(ResultSet rs) throws SQLException {

		this.setDescripcion(this.getColumnaString(rs, "descripcion"));
	}

	public static ArrayList<Producto> buscarProductos(AccesoDb db,
			Integer idMarca, Integer idTipoProducto, String codigo,
			String nombre, Boolean enVenta) throws SQLException {
		
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

	public static ArrayList<Producto> buscarProductos(Integer idMarca,
			Integer idTipoProducto, String codigo, String nombre,
			Boolean enVenta) throws SQLException {

		return buscarProductos(new AccesoDb(), idMarca, idTipoProducto, codigo,
				nombre, enVenta);
	}
	
	public static ArrayList<Producto> buscarProductos(AccesoDb db) throws SQLException {
		
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		ResultSet rs;

		db.prepararLlamada(QUERY_PROD_TODOS);

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

		this.codigo = Utiles.trim(codigo);
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = Utiles.trim(nombre);
	}

	public String getPrecio() {

		return precio;
	}

	public void setPrecio(String precio) {

		this.precio = precio;
		if (this.precio != null) {
			int c = 0;

			this.precio = this.precio.trim();

			for (int i = 0; i < this.precio.length(); i++)
				c += this.precio.charAt(i) == ',' ? 1 : 0;

			if (c == 1 && this.precio.indexOf('.') < 0)
				this.precio = this.precio.replace(',', '.');
		}
	}

	public Marca getMarca() {

		return marca;
	}

	public void setMarca(Marca marca) {

		this.marca = marca;
	}

	public void setMarca(Integer id, boolean recuperar) {

		if (id != null) {
			this.marca = new Marca();
			this.marca.setId(id);
			if (recuperar)
				this.recuperar();
		}
	}

	public TipoProducto getTipoProducto() {

		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {

		this.tipoProducto = tipoProducto;
	}

	public void setTipoProducto(Integer id, boolean recuperar) {

		if (id != null) {
			this.tipoProducto = new TipoProducto();
			this.tipoProducto.setId(id);
			if (recuperar)
				this.recuperar();
		}
	}

	public String getGarantia() {

		return garantia;
	}

	public void setGarantia(String garantia) {

		this.garantia = Utiles.trim(garantia);
	}

	public String getStock() {

		return stock;
	}

	public void setStock(String stock) {

		this.stock = Utiles.trim(stock);
	}

	public String getStockMinimo() {

		return stockMinimo;
	}

	public void setStockMinimo(String stockMinimo) {

		this.stockMinimo = Utiles.trim(stockMinimo);
	}

	public String getEnVenta() {

		return enVenta;
	}

	public void setEnVenta(String enVenta) {
		// No haría falta trimmear nunca pero por las dudas haya algún desliz en
		// alguna parte...
		this.enVenta = Utiles.trim(enVenta);
	}

	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

}