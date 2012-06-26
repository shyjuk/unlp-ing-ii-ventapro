package unlp.info.ingenieriaii.web;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;

public class BuscadorOrden extends Buscador<OrdenDeVenta>  {

	private String dni;
	private String nombre;
	private String vendedor;
	private String producto;
	private String dia;
	private String mes;
	private String anio;
	private String estado;
	
	@Override
	protected ArrayList<OrdenDeVenta> ejecutarBusqueda(AccesoDb db, Errores errores) throws SQLException {
		return OrdenDeVenta.buscarOrdenes(db, this);
	}

	@Override
	protected void validarCriterios(Errores errores) {
		if (!Utiles.esVacio(this.getDni())){
			if (!(this.getDni().trim().length() >= 7 && this.getDni().trim().length() <= 8)) {
				errores.setErrorCampo("dni", "Ingrese entre 7 y 8 digitos numericos para el dni.");	
			}else if (!this.getDni().trim().matches("[0-9]*")) {
				errores.setErrorCampo("dni", "Ingrese solo caracteres númericos.");
			}
		}
		if (!Utiles.esVacio(this.getNombre())) {
			if (this.getNombre().trim().length() > 100) {
				errores.setErrorCampo("nombre", "Ingrese hasta 100 caracteres para el nombre.");
			}
		}
		
		Validador.validarFecha(errores, "fecha", this.getDia(), this.getMes(), this.getAnio(), true);
		
		if (!Utiles.esVacio(this.getProducto())){
			if (!(this.getProducto().trim().length() >= 12 && this.getProducto().trim().length() <= 13)) {
				errores.setErrorCampo("producto", "Ingrese entre 12 y 13 digitos numericos para el codigo del producto.");	
			}else if (!this.getProducto().trim().matches("[0-9]*")) {
				errores.setErrorCampo("producto", "Ingrese solo caracteres númericos.");
			}
		}
		
	}
	
	public Date getFecha () {
		if (!Utiles.esVacio(this.getDia()) && !Utiles.esVacio(this.getMes()) && !Utiles.esVacio(this.getAnio())) {
			if (Utiles.esFecha(this.getDia(), this.getMes(), this.getAnio())) {
				return new Date(Integer.valueOf(anio.trim()) -1900, Integer.valueOf(mes.trim()) -1 ,Integer.valueOf(dia.trim()));
			}
		}	
		return null;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
