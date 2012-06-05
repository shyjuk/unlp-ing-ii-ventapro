package unlp.info.ingenieriaii.web;

import java.io.IOException;

import javax.servlet.*;

import unlp.info.ingenieriaii.test.GeneradorDeDatos;

public class AppServlet implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e) {
		try {
			AccesoDb.cargarConfig(e.getServletContext());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("NO SE PUDO CARGAR LA CONFIG DE LA BD!!!");
		}
		
        try {
			GeneradorDeDatos.generarTiposDeProductos();
			GeneradorDeDatos.generarMarcas();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

		System.out.println("Applicación iniciada");
	}

	public void contextDestroyed(ServletContextEvent e) {
		// Connection con =
		// (Connection) e.getServletContext().getAttribute("con");
		// try { con.close(); }
		// catch (SQLException ignored) { } // close connection
		System.out.println("contextDestroyed(ServletContextEvent e)");
	}
}
