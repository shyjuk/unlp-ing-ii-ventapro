<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/templates" prefix="t"%>
<%@ attribute name="nombreFuncionalidad" required="true"%>
<%@ attribute name="panelPrincipal" required="true" fragment="true"%>
<%@ attribute name="botonera" required="true" fragment="true"%>
<%@ attribute name="head" required="false" fragment="true"%>

<t:paginaProductos 
	nombreFuncionalidad="${nombreFuncionalidad}"
	funcSecundaria="producto"
	jspBuscar="buscarProducto.jsp"
	jspAgregar="agregarProducto.jsp"
	jspModificar="modificarProducto.jsp">

	<jsp:attribute name="head">
		<jsp:invoke fragment="head" />
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<jsp:invoke fragment="panelPrincipal" />
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<jsp:invoke fragment="botonera" />
	</jsp:attribute>
</t:paginaProductos>