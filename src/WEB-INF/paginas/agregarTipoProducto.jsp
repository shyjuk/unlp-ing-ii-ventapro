<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<templates:paginaProductosTipoProducto
	nombreFuncionalidad="Agregar Tipo de Producto">

	<jsp:attribute name="panelPrincipal">
		<%@ include file="formularios/formularioDatosTipoProducto.jsp"%>
	
		<c:if test="${!empty errores.general}">
			<div class="errorEntrada" style="text-align: center; margin: 2em;">
				<c:out value="${errores.general}"></c:out>
			</div>
		</c:if>
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<input type="submit" value="Aceptar" name="btnAceptar" />
		<input type="submit" value="Cancelar" name="btnCancelar"
			onclick="return confirm('¿Esta seguro que desea cancelar la operación?')" />
	</jsp:attribute>
</templates:paginaProductosTipoProducto>