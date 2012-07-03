<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<templates:paginaReportes
	nombreFuncionalidad="Reporte Productos en Venta">

	<jsp:attribute name="panelPrincipal">
		<div style="margin: 8px; border: 1px solid #CCC">
			<object data="productosEnVenta.jsp?pdf=1#toolbar=1" type="application/pdf"
				width="100%" height="500px">
				
				<a href="productosEnVenta.jsp?pdf=1">Descargar reporte</a>
			</object>
		</div> <c:if test="${!empty errores.general}">
			<div class="errorEntrada" style="text-align: center; margin: 2em;">
				<c:out value="${errores.general}"></c:out>
			</div>
		</c:if>
	</jsp:attribute>
</templates:paginaReportes>