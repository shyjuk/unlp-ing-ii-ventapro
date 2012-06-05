package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Usuario extends ObjetoPersistente<Usuario, Integer>{

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
		// TODO Auto-generated method stub
		
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
	protected void manejarErrorReferencia(Errores errores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
