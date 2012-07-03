package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

public class FacturaServlet extends ServletPagina {

	
	private static final long serialVersionUID = -2694263589489510674L;
	
	protected static final String PATH_REPORTES = "/WEB-INF/reportes/";

	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		try {
			Connection conexion = AccesoDb.abrirConexion(); 
			
			String orden = (String)req.getParameter("num_orden");
			
			
			String pathReportFile = this.getServletContext().getRealPath(PATH_REPORTES + "Factura.jasper");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("num_orden", Integer.valueOf(orden));
			
			byte[] bytes = JasperRunManager.runReportToPdf(pathReportFile, parameters, conexion);
			
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream outputStream = resp.getOutputStream();
			outputStream.write(bytes,0,bytes.length);
			
			outputStream.flush();
			conexion.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
