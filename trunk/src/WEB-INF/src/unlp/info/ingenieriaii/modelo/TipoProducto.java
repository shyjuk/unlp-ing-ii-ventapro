package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Validador;

public class TipoProducto extends ObjetoPersistente<TipoProducto, Integer> {

	private static final String TABLA_TIPOS_PRODUCTO = "tbl_tipos_producto";

	private static final String QUERY_LECTURA = "{call leerTipoProducto (?)}";

	private static final String QUERY_BUSQUEDA = "{call buscarTipoProducto (?)}";

	private static final String QUERY_ALTA = "{call agregarTipoProducto (?, ?)}";
	private static final String QUERY_MODIFICACION = "{call modificarTipoProducto (?, ?, ?)}";
	private static final String QUERY_BAJA = "{call eliminarTipoProducto (?)}";

	private String nombre;
	private String descripcion;

	@Override
	protected void setDatos(ResultSet rs) throws SQLException {

		this.setId(rs);
		this.setNombre(rs.getString("nombre"));
		this.setDescripcion(rs.getString("descripcion"));
	}

	@Override
	protected TipoProducto getCopia(ResultSet rs) throws SQLException {
		TipoProducto tipoProducto = new TipoProducto();

		tipoProducto.setDatos(rs);
		return tipoProducto;
	}

	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_LECTURA);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void prepararAlta(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_ALTA);
		db.setParamVarchar(1, this.getNombre());
		db.setParamVarchar(2, this.getDescripcion());
	}

	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_MODIFICACION);
		db.setParamInt(1, this.getId());
		db.setParamVarchar(2, this.getNombre());
		db.setParamVarchar(3, this.getDescripcion());
	}

	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_BAJA);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void setId(ResultSet rs) throws SQLException {

		this.setId(AccesoDb.getColumnaInt(rs, TABLA_TIPOS_PRODUCTO, "idTipoProducto"));
	}

	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();

		Validador.validarLongitud(errores, "nombre", this.getNombre(), 1, 50);
		Validador.validarLongitud(errores, "descripcion",
				this.getDescripcion(), 0, 100);
		return errores;
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, TipoProducto copia) {

		errores.setErrorCampo("nombre",
				"Ya existe un tipo de producto con este nombre.");
	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {

		errores.setGeneral("No es posible eliminar un tipo de producto cuando hay productos registrados con el mismo.");
	}

	@Override
	protected void manejarErrorReferencia(Errores errores) {
		// No debe ocurrir nunca este error.
		this.errorGeneral(errores);
	}

	protected void setNombre(ResultSet rs) throws SQLException {

		this.setNombre(AccesoDb.getColumnaString(rs, TABLA_TIPOS_PRODUCTO,
				"nombre"));
	}

	protected void setSitioWeb(ResultSet rs) throws SQLException {

		this.setDescripcion(AccesoDb.getColumnaString(rs, TABLA_TIPOS_PRODUCTO,
				"descripcion"));
	}

	public static ArrayList<TipoProducto> buscarTiposProducto(AccesoDb db,
			String nombre) throws SQLException {
		ArrayList<TipoProducto> resultado = new ArrayList<TipoProducto>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, nombre);

		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new TipoProducto(rs));
		}

		db.cerrarQuery();
		return resultado;
	}

	public TipoProducto() {

		super();
	}

	public TipoProducto(ResultSet rs) throws SQLException {

		this.setDatos(rs);
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
		
		if (this.nombre != null)
			this.nombre = this.nombre.trim();
	}

	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
		
		if (this.descripcion != null)
			this.descripcion = this.descripcion.trim();
	}
}