package unlp.info.ingenieriaii.web;

import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.ObjetoPersistente;
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.SucursalUno;

public class BuscadorProducto extends Buscador{
	
	private String nombre;
	private int codigo;
	private String marca;
	private String categoria;
	
	public BuscadorProducto() {
		super();
	}
	
	public boolean esValidoParaBuscar () {
		
		boolean esValido = true;
		this.getErrores().clear();
		if (nombre == " " || nombre.length() == 0) {
			this.getErrores().put(Validador.ERROR_GENERICO, "Complete algún parametro para realizar la búsqueda.");
			esValido=false;}
			else if (codigo == 0) {
				this.getErrores().put(Validador.ERROR_GENERICO, "Complete algún parametro para realizar la búsqueda.");
				esValido=false;
				} else if (marca == null || marca.length() == 0) {
					this.getErrores().put(Validador.ERROR_GENERICO, "Complete algún parametro para realizar la búsqueda.");
					esValido=false;
					} else if (nombre == null || nombre.length() == 0) {
						this.getErrores().put(Validador.ERROR_GENERICO, "Complete algún parametro para realizar la búsqueda.");
						esValido=false;
					}		
		return esValido;
	}

	@Override
	public ArrayList<ObjetoPersistente> ejecutarBusqueda() {
		this.getResultado().clear();
		
		for (Producto prod : SucursalUno.getSingleInstance().getProductos()) {
			if (Utiles.like(prod.getNombre(), this.getNombre())) {
					this.getResultado().add(prod);
					}else if (prod.getCodigo() == this.getCodigo()) {
							this.getResultado().add(prod);
							}else if (Utiles.like(prod.getMarca(), this.getMarca())) {
								this.getResultado().add(prod);}
								else if (Utiles.like(prod.getTipoDeProducto(), this.getCategoria())) {
									this.getResultado().add(prod);}
			}
		return this.getResultado();
	}
	
public String getErrorGenerico(){
		
		return this.getErrores().get(Validador.ERROR_GENERICO);
	}

	public int getCodigo() {
				return codigo;
			}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


			public void setCodigo(String codigo) {
				if (AgregarProductoServlet.isInteger(codigo)){
					this.setCodigo(Integer.valueOf(codigo).intValue());}
				else this.setCodigo(0);
			}

			public String getMarca() {
				return marca;
			}

			public void setMarca(String marca) {
				this.marca = marca;
			}

			public String getCategoria() {
				return categoria;
			}

			public void setCategoria(String categoria) {
				this.categoria = categoria;
			}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
