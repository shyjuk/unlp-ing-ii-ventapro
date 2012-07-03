package unlp.info.ingenieriaii.web;

public class ProdInactivosServlet extends ServletPaginaReporte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6685726635955522523L;

	@Override
	protected String getNombreReporte() {
		
		return "Productos Inactivos";
	}

	@Override
	protected Boolean getParamEnVenta() {
		
		return Boolean.FALSE;
	}

	

}
