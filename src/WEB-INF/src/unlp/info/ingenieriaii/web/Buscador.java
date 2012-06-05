package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.ObjetoPersistente;

public abstract class Buscador<T extends ObjetoPersistente<T, ?>> {

	private ArrayList<T> resultado;

	protected abstract ArrayList<T> ejecutarBusqueda(AccesoDb db,
			Errores errores) throws SQLException;

	protected abstract void validarCriterios(Errores errores);

	private void setResultado(ArrayList<T> resultado) {

		this.resultado = resultado;
	}

	public ArrayList<T> getResultado() {

		if (this.resultado == null)
			this.setResultado(new ArrayList<T>());

		return this.resultado;
	}

	public Errores buscar(boolean validarCriterios) {
		Errores errores = new Errores();
		AccesoDb db = new AccesoDb();

		this.getResultado().clear();

		if (validarCriterios)
			this.validarCriterios(errores);

		if (errores.esVacio())
			try {
				this.setResultado(this.ejecutarBusqueda(db, errores));
			} catch (SQLException e) {
				e.printStackTrace();
				errores.setGeneral("Ha ocurrido un error inesperado mientras se realizaba la búsqueda. Por favor intente más tarde.");
			} finally {
				try {
					db.cerrar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		return errores;
	}
}
