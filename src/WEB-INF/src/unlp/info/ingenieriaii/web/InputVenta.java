package unlp.info.ingenieriaii.web;

import java.sql.SQLException;

import unlp.info.ingenieriaii.modelo.OrdenDeVenta;

public class InputVenta {
	
	private String dni;
	
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
	
	
}
