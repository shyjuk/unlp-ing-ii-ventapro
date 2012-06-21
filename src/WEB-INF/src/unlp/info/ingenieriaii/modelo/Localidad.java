package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Localidad extends ObjetoPersistente<Localidad, Integer>{

	private static final String QUERY_BUSQUEDA = "{call buscarLocalidad (?)}";
	
	private String nombre;
	private Provincia provincia;
	
	public Localidad (ResultSet rs) throws SQLException {
		this.setDatos(rs);
	}
	
	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		this.setId(rs);
		this.setNombre(rs);
		//this.setProvincia(new Provincia(rs));
	}

	@Override
	protected Localidad getCopia(ResultSet rs) throws SQLException {
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
		this.setId(this.getColumnaInt(rs, "idLocalidad"));
	}

	@Override
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, Localidad copia) {
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
	
	public static ArrayList<Localidad> buscarLocalidad(AccesoDb db, String nombre)
			throws SQLException {
		ArrayList<Localidad> resultado = new ArrayList<Localidad>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, nombre);

		rs = db.ejecutarQuery();

		while (rs.next()) {
			resultado.add(new Localidad(rs));
		}

		db.cerrarQuery();
		return resultado;
	}
	
	public static ArrayList<Localidad> buscarLocalidad(String nombre) throws SQLException {
		return buscarLocalidad(new AccesoDb(), nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	protected void setNombre(ResultSet rs) throws SQLException {
		this.setNombre(this.getColumnaString(rs, "nombre"));
	}
	

}
