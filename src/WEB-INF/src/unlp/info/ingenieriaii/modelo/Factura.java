package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import unlp.info.ingenieriaii.web.AccesoDb;

public class Factura extends ObjetoPersistente<Factura, Integer>{

	private Integer numero;
	private String tipo;
	private Float monto;
	private boolean anulada;
	private String medioPago;
	
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
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
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
		this.setId(rs);
		this.setMedioPago(rs);
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
	public String getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	
	protected void setMedioPago(ResultSet rs) throws SQLException {
		this.setMedioPago(String.valueOf(this.getColumnaInt(rs, "medioPago")));
	}
	
}
