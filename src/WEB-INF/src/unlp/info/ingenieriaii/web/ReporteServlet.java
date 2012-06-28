package unlp.info.ingenieriaii.web;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.*;

import com.mysql.jdbc.*;

public class ReporteServlet extends ServletPagina{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7934179792801662812L;
	
	
	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		// LO UNICO QUE DEBERIAN IMPLEMENTAR LAS SUB CLASES DEBERIAN SER:
		// PARAMETERS
		// REPORTE (*.jasper)
		
		try {
			// la conexion deberia estar en otro lado
			Connection conexion;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// ojo este es mi usuario y pass, cada uno tiene uno diferente, esto habria que tomarlo de MySql.txt
			//conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_ventapro","user","pass");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_ventapro","root","root"); 
			
			File reportFile = new File("c://TodosLosProductos.jasper"); // el directorio deberia ser dentro del proyecto
			Map parameters = new HashMap();
			parameters.put("nom","valor"); // estos son lo parametros para hacer el query
			
			byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
			
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
