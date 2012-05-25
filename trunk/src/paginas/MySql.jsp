<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.web.AccesoDb"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>MySQL test</title>
</head>
<body>

	<%
		//Esto es una chantada temporal, tengo que ver de mejorar los templates y preguntarle a Daiana si hay una especie de evento AppStart
		AccesoDb.cargarConfig(this.getServletContext());

		AccesoDb acceso = new AccesoDb();
		ResultSet rs;

		String nombreRnd = "TipoProducto-" + (new Date()).toString();

		acceso.ejecutarQuery("CALL agregarCategoria('" + nombreRnd + "')");
	%>

	<table border="1">
		<%
			rs = acceso.ejecutarQuery("SELECT * FROM tbl_persona");
		%>
		<tr>
			<%
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			%>
			<td><%=rs.getMetaData().getColumnName(i)%></td>
			<%
				}
			%>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<%
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			%>
			<td><%=rs.getString(i)%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>

	<br />
	<br />
	<br />
	<br />
	<br />

	<table border="1">
		<%
			rs = acceso.ejecutarQuery("SELECT * FROM tbl_categoria");
		%>
		<tr>
			<%
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			%>
			<td><%=rs.getMetaData().getColumnName(i)%></td>
			<%
				}
			%>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<%
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			%>
			<td><%=rs.getString(i)%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>