package unlp.info.ingenieriaii.web;

import java.sql.SQLException;
import java.util.ArrayList;

import unlp.info.ingenieriaii.modelo.Cliente;
import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;

public class InputVenta {
	
	private String dni;
	private String codigoAgregar;
	private BuscadorProducto buscador;
	private OrdenDeVenta ordenDeVenta;
	
	
	public void actualizarConActual () {
		OrdenDeVenta actual = null;
		try {
			actual = OrdenDeVenta.buscarOrdenActual();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setOrdenDeVenta(actual);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public OrdenDeVenta getOrdenDeVenta() {
		return ordenDeVenta;
	}

	public void setOrdenDeVenta(OrdenDeVenta ordenDeVenta) {
		this.ordenDeVenta = ordenDeVenta;
	}

	public BuscadorProducto getBuscador() {
		return buscador;
	}

	public void setBuscador(BuscadorProducto buscador) {
		this.buscador = buscador;
	}
	
	public Errores buscarCliente() {
		Errores errores = new Errores();
		AccesoDb db = new AccesoDb();

		this.getOrdenDeVenta().setCliente(null);

		if (!Utiles.esVacio(this.getDni())) {
			if (!(this.getDni().trim().length() >= 7 && this.getDni().trim().length() <= 8)) {
				errores.setErrorCampo("dni", "Ingrese entre 7 y 8 digitos numericos para el dni.");	
			}else if (!this.getDni().trim().matches("[0-9]*")) {
				errores.setErrorCampo("dni", "Ingrese solo caracteres númericos.");
			}
		}else{
			errores.setErrorCampo("dni", "Ingrese el dni del cliente.");
		}

		if (errores.esVacio())
			try {
				ArrayList<Cliente> clienteBuscado = Cliente.buscarCliente(db, null, null, this.getDni());
				if (!clienteBuscado.isEmpty()) {
					this.getOrdenDeVenta().setCliente(clienteBuscado.get(0));
				}else{
					errores.setErrorCampo("dni", "El cliente no existe en el sistema. Por favor solicite los siguientes datos al cliente.");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				errores.setGeneral("Ha ocurrido un error inesperado mientras se realizaba la búsqueda. Por favor intente más tarde.");
			} finally {
				try {
					db.cerrar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		return errores;
	}

	public String getCodigoAgregar() {
		return codigoAgregar;
	}

	public void setCodigoAgregar(String codigoAgregar) {
		this.codigoAgregar = codigoAgregar;
	}
	
	
}
