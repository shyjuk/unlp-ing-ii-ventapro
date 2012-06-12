package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Usuario extends ObjetoPersistente<Usuario, Integer>{
	
	private String nombre;
	
	private static final String QUERY_BUSQUEDA = "{call buscarUsuario (?)}";
	private static final String QUERY_BUSQUEDAVEN = "{call buscarVendedores (?)}";
	
	public Usuario(ResultSet rs) throws SQLException {
		this.setDatos(rs);
	}

	@Override
	protected Usuario getCopia(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setId(ResultSet rs) throws SQLException {
		this.setId(this.getColumnaInt(rs, "idUsuario"));
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, Usuario copia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void manejarErrorEnUso(Errores errores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void manejarErrorReferencia(Errores errores, ResultSet rs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		this.setId(rs);
		this.setNombre(rs);
	}

	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setNombre(ResultSet rs) throws SQLException {
		this.setNombre(this.getColumnaString(rs, "nombre"));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static ArrayList<Usuario> buscarUsuarios(AccesoDb db) throws SQLException {
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		ResultSet rs;
		 
		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, null);
		rs = db.ejecutarQuery();

		while (rs.next()) {
			resultado.add(new Usuario(rs));
		}
		
		db.cerrarQuery();
		return resultado;
	}

	public static ArrayList<Usuario> buscarUsuarios()
			throws SQLException {

		return buscarUsuarios(new AccesoDb());
	}
	
	public static ArrayList<Usuario> buscarVendedores(AccesoDb db, String nombre)
			throws SQLException {
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDAVEN);
		db.setParamVarchar(1, nombre);

		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new Usuario(rs));
		}

		db.cerrarQuery();
		return resultado;
	}
	
	public static ArrayList<Usuario> buscarVendedores(String nombre)
			throws SQLException {

		return buscarVendedores(new AccesoDb(), nombre);
	}

	
	
}
