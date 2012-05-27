<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Venta Pro - [NOMBRE DE FUNCIONALIDAD ACÁ]</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
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
				<td class="funcs funcsSecundarias"><a class="func"
					href="buscarProducto.jsp">Producto</a> <a class="func funcAct"
					href="#">Marca</a> <a class="func" href="buscarTipoProducto.jsp">Tipo
						de producto</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales"><a
					class="funcPrincipal funcPrincipalAct" href="#">Gestión de
						productos</a> <a class="funcPrincipal" href="#">Ventas</a> <a
					class="funcPrincipal" href="#">Administración de clientes</a> <a
					class="funcPrincipal" href="#">Reportes</a> <a
					class="funcPrincipal" href="#">Administración de usuarios</a></td>

				<td class="panelPrincipal">
					<div class="subFuncs">
						<a class="subFunc" href="buscarMarca.jsp">Buscar</a> <a
							class="subFunc subFuncAct" href="#">Agregar</a>
					</div>
					<div class="helpText">
						Si necesita ayuda haga <a
							href="javascript:abrirPopUp('popupAyudaGenerica.html')">click
							aquí</a>
					</div>


					<table style="color: black;">
						<tr>
							<td class="labelForm">Nombre:</td>
							<td></td>
							<td><input type="text" style="width: 200px" /> *</td>
						</tr>
						<tr>
							<td class="labelForm">Sitio web:</td>
							<td></td>
							<td><input type="text" style="width: 600px" /></td>
						</tr>
						<tr>
							<td class="labelForm">Contacto:</td>
							<td></td>
							<td><textarea rows="3" style="width: 600px; resize: none;"></textarea></td>
						</tr>
						<tr>
							<td class="labelForm">Info adicional:</td>
							<td></td>
							<td><textarea rows="6" style="width: 600px; resize: none;"></textarea></td>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera"><input type="submit" value="Aceptar"
					name="btnAceptar"></input> <input type="submit" value="Cancelar"
					name="btnCancelar"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>