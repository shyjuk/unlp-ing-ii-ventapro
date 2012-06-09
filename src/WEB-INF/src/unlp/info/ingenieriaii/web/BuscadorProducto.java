package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Producto;

public class BuscadorProducto extends Buscador<Producto> {

	private String nombre;
	private String codigo;
	private Integer idMarca;
	private Integer idTipoProducto;
	private Boolean enVenta;

	@Override
	protected ArrayList<Producto> ejecutarBusqueda(AccesoDb db, Errores errores)
			throws SQLException {

		return Producto.buscarProductos(db, this.getIdMarca(),
				this.getIdTipoProducto(), this.getCodigo(), this.getNombre(),
				this.getEnVenta());
	}

	@Override
	protected void validarCriterios(Errores errores) {

		if (Utiles.esVacio(nombre) && Utiles.esVacio(codigo) && idMarca == null
				&& idTipoProducto == null)
			errores.setGeneral("Debe completar al menos uno de los criterios de búsqueda.");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public Boolean getEnVenta() {
		return enVenta;
	}

	public void setEnVenta(Boolean enVenta) {
		this.enVenta = enVenta;
	}
}
