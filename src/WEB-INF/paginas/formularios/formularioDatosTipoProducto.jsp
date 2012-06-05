<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" style="width: 200px" name="nombre"
			id="nombre" value="<c:out value="${tipoProducto.nombre}" />" /> * <c:if
				test="${!empty errores.campo.nombre}">
				<div class="errorEntrada">${errores.campo.nombre}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Descripción:</td>
		<td><input type="text" style="width: 600px" name="descripcion"
			id="descripcion" value="<c:out value="${tipoProducto.descripcion}" />" /> <c:if
				test="${!empty errores.campo.descripcion}">
				<div class="errorEntrada">${errores.campo.descripcion}</div>
			</c:if></td>

	</tr>
</table>