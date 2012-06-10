package unlp.info.ingenieriaii.web;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

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
	private static final String PATH_SQL = "/WEB-INF/sql";

	private static String connectionString;

	static {

		try {
			Class.forName(DRIVER).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void colectarArchivos(ArrayList<File> archivos, String path,
			String extension) {
		File archivo = new File(path);

		if (!archivo.isDirectory()) {
			if (archivo.getName().endsWith(extension))
				archivos.add(archivo);
		} else {
			for (File file : archivo.listFiles())
				colectarArchivos(archivos, file.getAbsolutePath(), extension);
		}
	}

	private static String leerArchivo(String path) throws IOException {
		FileInputStream archivo = new FileInputStream(path);

		// Al parecer en Java es así de dificil convertir un stream a String...
		Writer writer = new StringWriter();

		char[] buffer = new char[1024];
		try {
			Reader reader = new BufferedReader(new InputStreamReader(archivo,
					"UTF-8"));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} finally {
			archivo.close();
		}

		return writer.toString();
	}

	public static void cargarConfig(ServletContext context) throws IOException {

		AccesoDb.connectionString = leerArchivo(
				context.getRealPath(ARCHIVO_CONFIG)).trim();
	}

	public static void regenerarRutinas(ServletContext context)
			throws SQLException, IOException {
		ArrayList<File> archivos = new ArrayList<File>();
		AccesoDb db = new AccesoDb();

		colectarArchivos(archivos, context.getRealPath(PATH_SQL), ".sql");

		for (File archivo : archivos) {
			String nombre = archivo.getName().substring(0,
					archivo.getName().length() - 4);

			// Primero droppear lo que esté con el mismo nombre
			db.ejecutarScript(String
					.format("DROP PROCEDURE IF EXISTS %s;\n DROP FUNCTION IF EXISTS %s;",
							nombre, nombre));

			// Ahora volver a crear:
			db.ejecutarScript(leerArchivo(archivo.getAbsolutePath()));
		}
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

	public static Integer getColumnaInt(ResultSet rs, String entidad,
			String columna) throws SQLException {
		int valor = rs.getInt(entidad + "_" + columna);

		return rs.wasNull() ? null : new Integer(valor);
	}

	public static Byte getColumnaByte(ResultSet rs, String entidad,
			String columna) throws SQLException {
		byte valor = rs.getByte(entidad + "_" + columna);

		return rs.wasNull() ? null : new Byte(valor);
	}

	public static Boolean getColumnaBoolean(ResultSet rs, String entidad,
			String columna) throws SQLException {
		boolean valor = rs.getBoolean(entidad + "_" + columna);

		return rs.wasNull() ? null : new Boolean(valor);
	}

	public static BigDecimal getColumnaDecimal(ResultSet rs, String entidad,
			String columna) throws SQLException {

		return rs.getBigDecimal(entidad + "_" + columna);
	}

	public static String getColumnaString(ResultSet rs, String entidad,
			String columna) throws SQLException {

		return rs.getString(entidad + "_" + columna);
	}
	
	public static Date getColumnaDate(ResultSet rs, String entidad,
			String columna) throws SQLException {

		return rs.getDate(entidad + "_" + columna);
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

	public void ejecutarScript(String script) throws IOException, SQLException {
		ScriptRunner runner;

		this.reset();

		runner = new ScriptRunner(this.conexion, true, true);
		runner.setLogWriter(null);
		runner.runScript(new BufferedReader(new StringReader(script)));
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

	public void setParamDecimal(int pos, BigDecimal valor) throws SQLException {

		if (valor != null)
			this.sentencia.setBigDecimal(pos, valor);
		else
			this.sentencia.setNull(pos, Types.DECIMAL);
	}

	public void setParamVarchar(int pos, String valor) throws SQLException {

		if (!Utiles.esVacio(valor))
			this.sentencia.setString(pos, valor);
		else
			this.sentencia.setNull(pos, Types.VARCHAR);
	}
	
	public void setParamDate(int pos, Date valor) throws SQLException {

		if (valor != null)
			this.sentencia.setDate(pos, valor);
		else
			this.sentencia.setNull(pos, Types.DATE);
	}

}
