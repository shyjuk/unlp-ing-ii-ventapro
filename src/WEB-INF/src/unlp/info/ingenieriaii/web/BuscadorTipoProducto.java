package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.TipoProducto;

public class BuscadorTipoProducto extends Buscador<TipoProducto>{
	
	private String nombre;
	
	@Override
	protected ArrayList<TipoProducto> ejecutarBusqueda(AccesoDb db,
			Errores errores) throws SQLException {

		return TipoProducto.buscarTiposProducto(db, this.getNombre());
	}

	@Override
	protected void validarCriterios(Errores errores) {

		if (Utiles.esVacio(this.getNombre()))
			errores.setErrorCampo(
					"nombre",
					"Debe indicar el nombre del tipo de producto (o parte del mismo) para realizar la búsqueda.");		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
