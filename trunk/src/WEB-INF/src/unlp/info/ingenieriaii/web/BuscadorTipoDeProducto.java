package unlp.info.ingenieriaii.web;

import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.ObjetoPersistente;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;

public class BuscadorTipoDeProducto extends Buscador{
	
	private String nombre;
	
	public BuscadorTipoDeProducto() {
		super();
	}
	
	public boolean esValidoParaBuscar () {
		this.getErrores().clear();
		if (nombre == null || nombre.length() == 0) {
			this.getErrores().put(Validador.ERROR_GENERICO, "Complete algún parametro para realizar la búsqueda.");
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<ObjetoPersistente> ejecutarBusqueda() {
		this.getResultado().clear();
		for (TipoDeProducto tipoProd : SucursalUno.getSingleInstance().getTiposDeProducto()) {
			if (this.getNombre() == null || this.getNombre().isEmpty()) {
				this.getResultado().add(tipoProd);
			}else if (Utiles.like(tipoProd.getNombre(), this.getNombre())) {
				this.getResultado().add(tipoProd);
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
