<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" style="width: 200px" name="nombre"
			id="nombre" value="<c:out value="${marca.nombre}" />" /> * <c:if
				test="${!empty errores.campo.nombre}">
				<div class="errorEntrada">${errores.campo.nombre}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Sitio web:</td>
		<td><input type="text" style="width: 600px" name="sitioWeb"
			id="sitioWeb" value="<c:out value="${marca.sitioWeb}" />" /> <c:if
				test="${!empty errores.campo.sitioWeb}">
				<div class="errorEntrada">${errores.campo.sitioWeb}</div>
			</c:if></td>

	</tr>
	<tr>
		<td class="labelForm">Contacto:</td>
		<td><textarea rows="3" style="width: 600px; resize: none;"
				name="contacto" id="contacto"><c:out value="${marca.contacto}" /></textarea>
			<c:if test="${!empty errores.campo.contacto}">
				<div class="errorEntrada">${errores.campo.contacto}</div>
			</c:if></td>

	</tr>
	<tr>
		<td class="labelForm">Info adicional:</td>
		<td><textarea rows="6" style="width: 600px; resize: none;"
				name="infoAdicional" id="infoAdicional"><c:out value="${marca.infoAdicional}" /></textarea>
			<c:if test="${!empty errores.campo.infoAdicional}">
				<div class="errorEntrada">${errores.campo.infoAdicional}</div>
			</c:if></td>
	</tr>
</table>