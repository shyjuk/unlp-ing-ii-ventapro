<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Venta Pro - Agregar Producto </title>

	<link rel="stylesheet" type="text/css" href="basico.css" />
	
</head>
<body>
<script type="text/javascript">
	function cancelar () {
		if (confirm("¿Esta seguro que desea cancelar la operación?")){
			submit();
		}
	}
	function agregar () {
		
	}
	
</script>

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
			<td class="funcs funcsSecundarias">
				<a class="func funcAct" href="#">Producto</a>
				<a class="func" href="buscarMarca.jsp">Marca</a>
				<a class="func" href="buscarTipoProducto.jsp">Tipo de producto</a>
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
					<a class="subFunc" href="buscarProducto.jsp">Buscar</a>
					<a class="subFunc subFuncAct" href="#">Agregar</a>
				</div>
					<input type="hidden" name="objectName" value="unlp.info.ingenieriaii.modelo.Producto">
	<%
	Producto producto = new Producto(); 
	java.util.HashMap<String, String> errores = (java.util.HashMap<String,String>)request.getAttribute("errores");
%>

<table>
	<tr>
						<td class="helpText" colspan="4" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
	</tr>
	<tr>
						<td colspan="2" height="40"></td>
	</tr>
	<td>
		<tr>
			<td class="labelForm">Codigo:</td>
			<td colspan=3><input type="text" name="codigo" id="codigo" size="50" value="<%=Utiles.getNotNullValue(producto.getCodigo())%>"/> * (Ingreso del código de barras del Producto)</td>
		</tr>
		<% if (errores != null && errores.containsKey("codigo")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("codigo")%></td>
						</tr>
		<%}%>		
		<tr>
			<td class="labelForm">Nombre:</td>
			<td colspan=3><input type="text" name="nombre" id="nombre" size="100" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/> *</td>
		</tr>
		<% if (errores != null && errores.containsKey("nombre")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("nombre")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Tipo de Producto:</td>
			<td>
				<SELECT name="tipoDeProducto" id="tipoDeProducto"  width="30%" size="1"  onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED> </OPTION>
					<OPTION>-------------------------------</OPTION>
					<OPTION>aplisis2</OPTION>
					<OPTION>aplisis3</OPTION>
					<OPTION>aplisis4</OPTION> 
				</SELECT> *
			</td>
			<td width="55%" class="labelForm" align="left">Descripcion:</td>
		</tr>
		<% if (errores != null && errores.containsKey("tipoDeProducto")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("tipoDeProducto")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Marca:</td>
			<td>
				<SELECT name="marca" id="marca" size="1" onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED> </OPTION>
					<OPTION>-------------------------------</OPTION>
					<OPTION>aplisis2</OPTION>
					<OPTION>aplisis3</OPTION>
					<OPTION>aplisis4</OPTION> 
				</SELECT> *
			</td>
			<td width="55%" align="left" rowspan=5><textarea name="descripcion" id="descripcion" rows="9" cols="45"></textarea></td>
		</tr>
		<% if (errores != null && errores.containsKey("marca")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("marca")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Precio:</td>
			<td width="250"><input type="text" name="precio" id="precio" size="25" value="<%=Utiles.getNotNullValue(producto.getPrecio())%>"/> *</td>
		</tr>
		<% if (errores != null && errores.containsKey("precio")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("precio")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Garantia:</td>
			<td><input type="text" name="garantia" id="garantia" size="5" value="<%=Utiles.getNotNullValue(producto.getGarantia())%>"/>meses *</td>
		</tr>
		<% if (errores != null && errores.containsKey("garantia")){ %>
						<tr height=5>
							<td height=5></td>
							<td height=5 class="errorEntrada"><%=errores.get("garantia")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Stock:</td>
			<td><input type="text" name="stock" id="stock" size="5" value="<%=Utiles.getNotNullValue(producto.getStock())%>"/>unidades *</td>
		</tr>
		<% if (errores != null && errores.containsKey("stock")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("stock")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Stock Minimo:</td>
			<td><input type="text" name="stockMinimo" id="stockMinimo" size="5" value="<%=Utiles.getNotNullValue(producto.getStockMinimo())%>"/>unidades</td>
		</tr>
		<% if (errores != null && errores.containsKey("stockMinimo")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("stockMinimo")%></td>
						</tr>
		<%}%>
	</td>
	</tr>
	<% if (errores != null && errores.containsKey(Validador.ERROR_GENERICO)){ %>
			<tr>
				<td colspan="2" colspan="2" class="errorEntrada"><%=errores.get(Validador.ERROR_GENERICO)%></td>
			</tr>
	<%}%>
</table>
				
			</td>
		</tr>
		<tr>
			<td colspan="2" class="separador"></td>
		</tr>		
		<tr>
			<td></td>
			<td class="botonera">
				<input type="submit" value="Aceptar" name="btnAceptar"></input>
				<input type="submit" value="Cancelar" name="btnCancelar"></input>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>