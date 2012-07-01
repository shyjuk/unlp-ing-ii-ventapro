<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/templates" prefix="t" %>
<%@ attribute name="nombreFuncionalidad" required="true"%>
<%@ attribute name="panelPrincipal" required="true" fragment="true" %>
<%@ attribute name="botonera" required="true" fragment="true" %>
<%@ attribute name="head" required="false" fragment="true" %>
<%@ attribute name="funcSecundaria" required="true" %>
<%@ attribute name="jspBuscar" required="true"%>
<%@ attribute name="jspAgregar" required="true"%>
<%@ attribute name="jspModificar" required="true"%>
<t:pagina funcPrincipal="productos">
	
	<jsp:attribute name="nombreFuncionalidad" trim="true">${nombreFuncionalidad}</jsp:attribute>
	<jsp:attribute name="head">
		<jsp:invoke fragment="head" />
	</jsp:attribute>
	
	<jsp:attribute name="funcionesSecundarias">
		<a class="func ${fn:toLowerCase(funcSecundaria) == 'producto' ? 'funcAct' : ''}"
			href="${fn:toLowerCase(funcSecundaria) == 'producto' ? '#' : 'buscarProducto.jsp'}">Producto</a>
			
		<a class="func ${fn:toLowerCase(funcSecundaria) == 'marca' ? 'funcAct' : ''}"
			href="${fn:toLowerCase(funcSecundaria) == 'marca' ? '#' : 'buscarMarca.jsp'}">Marca</a>
			
		<a class="func ${fn:toLowerCase(funcSecundaria) == 'tipoproducto' ? 'funcAct' : ''}"
			href="${fn:toLowerCase(funcSecundaria) == 'tipoproducto' ? '#' : 'buscarTipoProducto.jsp'}">Tipo de producto</a>
	</jsp:attribute>

	<jsp:attribute name="subfunciones">
		<div class="subFuncs">
			<a class="subFunc ${fn:endsWith(pageContext.request.requestURI, f:concat('/', jspBuscar)) ? 'subFuncAct' : ''}" 
				href="${fn:endsWith(pageContext.request.requestURI, f:concat('/', jspBuscar))  ? '#' : jspBuscar}">Buscar</a>
			
			<a class="subFunc ${fn:endsWith(pageContext.request.requestURI, f:concat('/', jspAgregar))  ? 'subFuncAct' : ''}" 
				href="${fn:endsWith(pageContext.request.requestURI, f:concat('/', jspAgregar))  ? '#' : jspAgregar}">Agregar</a>
		
			<c:if test="${fn:endsWith(pageContext.request.requestURI, f:concat('/', jspModificar))}">
				<a class="subFunc subFuncAct" href="#">Modificar</a>
			</c:if>
		</div>
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<jsp:invoke fragment="panelPrincipal" />
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<jsp:invoke fragment="botonera" />
	</jsp:attribute>
</t:pagina>