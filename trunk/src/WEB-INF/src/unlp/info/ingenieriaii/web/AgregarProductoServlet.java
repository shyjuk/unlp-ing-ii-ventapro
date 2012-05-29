package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Producto;
import unlp.info.ingenieriaii.modelo.SucursalUno;
import unlp.info.ingenieriaii.modelo.TipoDeProducto;
import java.lang.Object;;

public class AgregarProductoServlet extends ServletPagina{

	private static final long serialVersionUID = -6737178893187649667L;
	
	private static boolean isInteger(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;} 
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
	private static boolean isFloat(String cadena){
		try {
			Float.parseFloat(cadena);
			return true;} 
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Producto object = new Producto();
		
		if (AgregarProductoServlet.isInteger(req.getParameter("codigo"))){
			object.setCodigo(Integer.valueOf(req.getParameter("codigo")).intValue());}
		else object.setCodigo(0);
		object.setNombre(req.getParameter("nombre"));
		if (AgregarProductoServlet.isInteger(req.getParameter("precio"))){
			object.setPrecio(Float.parseFloat(req.getParameter("precio")));}
		else object.setPrecio(0);
		object.setMarca(req.getParameter("marca"));
		object.setMarca(req.getParameter("tipoDeProducto"));
		if (AgregarProductoServlet.isInteger(req.getParameter("garantia"))){
			object.setGarantia(Integer.valueOf(req.getParameter("garantia")).intValue());}
		else object.setGarantia(0);
		if (AgregarProductoServlet.isInteger(req.getParameter("stock"))){
			object.setStock(Integer.valueOf(req.getParameter("stock")).intValue());}
		else object.setStock(0);
		if (AgregarProductoServlet.isInteger(req.getParameter("stockMinimo"))){
			object.setStockMinimo(Integer.valueOf(req.getParameter("stockMinimo")).intValue());}
		else object.setStockMinimo(0);
		object.setEnVenta("Si");
		object.setDescripcion(req.getParameter("descripcion"));
		if (object.esValidoParaCrear()) {
			try {
				SucursalUno.getSingleInstance().agregar(object);
				//despacharJsp("buscarTipoProducto.jsp", req, resp);
				resp.sendRedirect("buscarProducto.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("errores", object.getErrores());
			super.procesarPost(req, resp);
		}
	}

}