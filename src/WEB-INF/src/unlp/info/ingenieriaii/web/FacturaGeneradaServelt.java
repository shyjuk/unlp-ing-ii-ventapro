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

public class FacturaGeneradaServelt extends ServletPagina{

	private static final long serialVersionUID = 1L;
	
	private static final String PATH_REPORTES = "/WEB-INF/reportes/";

	protected final void procesarGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException,
			SQLException {

		String numOrden = req.getParameter("num_orden");
		req.setAttribute("num_orden", numOrden);
		if (req.getParameter("pdf") != null) {
			try {
				Connection conexion = AccesoDb.abrirConexion();

				String pathReportFile = this.getServletContext().getRealPath( PATH_REPORTES + "factura.jasper");

				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("num_orden", Integer.valueOf(numOrden));
				parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "AR"));

				byte[] bytes = JasperRunManager.runReportToPdf(pathReportFile, parameters, conexion);

				resp.setContentType("application/pdf");
				resp.setContentLength(bytes.length);
				ServletOutputStream outputStream = resp.getOutputStream();
				outputStream.write(bytes, 0, bytes.length);

				outputStream.flush();
				AccesoDb.cerrarConexion(conexion);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			super.procesarGet(req, resp);
	}
	
	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if (req.getParameter("btnVolver") != null) {
			resp.sendRedirect("cobrarOrden.jsp");
		}
	}

}
