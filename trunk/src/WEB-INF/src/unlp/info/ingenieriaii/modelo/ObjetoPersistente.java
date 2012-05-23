package unlp.info.ingenieriaii.modelo;

import java.util.HashMap;
import java.util.Random;

import unlp.info.ingenieriaii.web.Validador;

public abstract class ObjetoPersistente {

	private int id = -1;
	private java.util.Date fechaCreacion;
	private java.util.Date fechaModificacion;
	
	private HashMap<String, String> errores = new HashMap<String, String>();
	
	public void generarIDAutomatico () {
		this.setId((new Random()).nextInt(100)); // ver si esto esta bien
	}
	
	public boolean esValidoParaCrear()	{
		errores.clear();
		if (this.getId() > -1) {
			errores.put(Validador.ERROR_GENERICO, "Ha ocurrido un error. Por favor intente nuevamente.");
			return false;
		}
		return true;
	}
	
	public boolean esValidoParaModificar() {
		errores.clear();
		return true;
	}
	
	public boolean esValidoParaEliminar() {
		errores.clear();
		return true;
	}

	public HashMap<String, String> getErrores() {
		return this.errores;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(java.util.Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	
}
