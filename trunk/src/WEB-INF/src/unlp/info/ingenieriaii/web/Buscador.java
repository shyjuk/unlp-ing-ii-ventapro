package unlp.info.ingenieriaii.web;

import java.util.ArrayList;
import java.util.HashMap;

import unlp.info.ingenieriaii.modelo.ObjetoPersistente;

public abstract class Buscador {
	
	private ArrayList<ObjetoPersistente> resultado;
	private HashMap<String, String> errores;
	
	public Buscador() {
		super();
		this.setErrores(new HashMap<String, String>());
	}
	
	public abstract boolean esValidoParaBuscar();
	
	public abstract ArrayList<ObjetoPersistente> ejecutarBusqueda();
	
	public ArrayList<ObjetoPersistente> getResultado(){
		if (this.resultado == null) {
			this.resultado = new ArrayList<ObjetoPersistente>();
		}
		return this.resultado;
	}

	public HashMap<String, String> getErrores() {
		return errores;
	}

	public void setErrores(HashMap<String, String> errores) {
		this.errores = errores;
	}
	
}
