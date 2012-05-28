package unlp.info.ingenieriaii.modelo;

import unlp.info.ingenieriaii.web.Utiles;
import unlp.info.ingenieriaii.web.Validador;

public class Marca extends ObjetoPersistente {

	private String nombre;
	private String sitioWeb;
	private String contacto;
	private String infoAdicional;

	public Marca() {
		super();
	}

	public boolean esValidoParaCrear() {
		return super.esValidoParaCrear()
				&& Validador.esValidoMarca(this, this.getErrores());
	}

	@Override
	public boolean esValidoParaModificar() {
		return super.esValidoParaModificar()
				&& Validador.esValidoMarca(this, this.getErrores());
	}

	@Override
	public boolean esValidoParaEliminar() {
		// AGREGAR TODAS LAS VALIDACIONES DE DATOS REFERENCIALES
		return super.esValidoParaEliminar();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.trim();
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		String url = this.sitioWeb = sitioWeb.trim();

		url.toLowerCase();
		if (!(url.startsWith("http://") || url.startsWith("https://"))
				&& url.indexOf("://") < 0 && !Utiles.esVacio(url))
			this.sitioWeb = "http://" + this.sitioWeb;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

}
