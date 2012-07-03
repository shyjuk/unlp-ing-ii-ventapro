<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<templates:pagina nombreFuncionalidad="${nombreFuncionalidad}">

	<jsp:attribute name="head">
		<style type="text/css">
			.mensajePrincipal {
				margin: 5em;
				font-weight: bold;
				font-size: 24px;
			}
		</style>
	</jsp:attribute>

	<jsp:attribute name="funcionesSecundarias">
		<div style="visibility: hidden;">
			<t:funcSecundaria pagina="index.jsp" nombre="Página principal"
				activa="true" />
		</div>
	</jsp:attribute>

	<jsp:attribute name="subfunciones">
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<div class="mensajePrincipal">
			Haga click en la opción deseada para comenzar.
		</div>
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<input type="button" value="H" style="visibility: hidden"/>
	</jsp:attribute>
</templates:pagina>