<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>
<jsp:useBean id="buscadorTipoProd" class="unlp.info.ingenieriaii.web.BuscadorTipoDeProducto" scope="session"/>
<jsp:setProperty name="buscadorTipoProd" property="*"/> 
<%
buscadorTipoProd.setNombre("a");
buscadorTipoProd.ejecutarBusqueda();
%>
<table width="80%">
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" name="nombre" id="nombre" size="50" value="<%=Utiles.getNotNullValue(buscadorTipoProd.getNombre())%>"/>&nbsp*</td>
	</tr>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<tr>
		<td colspan="2">
			<fieldset>
				<legend>Resultado de la búsqueda</legend>
				<table border="1" width="100%" cellpading="0" cellspacing="0">
					<tr>
						<td align="center">Nombre</td>
						<td align="center">Descripcion</td>
						<td align="center">Editar</td>
						<td align="center">Borrar</td>
					</tr>
					<% for (ObjetoPersistente row : buscadorTipoProd.getResultado()) {%>
						<tr>
							<td><%=Utiles.getNotNullValue(((TipoDeProducto)row).getNombre())%></td>
							<td><%=Utiles.getNotNullValue(((TipoDeProducto)row).getDescripcion())%></td>
							<td align="center"><a href="editarTipoProducto.jsp" alt="Editar"><img src="imagenes/iconos/edit.gif"/></a></td>
							<td align="center"><a href="algo" alt="Borrar"><img src="imagenes/iconos/button_delete.gif"/></a></td>
						</tr>
					<%}%>
				</table>
			</fieldset>
		</td>
	</tr>
</table>