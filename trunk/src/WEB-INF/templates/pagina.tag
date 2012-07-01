<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/templates" prefix="t" %>
<%@ attribute name="nombreFuncionalidad" required="true"%>
<%@ attribute name="funcPrincipal" required="true" %>
<%@ attribute name="funcionesSecundarias" required="true" fragment="true" %>
<%@ attribute name="subfunciones" required="true" fragment="true" %>
<%@ attribute name="panelPrincipal" required="true" fragment="true" %>
<%@ attribute name="botonera" required="true" fragment="true" %>
<%@ attribute name="head" required="false" fragment="true" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VentaPro - ${nombreFuncionalidad}</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
<jsp:invoke fragment="head"/>
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
		<input type="hidden" name="id" value="" /> 
		<input type="hidden" name="accion" value="" />
		<table class="principal">
			<tr>
				<td></td>
				<td class="funcs funcsSecundarias"><jsp:invoke fragment="funcionesSecundarias"/></td>
			</tr>
			<tr> 
				<td class="funcs funcsPrincipales">
					<a class="funcPrincipal ${fn:toLowerCase(funcPrincipal) == 'productos' ? 'funcPrincipalAct' : ''}"
						href="${fn:toLowerCase(funcPrincipal) == 'productos' ? '#' : 'buscarProducto.jsp'}">Gestión de productos</a>
					<a class="funcPrincipal ${fn:toLowerCase(funcPrincipal) == 'ventas' ? 'funcPrincipalAct' : ''}" 
						href="${fn:toLowerCase(funcPrincipal) == 'ventas' ? '#' : 'generarOrden.jsp'}">Ventas</a>
					<a class="funcPrincipal ${fn:toLowerCase(funcPrincipal) == 'clientes' ? 'funcPrincipalAct' : ''}" 
						href="${fn:toLowerCase(funcPrincipal) == 'clientes' ? '#' : 'buscarCliente.jsp'}">Administración de clientes</a> 
					<a class="funcPrincipal ${fn:toLowerCase(funcPrincipal) == 'reportes' ? 'funcPrincipalAct' : ''}" 
						href="${fn:toLowerCase(funcPrincipal) == 'reportes' ? '#' : 'reporteProducto.jsp'}">Reportes</a>
					<a class="funcPrincipal"
						href="#">Administración de usuarios</a>
				</td>

				<td class="panelPrincipal">
					<jsp:invoke fragment="subfunciones"/>
					<div class="helpText">
						Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click	aquí</a>
					</div>
					<jsp:invoke fragment="panelPrincipal"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera"><jsp:invoke fragment="botonera"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
