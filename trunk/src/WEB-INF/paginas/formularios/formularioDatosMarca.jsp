<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" style="width: 200px" name="nombre"
			id="nombre" value="<c:out value="${marca.nombre}" />" /> * <c:if
				test="${!empty marca.errores.nombre}">
				<div class="errorEntrada">${marca.errores.nombre}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Sitio web:</td>
		<td><input type="text" style="width: 600px" name="sitioWeb"
			id="sitioWeb" value="<c:out value="${marca.sitioWeb}" />" /> <c:if
				test="${!empty marca.errores.sitioWeb}">
				<div class="errorEntrada">${marca.errores.sitioWeb}</div>
			</c:if></td>

	</tr>
	<tr>
		<td class="labelForm">Contacto:</td>
		<td><textarea rows="3" style="width: 600px; resize: none;"
				name="contacto" id="contacto"><c:out value="${marca.contacto}" /></textarea>
			<c:if test="${!empty marca.errores.contacto}">
				<div class="errorEntrada">${marca.errores.contacto}</div>
			</c:if></td>

	</tr>
	<tr>
		<td class="labelForm">Info adicional:</td>
		<td><textarea rows="6" style="width: 600px; resize: none;"
				name="infoAdicional" id="infoAdicional"><c:out value="${marca.infoAdicional}" /></textarea>
			<c:if test="${!empty marca.errores.infoAdicional}">
				<div class="errorEntrada">${marca.errores.infoAdicional}</div>
			</c:if></td>
	</tr>
</table>