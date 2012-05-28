package unlp.info.ingenieriaii.web;

import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.ObjetoPersistente;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.Marca;

public class BuscadorMarca extends Buscador {

	private String nombre;

	public BuscadorMarca() {
		super();
	}

	public boolean esValidoParaBuscar() {

		this.getErrores().clear();

		if (Utiles.esVacio(this.getNombre())) {
			this.getErrores().put(Validador.ERROR_GENERICO,
					"Complete algún parámetro para realizar la búsqueda.");
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<ObjetoPersistente> ejecutarBusqueda() {

		this.getResultado().clear();

		for (Marca m : SucursalUno.getSingleInstance().getMarcas()) {
			
			if (Utiles.esVacio(this.getNombre())) {
				this.getResultado().add(m);
			} else if (Utiles.like(m.getNombre(), this.getNombre())) {
				this.getResultado().add(m);
			}
		}
		return this.getResultado();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
