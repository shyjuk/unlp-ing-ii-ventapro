package unlp.info.ingenieriaii.modelo;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Cliente;
import unlp.info.ingenieriaii.web.AccesoDb;
import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class Cliente extends ObjetoPersistente<Cliente, Integer> {
	
	private static final String QUERY_LECTURA = "{call leerCliente (?)}";
	private static final String QUERY_BUSQUEDA = "{call buscarCliente (?, ?, ?)}";
	private static final String QUERY_ALTA = "{call agregarCliente (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	private static final String QUERY_MODIFICACION = "{call modificarCliente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	private static final String QUERY_BAJA = "{call eliminarCliente (?)}";

	
	private String nombre;
	private String apellido;
	private String nroDocumento;
	private String tipoDocumento;
	private String telefono;
    private String email;
    private String direccion;
    private String localidad;
    private String provincia;

	protected void setDatos(ResultSet rs) throws SQLException {

		this.setId(rs);
		this.setNombre(rs);
		this.setApellido(rs);
		this.setNroDocumento(rs);
		this.setTipoDocumento(rs);
		this.setTelefono(rs);
		this.setEmail(rs);
		this.setDireccion(rs);
		this.setLocalidad(rs);
		this.setProvincia(rs);
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
		db.setParamVarchar(1, this.getNombre());
		db.setParamVarchar(2, this.getApellido());
		db.setParamVarchar(3, this.getNroDocumento());
		db.setParamVarchar(4, this.getTipoDocumento());
		db.setParamVarchar(5, this.getTelefono());
		db.setParamVarchar(6, this.getEmail());
		db.setParamVarchar(7, this.getDireccion());
		db.setParamVarchar(8, this.getLocalidad());
		db.setParamVarchar(9, this.getProvincia());
	}

	protected void prepararModificacion(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_MODIFICACION);
		db.setParamInt(1, this.getId());
		db.setParamVarchar(2, this.getNombre());
		db.setParamVarchar(3, this.getApellido());
		db.setParamVarchar(4, this.getNroDocumento());
		db.setParamVarchar(5, this.getTipoDocumento());
		db.setParamVarchar(6, this.getTelefono());
		db.setParamVarchar(7, this.getEmail());
		db.setParamVarchar(8, this.getDireccion());
		db.setParamVarchar(9, this.getLocalidad());
		db.setParamVarchar(10, this.getProvincia());
	}	

	protected void prepararBaja(AccesoDb db) throws SQLException {

		db.prepararLlamada(QUERY_BAJA);
		db.setParamInt(1, this.getId());
	}
	
	protected void setId(ResultSet rs) throws SQLException {

		this.setId(this.getColumnaInt(rs, "idCliente"));
	}
	
	protected Errores validarCampos() {
		Errores errores = new Errores();

		Validador.validarLongitud(errores, "nombre", this.getNombre(), 1, 35);
		Validador.validarLongitud(errores, "apellido", this.getApellido(), 1, 20);
		Validador.validarLongitud(errores, "nroDocumento", this.getNroDocumento(), 7, 8);
		Validador.validarLongitud(errores, "tipoDocumento", this.getTipoDocumento(), 1, 15);
		Validador.validarLongitud(errores, "telefono", this.getTelefono(), 1, 20);
		Validador.validarLongitud(errores, "email", this.getEmail(), 1, 25);
		Validador.validarLongitud(errores, "direccion", this.getDireccion(), 1, 100);
		Validador.validarLongitud(errores, "localidad", this.getLocalidad(), 1, 35);
		Validador.validarLongitud(errores, "provincia", this.getProvincia(), 1, 35);
		return errores;
	}	
	
	protected void manejarErrorDuplicado(Errores errores, Cliente copia) {

		errores.setErrorCampo("nroDocumento", "Ya existe un cliente con ese numero de documento.");
	}
	
	protected void manejarErrorReferencia(Errores errores, ResultSet rs) {
	this.errorGeneral(errores);
}
	
	protected void setNombre(ResultSet rs) throws SQLException {

		this.setNombre(this.getColumnaString(rs, "nombre"));
	}

	protected void setApellido(ResultSet rs) throws SQLException {

		this.setApellido(this.getColumnaString(rs, "apellido"));
	}
	
	protected void setNroDocumento(ResultSet rs) throws SQLException {

		this.setNroDocumento(this.getColumnaString(rs, "nroDocumento"));
	}

	protected void setTipoDocumento(ResultSet rs) throws SQLException {

		this.setTipoDocumento(this.getColumnaString(rs, "tipoDocumento"));
	}

	protected void setTelefono(ResultSet rs) throws SQLException {

		this.setTelefono(this.getColumnaString(rs, "telefono"));
	}

	protected void setEmail(ResultSet rs) throws SQLException {

		this.setEmail(this.getColumnaString(rs, "email"));
	}
	
	protected void setDireccion(ResultSet rs) throws SQLException {

		this.setDireccion(this.getColumnaString(rs, "direccion"));
	}
	
	protected void setLocalidad(ResultSet rs) throws SQLException {

		this.setLocalidad(this.getColumnaString(rs, "localidad"));
	}
	
	protected void setProvincia(ResultSet rs) throws SQLException {

		this.setProvincia(this.getColumnaString(rs, "provincia"));
	}
	
	
	
	public static ArrayList<Cliente> buscarCliente(AccesoDb db, String nombre, String apellido, String nroDocumento)
			throws SQLException {
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, nombre);
		db.setParamVarchar(2, apellido);
		db.setParamVarchar(3, nroDocumento);
		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new Cliente(rs));
		}

		db.cerrarQuery();
		return resultado;
	}

	public static ArrayList<Cliente> buscarCliente(String nombre, String apellido, String nroDocumento)
			throws SQLException {

		return buscarCliente(new AccesoDb(), nombre, apellido, nroDocumento);
	}

	
	
	public Cliente() {
        super();
}
/*
public boolean esValidoParaCrear() {
return super.esValidoParaCrear()
		&& Validador.esValidoCliente(this, this.getErrores());
}


public boolean esValidoParaModificar() {
return super.esValidoParaModificar()
		&& Validador.esValidoCliente(this, this.getErrores());
}


public boolean esValidoParaEliminar() {
return super.esValidoParaEliminar();
}

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
    public void setNroDocumento (String nroDocumento) {
		this.nroDocumento = Utiles.trim(nroDocumento);
	}

       
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this. tipoDocumento = tipoDocumento.trim();
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
		this. email = email;
	}

		
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion.trim();
	}
	
	
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad.trim();
	}
	
	
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia.trim();
	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {
		// TODO Auto-generated method stub
		
	}


}
