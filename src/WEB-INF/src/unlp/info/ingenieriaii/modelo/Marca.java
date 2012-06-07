package unlp.info.ingenieriaii.modelo;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class Marca extends ObjetoPersistente<Marca, Integer> {

	private static final String TABLA_MARCAS = "tbl_marcas";

	private static final String QUERY_LECTURA = "{call leerMarca (?)}";

	private static final String QUERY_BUSQUEDA = "{call buscarMarca (?)}";

	private static final String QUERY_ALTA = "{call agregarMarca (?, ?, ?, ?)}";
	private static final String QUERY_MODIFICACION = "{call modificarMarca (?, ?, ?, ?, ?)}";
	private static final String QUERY_BAJA = "{call eliminarMarca (?)}";

	private String nombre;
	private String sitioWeb;
	private String contacto;
	private String infoAdicional;

	@Override
	protected void setDatos(ResultSet rs) throws SQLException {

		this.setId(rs);
		this.setNombre(rs);
		this.setSitioWeb(rs);
		this.setContacto(rs);
		this.setInfoAdicional(rs);
	}

	@Override
	protected Marca getCopia(ResultSet rs) throws SQLException {

		return new Marca(rs);
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
		db.setParamVarchar(2, this.getSitioWeb());
		db.setParamVarchar(3, this.getContacto());
		db.setParamVarchar(4, this.getInfoAdicional());
	}

	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_MODIFICACION);
		db.setParamInt(1, this.getId());
		db.setParamVarchar(2, this.getNombre());
		db.setParamVarchar(3, this.getSitioWeb());
		db.setParamVarchar(4, this.getContacto());
		db.setParamVarchar(5, this.getInfoAdicional());
	}

	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_BAJA);
		db.setParamInt(1, this.getId());
	}

	@Override
	protected void setId(ResultSet rs) throws SQLException {

		this.setId(AccesoDb.getColumnaInt(rs, TABLA_MARCAS, "idMarca"));
	}

	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();
		String sitioWeb;

		Validador.validarLongitud(errores, "nombre", this.getNombre(), 1, 50);

		if (Validador.validarLongitud(errores, "sitioWeb",
				(sitioWeb = this.getSitioWeb()), 0, 100)
				&& !Utiles.esVacio(sitioWeb)) {

			try {
				new URL(sitioWeb);
			} catch (MalformedURLException e) {
				errores.setErrorCampo("sitioWeb",
						"La URL ingresada no es válida.");
			}
		}

		Validador.validarLongitud(errores, "contacto", this.getContacto(), 0,
				1000);
		Validador.validarLongitud(errores, "infoAdicional",
				this.getInfoAdicional(), 0, 1000);

		return errores;
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, Marca copia) {

		errores.setErrorCampo("nombre", "Ya existe una marca con este nombre.");
	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {

		errores.setGeneral("No es posible eliminar una marca cuando hay productos registrados de la misma.");
	}

	@Override
	protected void manejarErrorReferencia(Errores errores, ResultSet rs) {
		// No debe ocurrir nunca este error.
		this.errorGeneral(errores);
	}

	protected void setNombre(ResultSet rs) throws SQLException {

		this.setNombre(AccesoDb.getColumnaString(rs, TABLA_MARCAS, "nombre"));
	}

	protected void setSitioWeb(ResultSet rs) throws SQLException {

		this.setSitioWeb(AccesoDb
				.getColumnaString(rs, TABLA_MARCAS, "sitioWeb"));
	}

	protected void setContacto(ResultSet rs) throws SQLException {

		this.setContacto(AccesoDb
				.getColumnaString(rs, TABLA_MARCAS, "contacto"));
	}

	protected void setInfoAdicional(ResultSet rs) throws SQLException {

		this.setInfoAdicional(AccesoDb.getColumnaString(rs, TABLA_MARCAS,
				"infoAdicional"));
	}

	public static ArrayList<Marca> buscarMarcas(AccesoDb db, String nombre)
			throws SQLException {
		ArrayList<Marca> resultado = new ArrayList<Marca>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, nombre);

		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new Marca(rs));
		}

		db.cerrarQuery();
		return resultado;
	}

	public Marca() {

		super();
	}

	public Marca(ResultSet rs) throws SQLException {

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

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		String url;

		this.sitioWeb = sitioWeb;

		if (this.sitioWeb != null) {
			url = this.sitioWeb = this.sitioWeb.trim();

			url.toLowerCase();
			if (!(url.startsWith("http://") || url.startsWith("https://"))
					&& url.indexOf("://") < 0 && !Utiles.esVacio(url))
				this.sitioWeb = "http://" + this.sitioWeb;
		}
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

}
