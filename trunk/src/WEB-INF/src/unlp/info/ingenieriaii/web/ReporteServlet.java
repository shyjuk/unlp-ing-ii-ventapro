package unlp.info.ingenieriaii.web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.*;

public class ReporteServlet extends ServletPagina{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7934179792801662812L;
	
	private static final String PATH_REPORTES = "/WEB-INF/reportes/";
	
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		// LO UNICO QUE DEBERIAN IMPLEMENTAR LAS SUB CLASES DEBERIAN SER:
		// PARAMETERS
		// REPORTE (*.jasper)
		
		try {
			Connection conexion = AccesoDb.abrirConexion(); 
			
			String pathReportFile = this.getServletContext().getRealPath(PATH_REPORTES + "TodosLosProductos.jasper");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("nom","valor"); // estos son lo parametros para hacer el query
			parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "AR"));
			
			byte[] bytes = JasperRunManager.runReportToPdf(pathReportFile, parameters, conexion);
			
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream outputStream = resp.getOutputStream();
			outputStream.write(bytes,0,bytes.length);
			
			outputStream.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//super.procesarGet(req, resp);
	}
	
	
}
