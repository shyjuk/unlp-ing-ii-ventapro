<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>

<script type="text/javascript">
	function deleteObject (idObject) {
		if (confirm("¿Esta seguro que desea borrarlo?")){
			document.test.id.value = idObject;
			document.test.action.value = 'borrar';
			document.test.submit();
		}
	}
	
	function editObject (idObject) {
		document.test.id.value = idObject;
		document.test.action.value = 'editar';
		document.test.submit();
	}
	
	function deleteAllSelectedObjecs () {
		document.test.action.value = 'borrarSeleccionados';
		document.test.submit();
	}
</script>

<table width="80%">
	<%
		BuscadorProducto buscador = (BuscadorProducto)request.getAttribute("buscador");
		if (buscador == null) {
			buscador = new BuscadorProducto();
		}
	%>
	<tr colspan=4>
		<td class="helpText" colspan="4" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
	</tr>
	<tr>
		<td colspan="2" height="40"></td>
	</tr>
	<td>
		<tr>
			<td size="100" class="labelForm">Nombre:</td>
			<td  align="left"><input type="text" name="nombre" id="nombre" size="25" value="<%=Utiles.getNotNullValue(buscador.getNombre())%>"/> *</td>
			<td align="left" class="labelForm" align="left">Marca:</td>
			<td>
				<SELECT name="marca" id="marca" size="1" onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED></OPTION>
					<OPTION>-------------------------------</OPTION>
					<%for (ObjetoPersistente row :SucursalUno.getSingleInstance().getMarcas()) {%>
					<OPTION><%=Utiles.getNotNullValue(((Marca)row).getNombre())%></OPTION>
					<%}%>
				</SELECT> *
			</td>
		</tr>
	</td>
	<td>
		<tr>
			<td size="100" class="labelForm">Código:</td>
			<td align="left"><input type="text" name="codigo" id="codigo" size="25" value="<%=Utiles.getNotNullValue(buscador.getCodigo())%>"/> *</td>
			<td align="left" class="labelForm" align="left">Categoria:</td>
			<td>
				<SELECT name="tipoDeProducto" width="30%" size="1"  onChange="redirect(this.options.selectedIndex)">
							<OPTION SELECTED></OPTION>
							<OPTION>-------------------------------</OPTION>
							<%for (ObjetoPersistente row : SucursalUno.getSingleInstance().getTiposDeProducto()) {%>
							<OPTION><%=Utiles.getNotNullValue(((TipoDeProducto)row).getNombre())%></OPTION>
							<%}%>
				</SELECT> *
			</td>
		</tr>
	</td>
		<td>
		<tr>
			<td>
			</td>
		</tr>
	</td>
	<td>
		<tr>
			
			<td>
				<input type="checkbox" name="enVenta">En Venta
			</td>
		</tr>
	</td>	
</table>

<table width="100%">
	<%
		java.util.HashMap<String, String> errores = buscador.getErrores();
		
		//BuscadorProducto buscadorProd = new BuscadorProducto();
		//buscadorProd.setNombre((String)request.getParameter("nombre"));
		//if (errores == null || errores.isEmpty()) {
			//buscadorProd.ejecutarBusqueda();
		//}
	%>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<% if (errores != null && errores.containsKey("nombre")){ %>
		<tr>
			<td></td>
			<td class="errorEntrada"><%=errores.get("nombre")%></td>
		</tr>
	<%}%>

	<tr>
		<td colspan="2">
			<fieldset>
				<legend>Resultado de la búsqueda</legend>
				<%
				java.util.ArrayList<ObjetoPersistente> resultado = buscador.getResultado();
				java.util.ArrayList<String> listId = new java.util.ArrayList<String>();
				for (ObjetoPersistente object : resultado) {
					listId.add(String.valueOf(object.getId()));
				}
				%>
				<table border="1" width="100%" cellpading="0" cellspacing="0">
					<tr>
						<td align="center"><input type="checkbox" name="<%="seleccionados_TODOS"%>" value="FALSE" onclick="javascript:changeAllSelection(this,<%=listId%>);"></input></td>
						<td align="center">Codigo</td>
						<td align="center">Nombre</td>
						<td align="center">Precio</td>
						<td align="center">Marca</td>
						<td align="center">Tipo de Producto</td>
						<td align="center">Garantia</td>
						<td align="center">Stock</td>
						<td align="center">Stock Minimo</td>
						<td align="center">En Venta</td>
						<td align="center">Descripcion</td>
						<td align="center">Editar</td>
						<td align="center">Borrar</td>
					</tr>
					<% for (ObjetoPersistente row : resultado) {%>
						<tr>
							<td align="center"><input type="checkbox" name="<%="seleccionados_" + row.getId()%>" id="<%="seleccionados_" + row.getId()%>" value="FALSE" onclick="javascript:changeSelection(this);"></input></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getCodigo())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getNombre())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getPrecio())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getMarca())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getTipoDeProducto())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getGarantia())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getStock())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getStockMinimo())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).isEnVenta())%></td>
							<td><%=Utiles.getNotNullValue(((Producto)row).getDescripcion())%></td>
							<td align="center"><img src="imagenes/iconos/edit.gif" onclick="javascript:editObject('<%=row.getId()%>')" alt="Editar" /></td>
							<td align="center"><img src="imagenes/iconos/button_delete.gif" onclick="javascript:deleteObject('<%=row.getId()%>');" alt="Borrar"/></td>
						</tr>
					<%}%>
				</table>
			</fieldset>
		</td>
	</tr>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<tr>
		<% if (errores != null && errores.containsKey(Validador.ERROR_GENERICO)){ %>
			<tr>
				<td colspan="2" heigth="40" class="errorEntrada" align="center"><%=errores.get(Validador.ERROR_GENERICO)%></td>
			</tr>
		<%}%>
	</tr>
</table>