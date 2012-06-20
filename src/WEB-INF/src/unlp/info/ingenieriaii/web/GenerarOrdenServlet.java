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
import unlp.info.ingenieriaii.modelo.Localidad;
import unlp.info.ingenieriaii.modelo.Marca;
import unlp.info.ingenieriaii.modelo.MediosDePago;
import unlp.info.ingenieriaii.modelo.OrdenDeVenta;
import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.Provincia;
import unlp.info.ingenieriaii.modelo.TipoProducto;
import unlp.info.ingenieriaii.modelo.Usuario;

public class GenerarOrdenServlet extends ServletPagina {

	public static final String EN_VENTA = "EN_VENTA";
	
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
	}


	private void setAll(HttpServletRequest req) throws SQLException {
		req.setAttribute("listaProvincias", Provincia.buscarProvincias(null));
		req.setAttribute("listaLocalidades", Localidad.buscarLocalidad(null));
		req.setAttribute("marcas", Marca.buscarMarcas(null));
		req.setAttribute("vendedor", Usuario.buscarUsuarios().get(0)); // Siempre tenemos 1 usuario
		req.setAttribute("fechaO", DateFormat.getInstance().format(new Date()));
		req.setAttribute("listaMedioPago", MediosDePago.todosMediosDePago());
		req.setAttribute("tiposProducto",TipoProducto.buscarTiposProducto(null));
	}
	

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		this.setAll(req);
		this.setBuscador(null, null, null, null, null, req, false);
		super.procesarGet(req, resp);
	}
	
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		this.setAll(req);
		
		if (req.getParameter("btnComenzar") != null) {
			OrdenDeVenta orden = new OrdenDeVenta();
			orden.guardar(); // Estado inicial de la orden
			req.setAttribute("estadoVenta", EN_VENTA);
			
			this.setBuscador(req.getParameter("nombre"),
					req.getParameter("codigo"), req.getParameter("idMarca"),
					req.getParameter("idTipoProducto"),
					req.getParameter("chkIncluir"), req,
					req.getParameter("btnBuscar") != null);
			
			super.procesarPost(req, resp);
		} else if (req.getParameter("btnBuscarCliente") != null) { 
			InputVenta inputVentaBean = (InputVenta) req.getSession().getAttribute("inputVenta");
			inputVentaBean.setDni((String)req.getParameter("dniBusqueda"));
			Errores errores = new Errores();
			errores = inputVentaBean.buscarCliente();
			req.setAttribute("erroresInputVenta", errores);
			super.procesarPost(req, resp);
		}else {
			this.setBuscador(req.getParameter("nombre"),
					req.getParameter("codigo"), req.getParameter("idMarca"),
					req.getParameter("idTipoProducto"),
					req.getParameter("chkIncluir"), req,
					req.getParameter("btnBuscar") != null);
			super.procesarPost(req, resp);
		}
		
		
	}
}
