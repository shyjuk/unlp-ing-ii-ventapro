package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.MediosDePago;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.TipoProducto;
import unlp.info.ingenieriaii.modelo.Usuario;

public class GenerarOrdenServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1531432703598334033L;
	
	private String setListaId(BuscadorProducto buscador) {
		ArrayList<Integer> lista = new java.util.ArrayList<Integer>();

		for (Producto object : buscador.getResultado())
			lista.add(object.getId());

		return lista.toString();
	}
	
	private void setBuscador(String nombre, String codigo, String idMarca,
			String idTipoProducto, String incluirOcultos,
			HttpServletRequest req, boolean validar) throws SQLException {
		BuscadorProducto buscadorProducto = new BuscadorProducto();
		Integer intIdMarca = Utiles.esVacio(idMarca) ? null : new Integer(
				idMarca);
		Integer intIdTipoProducto = Utiles.esVacio(idTipoProducto) ? null
				: new Integer(idTipoProducto);
		Boolean blnIncluirOcultos = Utiles.esVacio(incluirOcultos) ? Boolean.FALSE
				: new Boolean(incluirOcultos);
		Errores errores;

		buscadorProducto.setNombre(Utiles.esVacio(nombre) ? null:nombre);
		buscadorProducto.setCodigo(Utiles.esVacio(codigo) ? null: codigo);
		buscadorProducto.setIdMarca(intIdMarca);
		buscadorProducto.setIdTipoProducto(intIdTipoProducto);
		buscadorProducto.setEnVenta(blnIncluirOcultos ? null : Boolean.TRUE);
		errores = buscadorProducto.buscar(validar);

		req.setAttribute("buscador", buscadorProducto);
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscadorProducto));

		req.setAttribute("marcas", Marca.buscarMarcas(null));
		req.setAttribute("vendedor", Usuario.buscarUsuarios().get(0)); // Siempre tenemos 1 usuario
		req.setAttribute("fechaO", DateFormat.getInstance().format(new Date()));
		req.setAttribute("listaMedioPago", MediosDePago.todosMediosDePago());
		req.setAttribute("tiposProducto",TipoProducto.buscarTiposProducto(null));
	}


	private void setAll(HttpServletRequest req, boolean validar) throws SQLException {
		BuscadorProducto buscadorProducto = new BuscadorProducto();
		Errores errores = new Errores();
		buscadorProducto.buscar(false);
		
		req.setAttribute("errores", errores);
		req.setAttribute("listaId", this.setListaId(buscadorProducto));
		req.setAttribute("clientes", Usuario.buscarUsuarios());
		java.util.Date fechaActual = new java.util.Date(); 
		req.setAttribute("fechaO", fechaActual.toString());
		req.setAttribute("horaO", fechaActual.getTime());
		req.setAttribute("buscador", buscadorProducto);
		//req.setAttribute("items", items)
	}
	

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		Boolean validar=false;
		
		req.setAttribute("orden", new OrdenDeVenta());
		//this.setAll(req, validar);
		this.setBuscador(null, null, null, null, null, req, false);

		super.procesarGet(req, resp);
	}
	
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
//		OrdenDeVenta orden = new OrdenDeVenta();
//		String idUsuario = req.getParameter("idVendedor");
//		String idCliente = req.getParameter("idCliente");
//		String idMarca = req.getParameter("idMarca");
//		String idTipoProducto = req.getParameter("idTipoProducto");
//		List<Item> items = new List<Item>();
//		
//		
//		Errores errores;
//
//		//orden.setNumero(numero);
//		orden.setIdUsuario(Utiles.esVacio(idUsuario) ? null : new Integer(idUsuario));
//		orden.setEstado("Pendiente");
//		orden.setIdCliente(Utiles.esVacio(idCliente) ? null : new Integer(idCliente));
//		orden.setFactura(null);
//		orden.setIdFactura(null);
//		orden.setItems(items);
//		
//		errores = orden.guardar();
//
//		if (errores.esVacio()) {
//
//			resp.sendRedirect("generarOrden.jsp");
//		} else {
//
//			req.setAttribute("producto", producto);
//			req.setAttribute("tipoProducto", producto);
//			req.setAttribute("errores", errores);
//			this.setCombos(req);
//
//			super.procesarPost(req, resp);
//		}
		
		this.setBuscador(req.getParameter("nombre"),
				req.getParameter("codigo"), req.getParameter("idMarca"),
				req.getParameter("idTipoProducto"),
				req.getParameter("chkIncluir"), req,
				req.getParameter("btnBuscar") != null);
		super.procesarPost(req, resp);
	}
}
