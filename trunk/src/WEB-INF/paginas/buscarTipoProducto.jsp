<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Venta Pro - Buscar tipo de producto</title>
	<script src="funciones.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="basico.css" />
</head>
<body>
	<form method="post" name="test">
	<input type="hidden" name="id" value="xxxx">
	<input type="hidden" name="action" value="xxxx">
	<div class="header">
		<div class="nombreSucursal"><%=SucursalUno.getSingleInstance().getNombre()%></div>
		<div class="nombreUsuario">
			<%=("Rodolfo Perez")%>
			<input type="submit" value="Cerrar sesión" name="btnCerrarSesion"></input>
		</div>
		<div class="clear"></div>
	</div>
	
	<table class="principal">
		<tr>
			<td></td>
			<td class="funcs funcsSecundarias">
				<a class="func" href="buscarProducto.jsp">Producto</a>
				<a class="func" href="buscarMarca.jsp">Marca</a>
				<a class="func funcAct" href="#">Tipo de producto</a>
			</td>
		</tr>
		<tr>
			<td class="funcs funcsPrincipales">
				<a class="funcPrincipal funcPrincipalAct" href="#">Gestión de productos</a>
				<a class="funcPrincipal" href="#">Ventas</a>
				<a class="funcPrincipal" href="#">Administración de clientes</a>
				<a class="funcPrincipal" href="#">Reportes</a>
				<a class="funcPrincipal" href="#">Administración de usuarios</a>
			</td>
			
			<td class="panelPrincipal">
				<div class="subFuncs">
					<a class="subFunc subFuncAct" href="#">Buscar</a>
					<a class="subFunc" href="agregarTipoProducto.jsp">Agregar</a>
				</div>
				
				
				<jsp:include page="formularios/formularioBuscarTipoDeProducto.jsp" flush="true"/>
				
			</td>
		</tr>
		<tr>
			<td colspan="2" class="separador"></td>
		</tr>		
		<tr>
			<td></td>
			<td class="botonera">
				<input type="submit" value="Aceptar" name="btnAceptar"></input>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>