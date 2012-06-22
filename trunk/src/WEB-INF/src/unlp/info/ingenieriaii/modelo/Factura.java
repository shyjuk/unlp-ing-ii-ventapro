package unlp.info.ingenieriaii.modelo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Factura extends ObjetoPersistente<Factura, Integer>{

	private Integer numero;
	private String tipo;
	private BigDecimal monto;
	private boolean anulada;
	private Integer medioPago;
	private OrdenDeVenta ordenDeVenta;

	//
	private Errores errores;
	
	
	private static final String QUERY_ALTA = "{call generarFactura(?,?,?)}";
	
	public Factura(ResultSet rs) throws SQLException {
		this.setDatos(rs);
	}
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public boolean isAnulada() {
		return anulada;
	}
	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}
	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		// FALTA EL RESTO DE LOS CAMPOS
		/*this.setId(rs);
		this.setMedioPago(rs);*/
	}
	@Override
	protected Factura getCopia(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void prepararLectura(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararAlta(AccesoDb db) throws SQLException {
		db.prepararLlamada(QUERY_ALTA);
		db.setParamInt(1, this.getOrdenDeVenta().getId());
		db.setParamDecimal(2, this.getMonto());
		db.setParamInt(3, this.getMedioPago());
	}
	@Override
	protected void prepararModificacion(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void prepararBaja(AccesoDb db) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setId(ResultSet rs) throws SQLException {
		this.setId(this.getColumnaInt(rs, "idFactura"));
	}
	@Override
	protected Errores validarCampos() {
		Errores errores = new Errores();
		if (this.getMedioPago() == null) {
			errores.setErrorCampo("medioPago", "Seleccione el medio de pago");
		}
		if (this.getMonto() == null || this.getMonto().equals(BigDecimal.ZERO)) {
			errores.setErrorCampo("monto", "El monto debe ser mayor a cero.");
		}
		return errores;
	}
	@Override
	protected void manejarErrorDuplicado(Errores errores, Factura copia) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void manejarErrorEnUso(Errores errores) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void manejarErrorReferencia(Errores errores, ResultSet rs)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public Integer getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(Integer medioPago) {
		this.medioPago = medioPago;
	}
	
	protected void setMedioPago(ResultSet rs) throws SQLException {
		this.setMedioPago(this.getColumnaInt(rs, "medioPago"));
	}

	public OrdenDeVenta getOrdenDeVenta() {
		return ordenDeVenta;
	}

	public void setOrdenDeVenta(OrdenDeVenta ordenDeVenta) {
		this.ordenDeVenta = ordenDeVenta;
	}
	
	public void generarMontoTotal (List<Item> items) {
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : items) {
			total = total.add(item.getPrecio().multiply(new BigDecimal(item.getCantidad())));
		}
		this.setMonto(total);
	}

	public Errores getErrores() {
		return errores;
	}

	public void setErrores(Errores errores) {
		this.errores = errores;
	}
	
}
