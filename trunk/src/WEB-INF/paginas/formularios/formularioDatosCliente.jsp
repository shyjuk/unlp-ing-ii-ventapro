<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<td class="labelForm">Apellido:</td>
		<td><input type="text" style="width: 300px" name="apellido"
			id="apellido" value="<c:out value="${cliente.apellido}" />" /> * <c:if
				test="${!empty errores.campo.apellido}">
				<div class="errorEntrada">${errores.campo.apellido}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" style="width: 300px" name="nombre"
			id="nombre" value="<c:out value="${cliente.nombre}" />" /> * <c:if
				test="${!empty errores.campo.nombre}">
				<div class="errorEntrada">${errores.campo.nombre}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">DNI:</td>
		<td><input type="text" style="width: 300px" name="nroDocumento"
			id="nroDocumento" value="<c:out value="${cliente.nroDocumento}" />" />
			*<c:if test="${!empty errores.campo.nroDocumento}">
				<div class="errorEntrada">${errores.campo.nroDocumento}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Teléfono:</td>
		<td><input type="text" style="width: 300px" name="telefono"
			id="telefono" value="<c:out value="${cliente.telefono}" />" /> <c:if
				test="${!empty errores.campo.telefono}">
				<div class="errorEntrada">${errores.campo.telefono}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Celular:</td>
		<td><input type="text" style="width: 300px" name="celular"
			id="telefono" value="<c:out value="${cliente.celular}" />" /> <c:if
				test="${!empty errores.campo.celular}">
				<div class="errorEntrada">${errores.campo.celular}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">E-mail:</td>
		<td><input type="text" style="width: 300px" name="email"
			id="email" value="<c:out value="${cliente.email}" />" /> <c:if
				test="${!empty errores.campo.email}">
				<div class="errorEntrada">${errores.campo.email}</div>
			</c:if></td>
	</tr>
	<tr>
		<td colspan="2" class="separador"></td>
	</tr>
</table>

<fieldset>
	<legend>Dirección</legend>
	<table>
		<tr>
			<td class="labelForm">Calle:</td>
			<td><input type="text" style="width: 250px" name="calle"
				id="calle" value="<c:out value="${cliente.calle}" />" /> *</td>
			<td class="labelForm"></td>
			<td class="labelForm">Altura:</td>
			<td><input type="text" style="width: 50px" name="numeroCalle" 
				value="<c:out value="${cliente.numeroCalle}" />"/></td>
			<td class="labelForm"></td>
			<td class="labelForm">Dpto:</td>
			<td><input type="text" style="width: 50px" name="dpto" id="dpto"
				value="<c:out value="${cliente.dpto}" />" /></td>
		</tr>
		<c:if test="${!empty errores.campo.calle}">
			<tr>
				<td colspan="9">
					<div class="errorEntrada">Calle: ${errores.campo.calle}</div>
				</td>
			</tr>
		</c:if>
		<c:if test="${!empty errores.campo.numeroCalle}">
			<tr>
				<td colspan="9">
					<div class="errorEntrada">Altura:
						${errores.campo.numeroCalle}</div>
				</td>
			</tr>
		</c:if>
		<c:if test="${!empty errores.campo.dpto}">
			<tr>
				<td colspan="9">
					<div class="errorEntrada">Dpto: ${errores.campo.dpto}</div>
				</td>
			</tr>
		</c:if>
		<tr>
			<td class="labelForm">Localidad:</td>
			<td colspan="8"><select style="width: 256px" name="localidad"
				id="localidad">
					<option
						<c:if test="${empty cliente.localidad}">selected="selected"</c:if>
						value="">Otra:</option>
					<c:forEach items="${localidades}" var="localidad">
						<option
							<c:if test="${localidad.nombre == cliente.localidad}">selected="selected"</c:if>
							>${localidad.nombre}</option>
					</c:forEach>
					<option value="">Otra:</option>
			</select> *</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="8"><input type="text" style="width: 250px"
				name="localidadNueva" value="${localidadNueva}" /></td>
		</tr>
		<c:if test="${!empty errores.campo.localidad}">
			<tr>
				<td></td>
				<td colspan="8">
					<div class="errorEntrada">${errores.campo.localidad}</div>
				</td>
			</tr>
		</c:if>
	</table>
</fieldset>