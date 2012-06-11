<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Venta Pro - Editar Tipo de producto</title>
	<script src="funciones.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="basico.css" />
</head>
<body>
<script type="text/javascript">
	function cancelar () {
		if (confirm("¿Esta seguro que desea cancelar la operación?")){
			submit();
		}
	}
	
</script>
	<%
		TipoProducto tipoDeProducto = SucursalUno.getSingleInstance().getTipoDeProductoCon((String)request.getParameter("id"));
		java.util.HashMap<String, String> errores = (java.util.HashMap<String,String>)request.getAttribute("errores");
	%>
	<form method="post" name="editarTipoDeProducto">
	<input type="hidden" name="id" value="<%=tipoDeProducto.getId()%>">
	<input type="hidden" name="action" value="guardarEdicion">
	
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
				<a class="funcPrincipal" href="generarOrden.jsp">Ventas</a>
				<a class="funcPrincipal" href="#">Administración de clientes</a>
				<a class="funcPrincipal" href="#">Reportes</a>
				<a class="funcPrincipal" href="#">Administración de usuarios</a>
			</td>
			
			<td class="panelPrincipal">
				<div class="subFuncs">
					<a class="subFunc" href="buscarTipoProducto.jsp">Buscar</a>
					<a class="subFunc" href="agregarTipoProducto.jsp">Agregar</a>
					<a class="subFunc subFuncAct" href="#">Editar</a>
				</div>
				
				<table width="80%">
					<tr>
						<td class="helpText" colspan="2" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
					</tr>
					<tr>
						<td colspan="2" height="40"></td>
					</tr>
					<tr>
						<td class="labelForm">Nombre:</td>
						<td><input type="text" name="nombre" id="nombre" size="50" value="<%=Utiles.getNotNullValue(tipoDeProducto.getNombre())%>"/> *</td>
					</tr>
					<% if (errores != null && errores.containsKey("nombre")){ %>
						<tr>
							<td></td>
							<td class="errorEntrada"><%=errores.get("nombre")%></td>
						</tr>
					<%}%>
					<tr>
						<td class="labelForm">Descripción:</td>
						<td><input type="text" name="descripcion" id="descripcion" size="50" value="<%=Utiles.getNotNullValue(tipoDeProducto.getDescripcion())%>"/></td>
					</tr>
					<% if (errores != null && errores.containsKey("descripcion")){ %>
						<tr>
							<td></td>
							<td class="errorEntrada"><%=errores.get("descripcion")%></td>
						</tr>
					<%}%>
				</table>
			</td>
		</tr>
		<% if (errores != null && errores.containsKey(Validador.ERROR_GENERICO)){ %>
			<tr>
				<td colspan="2" colspan="2" class="errorEntrada"><%=errores.get(Validador.ERROR_GENERICO)%></td>
			</tr>
		<%}%>
		<tr>
			<td colspan="2" class="separador"></td>
		</tr>		
		<tr>
			<td></td>
			<td class="botonera">
				<input type="submit" value="Aceptar" name="btnAceptar" onclick="document.editarTipoDeProducto.submit();"></input>
				<input type="submit" value="Cancelar" name="btnCancelar" onclick="cancelar();"></input>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>