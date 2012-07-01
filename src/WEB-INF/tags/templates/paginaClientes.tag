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
<templates:pagina nombreFuncionalidad="${nombreFuncionalidad}"
	funcPriClientesActiva="true">

	<jsp:attribute name="head">
		<jsp:invoke fragment="head" />
	</jsp:attribute>

	<jsp:attribute name="funcionesSecundarias">
	<t:funcSecundaria pagina="buscarCliente.jsp" nombre="Cliente"
			activa="true" />
	</jsp:attribute>

	<jsp:attribute name="subfunciones">
		<t:subfuncion pagina="buscarCliente.jsp" nombre="Buscar" />
		<t:subfuncion pagina="agregarCliente.jsp" nombre="Agregar" />
		<c:if test="${f:esPaginaActual(pageContext, 'modificarCliente.jsp')}">
			<t:subfuncion pagina="modificarCliente.jsp" nombre="Modificar" />
		</c:if>
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<jsp:invoke fragment="panelPrincipal" />
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<jsp:invoke fragment="botonera" />
	</jsp:attribute>
</templates:pagina>