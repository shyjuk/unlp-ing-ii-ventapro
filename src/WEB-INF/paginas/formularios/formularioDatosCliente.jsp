<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" style="width: 200px" name="nombre"
			id="nombre" value="<c:out value="${cliente.nombre}" />" /> * <c:if
				test="${!empty errores.campo.nombre}">
				<div class="errorEntrada">${errores.campo.nombre}</div>
            </c:if></td>
 	</tr>
    <tr>    
		<td class="labelForm">Apellido:</td>
		<td><input type="text" style="width: 200px" name="apellido"
			id="apellido" value="<c:out value="${cliente.apellido}" />" /> * <c:if
				test="${!empty errores.campo.apellido}">
				<div class="errorEntrada">${errores.campo.apellido}</div>
            </c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Numero de Documento:</td>
		<td><input type="text" style="width: 200px" name="nroDocumento"
			id="nroDocumento" value="<c:out value="${cliente.nroDocumento}" />" /> *<c:if
				test="${!empty errores.campo.nroDocumento}">
				<div class="errorEntrada">${errores.campo.nroDocumento}</div>
			</c:if></td>
    </tr>
    <tr>    
			
		<td class="labelForm">Tipo de Documento:</td>
		<td><input type="text" style="width: 200px" name="tipoDocumento"
			id="tipoDocumento" value="<c:out value="${cliente.tipoDocumento}" />" /> *<c:if
				test="${!empty errores.campo.tipoDocumento}">
				<div class="errorEntrada">${errores.campo.tipoDocumento}</div>
			</c:if></td>
	</tr>

	<tr>
		<td class="labelForm">Teléfono:</td>
		<td><input type="text" style="width: 200px" name="telefono"
			id="telefono" value="<c:out value="${cliente.telefono}" />" /> <c:if
				test="${!empty errores.campo.telefono}">
				<div class="errorEntrada">${errores.campo.telefono}</div>
			</c:if></td>
 	</tr>
    <tr>    			
		<td class="labelForm">e-mail:</td>
		<td><input type="text" style="width: 200px" name="email"
			id="email" value="<c:out value="${cliente.email}" />" /> <c:if
				test="${!empty errores.campo.email}">
				<div class="errorEntrada">${errores.campo.email}</div>
			</c:if></td>
	</tr>
	
	<tr>
		<td class="labelForm">Dirección:</td>
		<td><input type="text" style="width: 350px" name="direccion"
			id="direccion" value="<c:out value="${cliente.direccion}" />" /> <c:if
				test="${!empty errores.campo.direccion}">
				<div class="errorEntrada">${errores.campo.direccion}</div>
		   </c:if></td>
	</tr>
	
</table>