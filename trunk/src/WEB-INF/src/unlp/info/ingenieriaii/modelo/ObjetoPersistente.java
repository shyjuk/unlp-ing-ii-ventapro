package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import unlp.info.ingenieriaii.web.AccesoDb;

public abstract class ObjetoPersistente<T extends ObjetoPersistente<T, PK>, PK> {

	private static final int REINTENTOS = 3;
	private static final String CODIGO_ERROR = "CODIGO_ERROR";

	private PK id = null;

	protected abstract void setDatos(ResultSet rs) throws SQLException;

	protected abstract T getCopia(ResultSet rs) throws SQLException;

	protected abstract void prepararLectura(AccesoDb db) throws SQLException;

	protected abstract void prepararAlta(AccesoDb db) throws SQLException;

	protected abstract void prepararModificacion(AccesoDb db)
			throws SQLException;

	protected abstract void prepararBaja(AccesoDb db) throws SQLException;

	protected abstract void setId(ResultSet rs) throws SQLException;

	protected abstract Errores validarCampos();

	protected abstract void manejarErrorDuplicado(Errores errores, T copia);

	protected abstract void manejarErrorEnUso(Errores errores);

	protected abstract void manejarErrorReferencia(Errores errores);

	protected final void errorGeneral(Errores errores) {

		errores.setGeneral("Ha ocurrido un error inesperado, por favor reintente la operación.");
	}

	private void ejecutarLectura(AccesoDb db, Errores errores) {
		ResultSet rs;

		try {
			this.prepararLectura(db);
			rs = db.ejecutarQuery();

			if (rs.first())
				this.setDatos(rs);
			else {
				this.setId((PK) null);
				errores.setGeneral("La información sobre la que desea operar ya no existe.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			this.errorGeneral(errores);
		}
	}

	private void ejecutarAbm(AccesoDb db, Errores errores, boolean leerId) {
		int codigo = AccesoDb.ERROR_DESCONOCIDO;
		int i = REINTENTOS;
		boolean huboRespuesta = false;
		ResultSet rs;

		loop: do {
			try {
				db.ejecutarQueryMultiSet();
				while ((rs = db.proximoResultSet()) != null) {

					if ((huboRespuesta |= rs.next())) {

						codigo = rs.getInt(CODIGO_ERROR);

						if (codigo < 0) {
							switch (codigo) {
							case AccesoDb.ERROR_VALOR_DUPLICADO:
								this.manejarErrorDuplicado(errores,
										this.getCopia(rs));
								break;
							}
						} else if (leerId)
							this.setId(rs);

						break loop;
					}
				}
			} catch (SQLException e) {

				switch (e.getErrorCode()) {
				case AccesoDb.ER_ROW_IS_REFERENCED_2:
					this.manejarErrorEnUso(errores);
					break;
				case AccesoDb.ER_NO_REFERENCED_ROW_2:
					this.manejarErrorReferencia(errores);
					break;
				default:
					e.printStackTrace();
					this.errorGeneral(errores);
				}

				break loop;
			}
			// Si el stored procedure no devolvió nada posiblemente por
			// un error transiente, el loop va a reintentar.
		} while (!huboRespuesta && --i > 0);

		try {
			db.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (i <= 0)
			this.errorGeneral(errores);
	}

	private void ejecutarAlta(AccesoDb db, Errores errores) {

		try {
			this.prepararAlta(db);
			this.ejecutarAbm(db, errores, true);
		} catch (SQLException e) {
			e.printStackTrace();
			this.errorGeneral(errores);
		}

	}

	private void ejecutarModificacion(AccesoDb db, Errores errores) {

		try {
			this.prepararModificacion(db);
			this.ejecutarAbm(db, errores, false);
		} catch (SQLException e) {
			e.printStackTrace();
			this.errorGeneral(errores);
		}
	}

	private void ejecutarBaja(AccesoDb db, Errores errores) {

		try {
			this.prepararBaja(db);
			this.ejecutarAbm(db, errores, false);
		} catch (SQLException e) {
			e.printStackTrace();
			this.errorGeneral(errores);
		}
	}

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	public Errores recuperar(AccesoDb db) {
		Errores errores = new Errores();

		this.ejecutarLectura(db, errores);
		return errores;
	}

	public Errores guardar(AccesoDb db) {
		Errores errores = this.validarCampos();

		if (errores.esVacio())
			if (this.getId() == null)
				this.ejecutarAlta(db, errores);
			else
				this.ejecutarModificacion(db, errores);

		return errores;
	}

	public Errores eliminar(AccesoDb db) {
		Errores errores = new Errores();

		this.ejecutarBaja(db, errores);
		return errores;
	}

	public Errores recuperar() {
		AccesoDb db = new AccesoDb();

		return this.recuperar(db);
	}

	public Errores guardar() {
		AccesoDb db = new AccesoDb();

		return this.guardar(db);
	}

	public Errores eliminar() {
		AccesoDb db = new AccesoDb();

		return this.eliminar(db);
	}

}
