package unlp.info.ingenieriaii.web;

import javax.servlet.*;

import unlp.info.ingenieriaii.test.GeneradorDeDatos;

public class AppServlet implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e) {
		try {
			AccesoDb.cargarConfig(e.getServletContext());

			// Esto cuando el producto sea definitivo se podría sacar, por ahora
			// es conveniente que siempre se regenere todo.
			AccesoDb.regenerarRutinas(e.getServletContext());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("NO SE PUDO CARGAR LA CONFIG DE LA BD!!!");
		}

		try {
			GeneradorDeDatos.generarTiposDeProductos();
			GeneradorDeDatos.generarMarcas();
			GeneradorDeDatos.generarProductos();
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
