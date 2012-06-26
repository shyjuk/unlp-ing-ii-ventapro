package unlp.info.ingenieriaii.web;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unlp.info.ingenieriaii.modelo.Cliente;
import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Estados;
import unlp.info.ingenieriaii.modelo.Item;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;
import unlp.info.ingenieriaii.modelo.Producto;

public class InputVenta {
	
	// Para la busqueda de cliente
	private String dni;
	
	// Para el agregado de productos a la orden
	private String codigoAgregar;
	private String cantidadAgregar;
	
	private BuscadorProducto buscador;
	private OrdenDeVenta ordenDeVenta;
	
	
	
	public Errores generarOrden () {
		Errores errores = new Errores();
		if (this.getOrdenDeVenta() == null) {
			errores.setGeneral("Ha ocurrido un error inesperado. Por favor intente más tarde.");
		}else {
			try{
				
				this.getOrdenDeVenta().setEstado(String.valueOf(Estados.PENDIENTE.getId()));
				
				// generar factura
				errores = this.generarFactura();
				if (!errores.esVacio()){
					this.getOrdenDeVenta().getFactura().setErrores(errores);
					throw new Exception(errores.toString());
				}
				
				// generar cliente
				
				
				//ACA VA LO DE HERNAN (AGREGAR ERRORES CONOCIDOS TAMBIEN)
				
				
				// generar items 
				//ESTO ESTA ASI POR QUE SI UN ITEM ES INVALIDO Y LOS OTROS NO HACE LIO, POR QUE AL HACER EL ROLLBACK NO SE SABE CUAL ITEM DIO ERROR
				// ES HORRIBLE!!!
				for (Item item : this.getOrdenDeVenta().getItems()) {
					errores = item.esValido();
					if (!errores.esVacio()) {
						item.setErrores(errores);
						throw new Exception(errores.toString());
					}
					
				}
				for (Item item : this.getOrdenDeVenta().getItems()) {
					errores = item.guardar(); 
					if (!errores.esVacio()){
						item.setErrores(errores);
						throw new Exception(errores.toString());
					}
				}
				
				// generar orden
				errores = this.getOrdenDeVenta().guardar();
				if (!errores.esVacio()) {
					this.getOrdenDeVenta().setErrores(errores);
					throw new Exception(errores.toString());
				}
				
			}catch (Exception e) {
				e.printStackTrace(); // despues quitar esto, solo lo deje para ver que erroes puede dar
				this.getOrdenDeVenta().setEstado(String.valueOf(Estados.ARMANDOSE.getId()));
				this.getOrdenDeVenta().rollbackGeneracion(); // NO HAY ROLLBACK DE ITEMS!!!
				if (!esErrorConocido(errores)) {
					errores.setGeneral("Ha ocurrido un error inesperado. Por favor intente más tarde.");
				}
			}
			
		}
		return errores;
	}
		
	private boolean esErrorConocido (Errores errores) {
		return errores.getCampo().containsKey("medioPago") || errores.getCampo().containsKey("monto") || // valores concidos para FACTURA
				errores.getCampo().containsKey("producto") || errores.getCampo().containsKey("cantidad") ||  // valores concidos para ITEM
				errores.getCampo().containsKey("cliente") || errores.getCampo().containsKey("items"); // valores conocidos para ORDENDEVENTA
		// FALTA AGREGAR VALORES CONOCIDOS PARA CLIENTE!!!!!!!!!!
	}
	
	private Errores generarFactura () {
		this.getOrdenDeVenta().getFactura().setOrdenDeVenta(this.getOrdenDeVenta());
		this.getOrdenDeVenta().getFactura().generarMontoTotal(this.getOrdenDeVenta().getItems());
		return this.getOrdenDeVenta().getFactura().guardar();
	}
	
	public Errores agregarProductoPorCodigo () {
		Errores errores = new Errores();
		if (!Utiles.esVacio(this.getCodigoAgregar())) {
			if (Validador.validarEntero(errores, "codigoAgregar", this.getCodigoAgregar(), 0, 9999999999999L, 12, false) 
					&& !this.getOrdenDeVenta().getItems().isEmpty()) {
				boolean existe = false;
				for (Item item : this.getOrdenDeVenta().getItems()) {
					if (item.getProducto().getCodigo().equals(this.getCodigoAgregar())) {
						existe = true;
					}
				}
				if (existe) {
					errores.setErrorCampo("codigoAgregar", "Ya agregó este producto a la orden.");
				}
			}
		}else {
			errores.setErrorCampo("codigoAgregar", "Ingrese el codigo del producto.");
		}
		if (errores.esVacio()) {
			try {
				List<Producto> productos = Producto.buscarProductos(null, null, this.getCodigoAgregar(), null, Boolean.TRUE);
				if (!productos.isEmpty()) {
					
					if (Integer.valueOf(productos.get(0).getStock()) < 1) {
						errores.setErrorCampo("codigoAgregar", "Este producto no esta en stock.");
						return errores;
					}
					
					if (!Utiles.esVacio(this.getCantidadAgregar())) {
						Validador.validarEntero(errores, "cantidadAgregar", this.getCantidadAgregar(), 1, Integer.valueOf(productos.get(0).getStock()), false);
					}else {
						errores.setErrorCampo("cantidadAgregar", "Ingrese la cantidad de productos.");
					}
					
					if (errores.esVacio()) {
						// es valido agregar item
						Item item = new Item();
						item.setCantidad(Integer.valueOf(this.getCantidadAgregar()));
						item.setProducto(productos.get(0));
						item.setOrdenDeVenta(this.getOrdenDeVenta());
						item.setPrecio(new BigDecimal(productos.get(0).getPrecio()));
						this.getOrdenDeVenta().getItems().add(item);
						this.getOrdenDeVenta().getFactura().generarMontoTotal(this.getOrdenDeVenta().getItems());
					}
					
					
				}else {
					errores.setErrorCampo("codigoAgregar", "El producto no existe o no esta a la venta.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				errores.setGeneral("Ha ocurrido un error inesperado. Por favor intente más tarde.");
			}
		}
		return errores;
	}
	
	public void quitarProducto (String idProducto) {
		Item itemBuscado = null;
		for (Item item : this.getOrdenDeVenta().getItems()) {
			if (item.getProducto().getId() == Integer.valueOf(idProducto).intValue()) {
				itemBuscado = item;
			}
		}
		this.getOrdenDeVenta().getItems().remove(itemBuscado);
		this.getOrdenDeVenta().getFactura().generarMontoTotal(this.getOrdenDeVenta().getItems());
	}
	
	public Errores cancelarVentaActual () {
		return this.getOrdenDeVenta().eliminar();
	}
	
	public void actualizarConActual () {
		OrdenDeVenta actual = null;
		try {
			actual = OrdenDeVenta.buscarOrdenActual();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setOrdenDeVenta(actual);
	}

	
	public void resetearInputVenta () {
		this.setOrdenDeVenta(null);
		this.setCodigoAgregar(null);
		this.setCantidadAgregar(null);
		this.setDni(null);
		this.setBuscador(null);
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

	public String getCantidadAgregar() {
		return cantidadAgregar;
	}

	public void setCantidadAgregar(String cantidadAgregar) {
		this.cantidadAgregar = cantidadAgregar;
	}
}
