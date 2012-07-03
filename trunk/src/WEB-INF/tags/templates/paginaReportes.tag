<%@ tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<%@ attribute name="nombreFuncionalidad" required="true"%>
<%@ attribute name="panelPrincipal" required="true" fragment="true"%>
<%@ attribute name="head" required="false" fragment="true"%>
<templates:pagina nombreFuncionalidad="${nombreFuncionalidad}"
	funcPriReportesActiva="true">

	<jsp:attribute name="head">
		<jsp:invoke fragment="head" />
	</jsp:attribute>

	<jsp:attribute name="funcionesSecundarias">
	<t:funcSecundaria pagina="reporteBajoStock.jsp" nombre="Productos"
			activa="true" />
	</jsp:attribute>

	<jsp:attribute name="subfunciones">
		<t:subfuncion pagina="reporteBajoStock.jsp" nombre="Bajo el Stock Mínimo" />
		<t:subfuncion pagina="productosEnVenta.jsp" nombre="En Venta" />
		<t:subfuncion pagina="productosInactivos.jsp" nombre="Inactivos" />
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<jsp:invoke fragment="panelPrincipal" />
	</jsp:attribute>

	<jsp:attribute name="botonera">
		<input type="button" value="H" style="visibility: hidden"/>
	</jsp:attribute>
</templates:pagina>