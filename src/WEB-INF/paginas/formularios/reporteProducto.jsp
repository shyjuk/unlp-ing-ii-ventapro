<%@page import="java.sql.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VentaPro - Agregar Cliente</title>
<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
</head>

<%

Connection  conexion = AccesoDb.abrirConexion();
ResultSet rs = conexion.createStatement().executeQuery((String)request.getAttribute("query"));%>

<table border=1>

<tr><th>Codigo</th><th>Nombre</th><th>Precio</th><th>Garantia</th><th>Stock</th><th>Stock Minimo</th><th>En Venta</th><th>Descripcion</th></tr>

<%while (rs.next()) {%>

		<tr>
			<td><%out.println(rs.getString("codigo"));%></td>
			<td><%out.println(rs.getString("nombre"));%></td>
			<td><%out.println(rs.getFloat("precio"));%></td>
			<td><%out.println(rs.getInt("garantia"));%></td>
			<td><%out.println(rs.getInt("stock"));%></td>
			<td><%out.println(rs.getInt("stockMinimo"));%></td>
			<td><%out.println(rs.getString("enVenta"));%></td>
			<td><%out.println(rs.getString("descripcion"));%></td>
<% 
}

out.println("</table>");

conexion.close();

%>