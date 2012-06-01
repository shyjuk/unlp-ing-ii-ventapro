package unlp.info.ingenieriaii.web;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletContext;

public class AccesoDb {

	private static final String DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String ARCHIVO_CONFIG = "/WEB-INF/MySqlConnectionString.txt";

	private static String connectionString;

	static {

		try {
			Class.forName(DRIVER).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cargarConfig(ServletContext context) throws IOException {
		InputStream config = context.getResourceAsStream(ARCHIVO_CONFIG);

		// Al parecer en Java es así de dificil convertir un stream a String...
		Writer writer = new StringWriter();

		char[] buffer = new char[1024];
		try {
			Reader reader = new BufferedReader(new InputStreamReader(config,
					"UTF-8"));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} finally {
			config.close();
		}

		AccesoDb.connectionString = writer.toString().trim();
	}

	private Connection conexion;
	private Statement sentencia;
	private ResultSet resultado;

	public static Connection abrirConexion() throws SQLException {

		return DriverManager
				.getConnection(AccesoDb.connectionString);
	}

	public static void cerrarConexion(Connection conexion) throws SQLException {

		conexion.close();
	}

	public static Statement abrirStatement(Connection conexion)
			throws SQLException {

		return conexion.createStatement();
	}

	public static void cerrarStatement(Statement sentencia) throws SQLException {

		sentencia.close();
	}

	public static ResultSet ejecutarQuery(Statement sentencia, String query)
			throws SQLException {

		return sentencia.executeQuery(query);
	}

	public AccesoDb() {

	}

	public void abrir() throws SQLException {

		if (this.conexion == null)
			this.conexion = AccesoDb.abrirConexion();
	}

	public void cerrarQuery() throws SQLException {

		if (this.resultado != null)
			this.resultado.close();

		if (this.sentencia != null)
			this.resultado.close();

		this.resultado = null;
		this.sentencia = null;
	}

	public void cerrar() throws SQLException {

		this.cerrarQuery();

		this.conexion.close();

		this.conexion = null;
	}

	public ResultSet ejecutarQuery(String query) throws SQLException {

		this.cerrarQuery();
		this.abrir();

		this.sentencia = this.conexion.createStatement();
		this.resultado = this.sentencia.executeQuery(query);

		return this.resultado;
	}

}
