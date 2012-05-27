<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>
<jsp:useBean id="producto" class="unlp.info.ingenieriaii.modelo.Producto" scope="session"/>
<jsp:setProperty name="producto" property="*"/> 

<script type="text/javascript">
	
</script>

<table>
	<tr>
						<td class="helpText" colspan="4" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
	</tr>
	<tr>
						<td colspan="2" height="40"></td>
	</tr>
	<td>
		
		<tr>
			<td class="labelForm">Nombre:</td>
			<td colspan=3><input type="text" name="nombre" id="nombre" size="100" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/> *</td>
		</tr>
		<tr>
			<td class="labelForm">Tipo de Producto:</td>
			<td>
				<SELECT name="tipoDeProducto" size="1" onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED> </OPTION>
					<OPTION>aplisis1</OPTION>
					<OPTION>aplisis2</OPTION>
					<OPTION>aplisis3</OPTION>
					<OPTION>aplisis4</OPTION> 
				</SELECT> *
			</td>
			<td width="55%" class="labelForm" align="left">Descripcion:</td>
		</tr>
		<tr>
			<td class="labelForm">Marca:</td>
			<td>
				<SELECT name="marca" size="1" onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED> </OPTION>
					<OPTION>aplisis1</OPTION>
					<OPTION>aplisis2</OPTION>
					<OPTION>aplisis3</OPTION>
					<OPTION>aplisis4</OPTION> 
				</SELECT> *
			</td>
			<td width="55%" align="left" rowspan=5><textarea rows="9" cols="45"></textarea></td>
		</tr>
		<tr>
			<td class="labelForm">Precio:</td>
			<td width="250"><input type="text" name="precio" id="nombre" size="25" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/> *</td>
		</tr>
		<tr>
			<td class="labelForm">Garantia:</td>
			<td><input type="text" name="garantia" id="nombre" size="5" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/>meses *</td>
		</tr>
		<tr>
			<td class="labelForm">Stock:</td>
			<td><input type="text" name="stock" id="nombre" size="5" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/>unidades *</td>
		</tr>
		<tr>
			<td class="labelForm">Stock Minimo:</td>
			<td><input type="text" name="stockMinimo" id="nombre" size="5" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/>unidades</td>
		</tr>
	</td>
</table>