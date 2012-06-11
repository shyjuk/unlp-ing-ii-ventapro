<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td></td>
		<td><input type="text" style="width: 300px" name="nombre"
			id="nombre" value="<c:out value="${producto.nombre}" />" /> * <c:if
				test="${!empty errores.campo.nombre}">
				<div class="errorEntrada">${errores.campo.nombre}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Código:</td>
		<td></td>
		<td><input type="text" style="width: 120px" name="codigo"
			id="codigo" value="<c:out value="${producto.codigo}" />" onkeypress="return isNumberKey(event);" /> * <c:if
				test="${!empty errores.campo.codigo}">
				<div class="errorEntrada">${errores.campo.codigo}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Marca:</td>
		<td></td>
		<td><select style="width: 200px" name="idMarca"
			onchange="redirect(this.options.selectedIndex)">
				<option
					<c:if test="${empty producto.marca.id}">selected="selected"</c:if>
					value=""></option>
				<c:forEach items="${marcas}" var="marca">
					<option
						<c:if test="${producto.marca.id == marca.id}">selected="selected"</c:if>
						value="${marca.id}">${marca.nombre}</option>
				</c:forEach>
		</select> * <c:if test="${!empty errores.campo.idMarca}">
				<div class="errorEntrada">${errores.campo.idMarca}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Tipo de producto:</td>
		<td></td>
		<td><select style="width: 200px" name="idTipoProducto"
			onchange="redirect(this.options.selectedIndex)">
				<option
					<c:if test="${empty producto.tipoProducto.id}">selected="selected"</c:if>
					value=""></option>
				<c:forEach items="${tiposProducto}" var="tipoProducto">
					<option
						<c:if test="${producto.tipoProducto.id == tipoProducto.id}">selected="selected"</c:if>
						value="${tipoProducto.id}">${tipoProducto.nombre}</option>
				</c:forEach>
		</select> * <c:if test="${!empty errores.campo.idTipoProducto}">
				<div class="errorEntrada">${errores.campo.idTipoProducto}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Precio:</td>
		<td>$</td>
		<td><input type="text" style="width: 120px" name="precio"
			id="precio" value="<c:out value="${producto.precio}" />" onkeypress="return isDecimalNumberKey(event);" /> * <c:if
				test="${!empty errores.campo.precio}">
				<div class="errorEntrada">${errores.campo.precio}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Garantía:</td>
		<td></td>
		<td><input type="text" style="width: 120px" name="garantia"
			id="garantia" value="<c:out value="${producto.garantia}" />" onkeypress="return isNumberKey(event);"/>
			meses <c:if test="${!empty errores.campo.garantia}">
				<div class="errorEntrada">${errores.campo.garantia}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Stock:</td>
		<td></td>
		<td><input type="text" style="width: 120px" name="stock"
			id="stock" value="<c:out value="${producto.stock}" />" /> unidades *<c:if
				test="${!empty errores.campo.stock}">
				<div class="errorEntrada">${errores.campo.stock}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Stock Mínimo:</td>
		<td></td>
		<td><input type="text" style="width: 120px" name="stockMinimo"
			id="stockMinimo"
			value="<c:out value="${producto.stockMinimo}" />" onkeypress="return isNumberKey(event);" /> unidades <c:if
				test="${!empty errores.campo.stockMinimo}">
				<div class="errorEntrada">${errores.campo.stockMinimo}</div>
			</c:if></td>
	</tr>
	<tr>
		<td class="labelForm">Descripción:</td>
		<td></td>
		<td><textarea rows="10" style="width: 600px; resize: none;"
				name="descripcion" id="descripcion"><c:out value="${producto.descripcion}" /></textarea>
			<c:if test="${!empty errores.campo.descripcion}">
				<div class="errorEntrada">${errores.campo.descripcion}</div>
			</c:if></td>

	</tr>
</table>