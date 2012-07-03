package unlp.info.ingenieriaii.web;


public class ReportePBMinServlet extends ServletPaginaReporte {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8678944853472499722L;

	@Override
	protected String getNombreReporte() {
		
		return "Productos en Stock Bajo";
	}

	@Override
	protected Boolean getParamBajoStock() {
		
		return Boolean.TRUE;
	}
}
