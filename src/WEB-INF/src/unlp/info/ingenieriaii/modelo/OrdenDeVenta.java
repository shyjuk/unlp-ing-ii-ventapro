package unlp.info.ingenieriaii.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import unlp.info.ingenieriaii.web.AccesoDb;

public class OrdenDeVenta extends ObjetoPersistente<OrdenDeVenta, Integer> {
	
	private String numero;
	private Date fecha;
	private String estado;
	private Integer idCliente;
	private Integer idUsuario;
	private Integer idFactura;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	@Override
	protected void setDatos(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected OrdenDeVenta getCopia(ResultSet rs) throws SQLException {
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
		// TODO Auto-generated method stub
		
	}
	@Override
	protected Errores validarCampos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void manejarErrorDuplicado(Errores errores, OrdenDeVenta copia) {
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
	
	
	

}
