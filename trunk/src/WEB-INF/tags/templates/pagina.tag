<%@ tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ attribute name="nombreFuncionalidad" required="true"%>
<%@ attribute name="funcionesSecundarias" required="true"
	fragment="true"%>
<%@ attribute name="funcPriProductosActiva" required="false"%>
<%@ attribute name="funcPriVentasActiva" required="false"%>
<%@ attribute name="funcPriClientesActiva" required="false"%>
<%@ attribute name="funcPriReportesActiva" required="false"%>
<%@ attribute name="subfunciones" required="true" fragment="true"%>
<%@ attribute name="panelPrincipal" required="true" fragment="true"%>
<%@ attribute name="botonera" required="true" fragment="true"%>
<%@ attribute name="head" required="false" fragment="true"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VentaPro - ${nombreFuncionalidad}</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
<jsp:invoke fragment="head" />
</head>
<body>

	<div class="header">
		<div class="nombreSucursal">Sucursal La Loma I</div>
		<div class="nombreUsuario">
			Rodolfo Perez <input type="submit" value="Cerrar sesión"
				name="btnCerrarSesion" onclick="return false;"></input>
		</div>
		<div class="clear"></div>
	</div>

	<form method="post" name="form">
		<table class="principal">
			<tr>
				<td></td>
				<td class="funcs funcsSecundarias"><jsp:invoke
						fragment="funcionesSecundarias" /></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales"><t:funcPrincipal
						pagina="buscarProducto.jsp" nombre="Gestión de productos"
						activa="${funcPriProductosActiva}" /> <t:funcPrincipal
						pagina="generarOrden.jsp" nombre="Ventas"
						activa="${funcPriVentasActiva}" /> <t:funcPrincipal
						pagina="buscarCliente.jsp" nombre="Administración de clientes"
						activa="${funcPriClientesActiva}" /> <t:funcPrincipal
						pagina="reporteBajoStock.jsp" nombre="Reportes"
						activa="${funcPriReportesActiva}" /> <t:funcPrincipal pagina="#"
						nombre="Administración de usuarios" /></td>
				<td class="panelPrincipal">
					<div class="subFuncs">
						<jsp:invoke fragment="subfunciones" />
					</div>
					<div class="helpText">
						Si necesita ayuda haga <a
							href="javascript:abrirPopUp('popupAyudaGenerica.html')">click
							aquí</a>
					</div> <jsp:invoke fragment="panelPrincipal" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera"><jsp:invoke fragment="botonera" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
