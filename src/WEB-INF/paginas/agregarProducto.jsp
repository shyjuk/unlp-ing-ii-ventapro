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
	
	<script type="text/javascript">
	function cancelar () {
		if (confirm("¿Esta seguro que desea cancelar la operación?")){
			submit();
		}
	}
	function agregar () {
		
	}
	
	function isNumberKey(evt)
       {
          var charCode = (evt.which) ? evt.which : event.keyCode
          if (charCode > 31 && (charCode < 48 || charCode > 57))
             return false;

          return true;
       }
       //-->
	
</script>
	
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
						<td class="helpText" colspan="8" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
	</tr>
	<tr>
						<td colspan="2" height="40"></td>
	</tr>
	<td>
		<tr>
			<td class="labelForm">Codigo de barras:</td>
			<td colspan=5><input id="codigo" onkeypress="return isNumberKey(event) size="90" type="text" name="codigo" value="<%=Utiles.getNotNullValue(producto.getCodigo())%>"/> *</td>
			<% if (errores != null && errores.containsKey("codigo")){ %>
						<tr>
							<td></td>
							<td height=8 class="errorEntrada"><%=errores.get("codigo")%></td>
						</tr>
				
			<%}%>
		</tr>	
		<tr>
			<td class="labelForm">Nombre:</td>
			<td colspan=5><input type="text" name="nombre" id="nombre"  size="90" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/> *</td>
			<% if (errores != null && errores.containsKey("nombre")){ %>
						<tr>
							<td></td>
							<td height=8 class="errorEntrada"><%=errores.get("nombre")%></td>
						</tr>
				
			<%}%>
		</tr>
		<tr height = 8>
			<td class="labelForm">Tipo de Producto:</td>
			<td colspan=3 align=left>
				<SELECT name="tipoDeProducto" width="30%" size="1"  onChange="redirect(this.options.selectedIndex)">
							<OPTION SELECTED></OPTION>
							<OPTION>-------------------------------</OPTION>
							<%for (ObjetoPersistente row : SucursalUno.getSingleInstance().getTiposDeProducto()) {%>
							<OPTION><%=Utiles.getNotNullValue(((TipoDeProducto)row).getNombre())%></OPTION>
							<%}%>
				</SELECT> *
			</td>
			<td class="labelForm" align="left" colspan=2> Descripcion:</td>
		</tr>
		<% if (errores != null && errores.containsKey("tipoDeProducto")){ %>
						<tr>
							<td></td>
							<td colspan=4 height=8 class="errorEntrada"><%=errores.get("tipoDeProducto")%></td>
						</tr>
		<%}%>
		<tr height = 8>
			<td class="labelForm">Marca:</td>
			<td colspan=3>
				<SELECT name="marca" id="marca" size="1" onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED></OPTION>
					<OPTION>-------------------------------</OPTION>
					<%for (ObjetoPersistente row :SucursalUno.getSingleInstance().getMarcas()) {%>
					<OPTION><%=Utiles.getNotNullValue(((Marca)row).getNombre())%></OPTION>
					<%}%>
					</SELECT> *
			</td>
			<td align=left rowspan=8><textarea name="descripcion" id="descripcion" rows="9" cols="37"></textarea></td>		
			<% if (errores != null && errores.containsKey("marca")){ %>
						<tr>
							<td></td>
							<td height=8 class="errorEntrada"><%=errores.get("marca")%></td>
						</tr>
			<%}%>
		</tr>
		<tr>
			<td class="labelForm">Precio:</td>
			<td colspan=3 width="250"><input type="text" name="precio" id="precio" size="25" onkeypress="return isNumberKey(event) value="<%=Utiles.getNotNullValue(producto.getPrecio())%>"/> *</td>
		</tr>
		<% if (errores != null && errores.containsKey("precio")){ %>
					<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("precio")%></td>
					<tr>
		<%}%>
		<tr>
			<td class="labelForm">Garantia:</td>
			<td colspan=3 ><input type="text" name="garantia" id="garantia" size="5" value="<%=Utiles.getNotNullValue(producto.getGarantia())%>"/>meses *</td>
		</tr>
		<% if (errores != null && errores.containsKey("garantia")){ %>
						<tr height=5>
							<td height=5></td>
							<td height=5 class="errorEntrada"><%=errores.get("garantia")%></td>
						</tr>
		<%}%>
		<tr>
			<td class="labelForm">Stock:</td>
			<td colspan=3 ><input type="text" name="stock" id="stock" size="5" value="<%=Utiles.getNotNullValue(producto.getStock())%>"/>unidades *</td>
		</tr>
		<% if (errores != null && errores.containsKey("stock")){ %>
				<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("stock")%></td>
				</tr>
		<%}%>
		<tr>
			<td class="labelForm">Stock Minimo:</td>
			<td colspan=3><input type="text" name="stockMinimo" id="stockMinimo" size="5" value="<%=Utiles.getNotNullValue(producto.getStockMinimo())%>"/>unidades</td>
		</tr>
	</td>
	<% if (errores != null && errores.containsKey("stockMinimo")){ %>
					<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("stockMinimo")%></td>
				 	</tr>
	<%}%>
	<% if (errores != null && errores.containsKey("descripcion")){ %>
						<tr>
							<td height=8></td>
							<td height=8 class="errorEntrada"><%=errores.get("descripcion")%></td>
						</tr>
	<%}%>
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