package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Cliente;
import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class BuscadorCliente extends Buscador<Cliente> {

	private String nombre;
	private String apellido;
	private String nroDocumento;

	@Override
	protected ArrayList<Cliente> ejecutarBusqueda(AccesoDb db, Errores errores)
			throws SQLException {

		return Cliente.buscarCliente(db, this.getNombre(), this.getApellido(),
				this.getNroDocumento());
	}

	@Override
	protected void validarCriterios(Errores errores) {

		if (Utiles.esVacio(this.getNombre())
				&& Utiles.esVacio(this.getApellido())
				&& Utiles.esVacio(this.getNroDocumento())) {

			errores.setGeneral("Debe completar al menos uno de los criterios de busqueda.");
		} else {

			if (!Utiles.esVacio(this.getNroDocumento()))
				Validador.validarEntero(errores, "nroDocumento",
						this.getNroDocumento(), 1000000, 199999999, false);
			if (!Utiles.esVacio(this.getNombre()))
				Validador.validarLongitud(errores, "nombre", this.getNombre(),
						0, 50);
			if (!Utiles.esVacio(this.getApellido()))
				Validador.validarLongitud(errores, "apellido",
						this.getApellido(), 0, 50);

		}
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

}
