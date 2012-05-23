package unlp.info.ingenieriaii.modelo;

import unlp.info.ingenieriaii.web.Validador;

public class TipoDeProducto extends ObjetoPersistente{

	private String nombre;
	private String descripcion;
	
	public boolean esValidoParaCrear()	{
		return super.esValidoParaCrear() && Validador.esValidoTipoDeProducto(this, this.getErrores());
	}
	
	@Override
	public boolean esValidoParaModificar() {
		return super.esValidoParaModificar() && Validador.esValidoTipoDeProducto(this, this.getErrores());
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
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
