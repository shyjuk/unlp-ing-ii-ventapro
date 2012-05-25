package unlp.info.ingenieriaii.web;

import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.ObjetoPersistente;

public abstract class Buscador {
	
	private ArrayList<ObjetoPersistente> resultado;
	
	public abstract boolean esValidoParaBuscar();
	
	public abstract ArrayList<ObjetoPersistente> ejecutarBusqueda();
	
	public ArrayList<ObjetoPersistente> getResultado(){
		if (this.resultado == null) {
			this.resultado = new ArrayList<ObjetoPersistente>();
		}
		return this.resultado;
	}
}
