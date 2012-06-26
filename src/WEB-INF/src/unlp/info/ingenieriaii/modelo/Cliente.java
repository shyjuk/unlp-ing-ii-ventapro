package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class Cliente extends ObjetoPersistente<Cliente, Integer> {

	private static final String QUERY_LECTURA = "{call leerCliente (?)}";

	private static final String QUERY_BUSQUEDA = "{call buscarCliente (?, ?)}";

	private static final String QUERY_ALTA = "{call agregarCliente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	private static final String QUERY_MODIFICACION = "{call modificarCliente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	private static final String QUERY_BAJA = "{call eliminarCliente (?)}";

	private String nombre;
	private String apellido;
	private Byte tipoDocumento = 1; // Hardcodeado a DNI
	private String nroDocumento;
	private String telefono;
	private String celular;
	private String email;

	private String localidad;
	private String calle;
	private String numeroCalle;
	private String dpto;

	protected void setDatos(ResultSet rs) throws SQLException {

		this.setId(rs);
		this.setApellidoNombre(rs);
		this.setNroDocumento(rs);
		this.setTipoDocumento(rs);
		this.setTelefono(rs);
		this.setEmail(rs);
		this.setCelular(rs);
		this.setCalle(rs);
		this.setNumeroCalle(rs);
		this.setDpto(rs);
		this.setLocalidad(rs);
	}

	protected Cliente getCopia(ResultSet rs) throws SQLException {

		return new Cliente(rs);
	}

	protected void prepararLectura(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_LECTURA);
		db.setParamInt(1, this.getId());
	}

	protected void prepararAlta(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_ALTA);
		db.setParamVarchar(1, this.getApellido() + "," + this.getNombre());
		db.setParamByte(2, this.getTipoDocumento());
		db.setParamVarchar(3, this.getNroDocumento());
		db.setParamVarchar(4, this.getTelefono());
		db.setParamVarchar(5, this.getCelular());
		db.setParamVarchar(6, this.getEmail());
		db.setParamVarchar(7, this.getLocalidad());
		db.setParamVarchar(8, this.getCalle());
		db.setParamInt(9, !Utiles.esVacio(this.getNumeroCalle()) ? new Integer(
				this.getNumeroCalle()) : null);
		db.setParamVarchar(10, this.getDpto());
	}

	protected void prepararModificacion(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_MODIFICACION);
		db.setParamInt(1, this.getId());
		db.setParamVarchar(2, this.getApellido() + "," + this.getNombre());
		db.setParamByte(3, this.getTipoDocumento());
		db.setParamVarchar(4, this.getNroDocumento());
		db.setParamVarchar(5, this.getTelefono());
		db.setParamVarchar(6, this.getCelular());
		db.setParamVarchar(7, this.getEmail());
		db.setParamVarchar(8, this.getLocalidad());
		db.setParamVarchar(9, this.getCalle());
		db.setParamInt(
				10,
				!Utiles.esVacio(this.getNumeroCalle()) ? new Integer(this
						.getNumeroCalle()) : null);
		db.setParamVarchar(11, this.getDpto());
	}

	protected void prepararBaja(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_BAJA);
		db.setParamInt(1, this.getId());
	}

	protected void setId(ResultSet rs) throws SQLException {

		this.setId(this.getColumnaInt(rs, "idPersona"));
	}

	private void validarTelefono(Errores errores, String valor, String nombre) {

		if (valor == null)
			return;

		if (!valor.matches("(\\(\\d+\\)\\s*)?\\d*"))
			errores.setErrorCampo(nombre,
					"El número tiene formato válido. Ejemplo: (0221) 4841234");
	}

	private void validarNombre(Errores errores, String valor, String nombre) {

		if (valor == null)
			return;

		if (!Utiles.esAlfa(valor))
			errores.setErrorCampo(nombre, "Debe ingresar letras unicamente.");
	}

	protected Errores validarCampos() {
		Errores errores = new Errores();

		if (Validador.validarLongitud(errores, "nombre", this.getNombre(), 1,
				50))
			validarNombre(errores, this.getNombre(), "nombre");
		if (Validador.validarLongitud(errores, "apellido", this.getApellido(),
				1, 50))
			validarNombre(errores, this.getApellido(), "apellido");
		Validador.validarEntero(errores, "nroDocumento",
				this.getNroDocumento(), 1000000, 199999999, false);
		if (Validador.validarLongitud(errores, "telefono", this.getTelefono(),
				0, 20))
			validarTelefono(errores, this.getTelefono(), "telefono");
		if (Validador.validarLongitud(errores, "celular", this.getCelular(), 0,
				20))
			validarTelefono(errores, this.getCelular(), "celular");
		Validador.validarLongitud(errores, "email", this.getEmail(), 0, 50);

		Validador.validarLongitud(errores, "localidad", this.getLocalidad(), 1,
				50);
		Validador.validarLongitud(errores, "calle", this.getCalle(), 1, 50);
		Validador.validarEntero(errores, "numeroCalle", this.getNumeroCalle(),
				1, 99999, true);
		Validador.validarLongitud(errores, "dpto", this.getDpto(), 0, 4);

		return errores;
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, Cliente copia) {

		errores.setErrorCampo("nroDocumento",
				"Ya existe un cliente con ese número de documento.");
	}

	@Override
	protected void manejarErrorReferencia(Errores errores, ResultSet rs) {

		this.errorGeneral(errores);
	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {

		errores.setGeneral("El cliente no puede ser eliminado ya que tiene actividad registrada en el sistema.");
	}

	protected void setApellidoNombre(ResultSet rs) throws SQLException {
		final String nombre = this.getColumnaString(rs, "nombre");

		if (nombre == null)
			return;

		String[] nombres = nombre.split(",");

		this.setApellido(nombres[0]);
		this.setNombre(nombres[1]);
	}

	protected void setNroDocumento(ResultSet rs) throws SQLException {

		this.setNroDocumento(this.getColumnaString(rs, "nroDocumento"));
	}

	protected void setTipoDocumento(ResultSet rs) throws SQLException {

		this.setTipoDocumento(this.getColumnaByte(rs, "tipoDocumento"));
	}

	protected void setTelefono(ResultSet rs) throws SQLException {

		this.setTelefono(this.getColumnaString(rs, "telefono"));
	}

	protected void setEmail(ResultSet rs) throws SQLException {

		this.setEmail(this.getColumnaString(rs, "email"));
	}

	protected void setCelular(ResultSet rs) throws SQLException {

		this.setCelular(this.getColumnaString(rs, "celular"));
	}

	protected void setCalle(ResultSet rs) throws SQLException {

		this.setCalle(this.getColumnaString(rs, "calle"));
	}

	protected void setNumeroCalle(ResultSet rs) throws SQLException {

		this.setNumeroCalle(this.getColumnaString(rs, "numeroCalle"));
	}

	protected void setLocalidad(ResultSet rs) throws SQLException {

		this.setLocalidad(this.getColumnaString(rs, "localidad"));
	}

	protected void setDpto(ResultSet rs) throws SQLException {

		this.setDpto(this.getColumnaString(rs, "dpto"));
	}

	public static ArrayList<Cliente> buscarCliente(AccesoDb db, String nombre,
			String apellido, String nroDocumento) throws SQLException {
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		String nombrePersona = (apellido != null ? apellido : "") + "%,"
				+ (nombre != null ? nombre : "") + "%";
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, nroDocumento);
		db.setParamVarchar(2, nombrePersona);
		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new Cliente(rs));
		}

		db.cerrarQuery();
		return resultado;
	}

	public static ArrayList<Cliente> buscarCliente(String nombre,
			String apellido, String nroDocumento) throws SQLException {

		return buscarCliente(new AccesoDb(), nombre, apellido, nroDocumento);
	}

	public Cliente() {
		super();
	}

	/*
	 * public boolean esValidoParaCrear() { return super.esValidoParaCrear() &&
	 * Validador.esValidoCliente(this, this.getErrores()); }
	 * 
	 * 
	 * public boolean esValidoParaModificar() { return
	 * super.esValidoParaModificar() && Validador.esValidoCliente(this,
	 * this.getErrores()); }
	 * 
	 * 
	 * public boolean esValidoParaEliminar() { return
	 * super.esValidoParaEliminar(); }
	 */

	public Cliente(ResultSet rs) throws SQLException {

		this.setDatos(rs);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = Utiles.trim(nombre);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = Utiles.trim(apellido);
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = Utiles.trim(nroDocumento);
	}

	public Byte getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Byte tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(String numero) {
		this.numeroCalle = numero;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
