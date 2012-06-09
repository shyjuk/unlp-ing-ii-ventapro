package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;

public class BuscadorOrden extends Buscador<OrdenDeVenta>  {

	private String dni;
	private String nombre;
	private String apellido;
	private String vendedor;
	private String producto;
	private String dia;
	private String mes;
	private String anio;
	
	
	@Override
	protected ArrayList<OrdenDeVenta> ejecutarBusqueda(AccesoDb db, Errores errores) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void validarCriterios(Errores errores) {
		if (!Utiles.esVacio(this.getDni())){
			if (this.getDni().trim().length() < 7 || this.getDni().trim().length() > 10) {
				errores.setErrorCampo("dni", "Ingrese entre 7 y 9 digitos numericos para el dni.");	
			}else if (!this.getDni().trim().matches("[0-9]*")) {
				errores.setErrorCampo("dni", "Ingrese solo caracteres númericos.");
			}
		}
			
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	
}
