package unlp.info.ingenieriaii.web;


public class ProdEnVentaServlet extends ServletPaginaReporte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3839943254267022954L;

	@Override
	protected String getNombreReporte() {
		
		return "Productos en Venta";
	}


}
