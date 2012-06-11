package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Marca;

public class BuscadorMarca extends Buscador<Marca> {

	private String nombre;

	@Override
	protected ArrayList<Marca> ejecutarBusqueda(AccesoDb db, Errores errores)
			throws SQLException {

		return Marca.buscarMarcas(db, this.getNombre());
	}

	@Override
	protected void validarCriterios(Errores errores) {

		if (Utiles.esVacio(this.getNombre())) {

			errores.setErrorCampo(
					"nombre",
					"Debe indicar el nombre de la marca (o parte de la misma) para realizar la búsqueda.");
		} else {
			Validador.validarLongitud(errores, "nombre", this.getNombre(), 0,
					50);
		}
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = Utiles.trim(nombre);
	}
}
