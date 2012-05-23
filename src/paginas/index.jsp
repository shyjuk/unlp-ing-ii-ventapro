<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno" %>
<%
	// esto es un comentario java
	String variable = "Yo soy una variable java string";
	SucursalUno claseJava = SucursalUno.getSingleInstance();
	claseJava.setNombre("Sucursal La Loma I");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Venta Pro</title>

	<link rel="stylesheet" type="text/css" href="basico.css" />
	
	<style type="text/css">
		.mensajePrincipal {
			margin: 5em;
			font-weight: bold;
			font-size: 24px;
		}
	</style>
</head>
<body>
	<form method="post">
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
			<td class="funcs funcsSecundarias invisible">
				<a class="func funcAct" href="#">Producto</a>
				<a class="func" href="#">Marca</a>
				<a class="func" href="#">Tipo de producto</a>
			</td>
		</tr>
		<tr>
			<td class="funcs funcsPrincipales">
				<a class="funcPrincipal" href="buscarProducto.jsp">Gestión de productos</a>
				<a class="funcPrincipal" href="#">Ventas</a>
				<a class="funcPrincipal" href="#">Administración de clientes</a>
				<a class="funcPrincipal" href="#">Reportes</a>
				<a class="funcPrincipal" href="#">Administración de usuarios</a>
			</td>
			
			<td class="panelPrincipal">
				<div class="subFuncs invisible">
					<a class="subFunc" href="#">Buscar</a>
					<a class="subFunc subFuncAct" href="#">Agregar</a>
				</div>
				
				<div class="mensajePrincipal">
					Haga click en la opción deseada para comenzar.
				</div>
				
			</td>
		</tr>
		<tr>
			<td colspan="2" class="separador"></td>
		</tr>		
		<tr>
			<td></td>
			<td class="botonera invisible">
				<input type="submit" value="Aceptar" name="btnAceptar"></input>
				<input type="submit" value="Cancelar" name="btnCancelar"></input>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>