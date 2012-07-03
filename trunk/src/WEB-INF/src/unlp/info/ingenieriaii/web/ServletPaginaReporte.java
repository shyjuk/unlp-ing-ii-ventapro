package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperRunManager;

public abstract class ServletPaginaReporte extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1972862228532521751L;

	private static final String PATH_REPORTES = "/WEB-INF/reportes/";

	// Las subclases pueden reimplementar los siguientes dos métodos si gustan
	protected Boolean getParamEnVenta() {

		return Boolean.TRUE;
	}

	protected Boolean getParamBajoStock() {

		return Boolean.FALSE;
	}

	protected abstract String getNombreReporte();

	@Override
	protected final void procesarGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException,
			SQLException {

		// LO UNICO QUE DEBERIAN IMPLEMENTAR LAS SUB CLASES DEBERIAN SER:
		// PARAMETERS
		// REPORTE (*.jasper)

		if (req.getParameter("pdf") != null) {
			try {
				Connection conexion = AccesoDb.abrirConexion();

				String pathReportFile = this.getServletContext().getRealPath(
						PATH_REPORTES + "reporteProductos.jasper");

				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("nombreReporte", this.getNombreReporte()
						.toUpperCase());
				parameters.put("enVenta", this.getParamEnVenta());
				parameters.put("bajoStock", this.getParamBajoStock());
				parameters.put(JRParameter.REPORT_LOCALE,
						new Locale("es", "AR"));

				byte[] bytes = JasperRunManager.runReportToPdf(pathReportFile,
						parameters, conexion);

				resp.setContentType("application/pdf");
				resp.setContentLength(bytes.length);
				ServletOutputStream outputStream = resp.getOutputStream();
				outputStream.write(bytes, 0, bytes.length);

				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			super.procesarGet(req, resp);
	}
}
