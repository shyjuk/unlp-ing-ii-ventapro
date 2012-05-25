<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>
<jsp:useBean id="tipoDeProducto" class="unlp.info.ingenieriaii.modelo.TipoDeProducto" scope="session"/>
<jsp:setProperty name="tipoDeProducto" property="*"/> 

<script type="text/javascript">
	
</script>
<table>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" name="nombre" id="nombre" size="50" value="<%=Utiles.getNotNullValue(tipoDeProducto.getNombre())%>"/> *</td>
	</tr>
	<tr>
		<td class="labelForm">Descripción:</td>
		<td><input type="text" name="descripcion" id="descripcion" size="50" value="<%=Utiles.getNotNullValue(tipoDeProducto.getDescripcion())%>"/></td>
	</tr>
</table>