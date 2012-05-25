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
		return nombre != null && nombre.length() > 0;
	}

	@Override
	public ArrayList<ObjetoPersistente> ejecutarBusqueda() {
		this.getResultado().clear();
		for (TipoDeProducto tipoProd : SucursalUno.getSingleInstance().getTiposDeProducto()) {
			if (Utiles.like(tipoProd.getNombre(), this.getNombre())) {
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
