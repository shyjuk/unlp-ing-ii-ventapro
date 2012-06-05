package unlp.info.ingenieriaii.web;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletContext;

public class AccesoDb {

	public static final int ERROR_DESCONOCIDO = -1;
	public static final int ERROR_EN_USO = -2; // El objeto que se quiere
												// eliminar está referenciado
												// por otros
	public static final int ERROR_VALOR_DUPLICADO = -3; // El objeto no tiene
														// suficiente unicidad.
	public static final int ERROR_REFERENCIA = -4; // El/los objeto(s) al/los
													// que se intenta hacer
													// referencia no existe(n)

	public static final int ER_ROW_IS_REFERENCED_2 = 1451;
	public static final int ER_NO_REFERENCED_ROW_2 = 1452;

	private static final String DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String ARCHIVO_CONFIG = "/WEB-INF/settings/MySql.txt";

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
	private PreparedStatement sentencia;
	private ResultSet resultado;

	public static Connection abrirConexion() throws SQLException {

		return DriverManager.getConnection(AccesoDb.connectionString);
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

	public static PreparedStatement abrirStatementPreparado(
			Connection conexion, String query) throws SQLException {

		return conexion.prepareStatement(query);
	}

	public static void cerrarStatementPreparado(PreparedStatement sentencia)
			throws SQLException {

		cerrarStatement(sentencia);
	}

	public static CallableStatement abrirLlamadaPreparada(Connection conexion,
			String query) throws SQLException {

		return conexion.prepareCall(query);
	}

	public static void cerrarLlamadaPreparada(CallableStatement sentencia)
			throws SQLException {

		cerrarStatement(sentencia);
	}

	public static ResultSet ejecutarQuery(Statement sentencia, String query)
			throws SQLException {

		return sentencia.executeQuery(query);
	}

	public static ResultSet abrirResultado(PreparedStatement sentencia)
			throws SQLException {

		return sentencia.executeQuery();
	}

	public static void cerrarResultado(ResultSet rs) throws SQLException {

		rs.close();
	}

	public static int getColumnaInt(ResultSet rs, String tabla, String columna)
			throws SQLException {

		return rs.getInt(tabla + "." + columna);
	}

	public static byte getColumnaByte(ResultSet rs, String tabla, String columna)
			throws SQLException {

		return rs.getByte(tabla + "." + columna);
	}

	public static boolean getColumnaBoolean(ResultSet rs, String tabla,
			String columna) throws SQLException {

		return rs.getBoolean(tabla + "." + columna);
	}

	public static String getColumnaString(ResultSet rs, String tabla,
			String columna) throws SQLException {

		return rs.getString(tabla + "." + columna);
	}

	public AccesoDb() {

	}

	public void abrir() throws SQLException {

		if (this.conexion == null)
			this.conexion = AccesoDb.abrirConexion();
	}

	public void cerrarQuery() throws SQLException {

		if (this.resultado != null)
			cerrarResultado(this.resultado);

		if (this.sentencia != null)
			cerrarStatement(this.sentencia);

		this.resultado = null;
		this.sentencia = null;
	}

	public void cerrar() throws SQLException {

		this.cerrarQuery();

		if (this.conexion != null)
			cerrarConexion(this.conexion);

		this.conexion = null;
	}

	private void reset() throws SQLException {

		this.cerrarQuery();
		this.abrir();
	}

	public ResultSet ejecutarQuery() throws SQLException {

		return (this.resultado = abrirResultado(this.sentencia));
	}

	public ResultSet ejecutarQuery(String query) throws SQLException {

		this.reset();

		this.sentencia = abrirStatementPreparado(this.conexion, query);
		this.resultado = ejecutarQuery(this.sentencia, query);

		return this.resultado;
	}

	public boolean ejecutarQueryMultiSet() throws SQLException {

		return sentencia.execute();
	}

	public boolean ejecutarQueryMultiSet(String query) throws SQLException {

		this.reset();

		this.prepararQuery(query);

		return this.ejecutarQueryMultiSet();
	}

	public ResultSet proximoResultSet() throws SQLException {

		if (this.resultado != null)
			this.sentencia.getMoreResults();

		this.resultado = this.sentencia.getResultSet();

		// OJO, el OR con una sola | es a propósito.
		while (this.resultado == null
				&& (this.sentencia.getUpdateCount() != -1 | this.sentencia
						.getMoreResults()))
			this.resultado = this.sentencia.getResultSet();

		return this.resultado;
	}

	public void prepararQuery(String query) throws SQLException {

		this.reset();

		this.sentencia = abrirStatementPreparado(this.conexion, query);
	}

	public void prepararLlamada(String query) throws SQLException {

		this.reset();

		this.sentencia = abrirLlamadaPreparada(this.conexion, query);
	}

	public void setParamInt(int pos, Integer valor) throws SQLException {

		if (valor != null)
			this.sentencia.setInt(pos, valor.intValue());
		else
			this.sentencia.setNull(pos, Types.INTEGER);
	}

	public void setParamByte(int pos, Byte valor) throws SQLException {

		if (valor != null)
			this.sentencia.setByte(pos, valor.byteValue());
		else
			this.sentencia.setNull(pos, Types.TINYINT);
	}

	public void setParamBoolean(int pos, Boolean valor) throws SQLException {

		if (valor != null)
			this.sentencia.setBoolean(pos, valor.booleanValue());
		else
			this.sentencia.setNull(pos, Types.TINYINT);
	}

	public void setParamVarchar(int pos, String valor) throws SQLException {

		if (valor != null)
			this.sentencia.setString(pos, valor);
		else
			this.sentencia.setNull(pos, Types.VARCHAR);
	}

}
