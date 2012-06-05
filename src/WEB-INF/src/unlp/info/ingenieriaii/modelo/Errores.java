package unlp.info.ingenieriaii.modelo;

import java.util.HashMap;

public class Errores {

	private HashMap<String, String> campo = new HashMap<String, String>();
	private String general;

	public HashMap<String, String> getCampo() {

		return campo;
	}

	public String getGeneral() {

		return general;
	}

	public void setGeneral(String general) {

		this.general = general;
	}

	public boolean esVacio() {

		return this.getCampo().isEmpty() && this.getGeneral() == null;
	}

	public void reset() {

		this.getCampo().clear();
		this.setGeneral(null);
	}
	
	public void setErrorCampo(String nombre, String mensaje){
		
		this.getCampo().put(nombre, mensaje);
	}
}
