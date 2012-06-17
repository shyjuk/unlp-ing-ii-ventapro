package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Provincia extends ObjetoPersistente<Provincia, Integer>{
	
	private static final String QUERY_BUSQUEDA = "{call buscarProvincia (?)}";
	
	private String nombre;
	
	public Provincia (ResultSet rs) throws SQLException {
		this.setDatos(rs);
	}

	
	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		this.setId(rs);
		this.setNombre(rs);
	}

	@Override
	protected Provincia getCopia(ResultSet rs) throws SQLException {
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
		this.setId(this.getColumnaInt(rs, "idProvincia"));
	}

	@Override
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void manejarErrorDuplicado(Errores errores, Provincia copia) {
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
	
	public static ArrayList<Provincia> buscarProvincias(AccesoDb db, String nombre)
			throws SQLException {
		ArrayList<Provincia> resultado = new ArrayList<Provincia>();
		ResultSet rs;

		db.prepararLlamada(QUERY_BUSQUEDA);
		db.setParamVarchar(1, nombre);

		rs = db.ejecutarQuery();

		while (rs.next()) {

			resultado.add(new Provincia(rs));
		}

		db.cerrarQuery();
		return resultado;
	}
	
	public static ArrayList<Provincia> buscarProvincias(String nombre) throws SQLException {
		return buscarProvincias(new AccesoDb(), nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setNombre(ResultSet rs) throws SQLException {
		this.setNombre(this.getColumnaString(rs, "nombre"));
	}

}
