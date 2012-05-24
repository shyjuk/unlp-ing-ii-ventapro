<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.web.AccesoDb"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>MySQL test</title>
</head>
<body>

	<table>
		<tr>
			<td>id</td>
			<td>nombre</td>
			<td>tipoDocumento</td>
			<td>nroDocumento</td>
			<td>telefono</td>
			<td>celular</td>
			<td>eMail</td>
		</tr>
		<%
			//Esto es una chantada temporal, tengo que ver de mejorar los templates y preguntarle a Daiana si hay una especie de evento AppStart
			AccesoDb.cargarConfig(this.getServletContext());

			AccesoDb acceso = new AccesoDb();
			ResultSet rs = acceso.ejecutarQuery("SELECT * FROM tbl_persona");

			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("nombre")%></td>
			<td><%=rs.getString("tipoDocumento")%></td>
			<td><%=rs.getString("nroDocumento")%></td>
			<td><%=rs.getString("telefono")%></td>
			<td><%=rs.getString("celular")%></td>
			<td><%=rs.getString("eMail")%></td>
		</tr>
		<%
			}

			acceso.cerrar();
		%>
	</table>

</body>
</html>