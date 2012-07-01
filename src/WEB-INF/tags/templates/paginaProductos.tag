<%@ tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<%@ attribute name="nombreFuncionalidad" required="true"%>
<%@ attribute name="panelPrincipal" required="true" fragment="true"%>
<%@ attribute name="botonera" required="true" fragment="true"%>
<%@ attribute name="head" required="false" fragment="true"%>
<%@ attribute name="funcSecProductoActiva" required="false"%>
<%@ attribute name="funcSecMarcaActiva" required="false"%>
<%@ attribute name="funcSecTipoProductoActiva" required="false"%>
<%@ attribute name="paginaBuscar" required="true"%>
<%@ attribute name="paginaAgregar" required="true"%>
<%@ attribute name="paginaModificar" required="true"%>
<templates:pagina nombreFuncionalidad="${nombreFuncionalidad}"
	funcPriProductosActiva="true">

	<jsp:attribute name="head">
		<jsp:invoke fragment="head" />
	</jsp:attribute>

	<jsp:attribute name="funcionesSecundarias">
	<t:funcSecundaria pagina="buscarProducto.jsp" nombre="Producto"
			activa="${funcSecProductoActiva}" />
	<t:funcSecundaria pagina="buscarMarca.jsp" nombre="Marca"
			activa="${funcSecMarcaActiva}" />
	<t:funcSecundaria pagina="buscarTipoProducto.jsp"
			nombre="Tipo de producto" activa="${funcSecTipoProductoActiva}" />
	</jsp:attribute>

	<jsp:attribute name="subfunciones">
		<t:subfuncion pagina="${paginaBuscar}" nombre="Buscar" />
		<t:subfuncion pagina="${paginaAgregar}" nombre="Agregar" />
		<c:if test="${f:esPaginaActual(pageContext, paginaModificar)}">
			<t:subfuncion pagina="${paginaModificar}" nombre="Modificar" />
		</c:if>
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<jsp:invoke fragment="panelPrincipal" />
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<jsp:invoke fragment="botonera" />
	</jsp:attribute>
</templates:pagina>