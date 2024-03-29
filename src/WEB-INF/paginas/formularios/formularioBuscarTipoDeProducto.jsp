<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
<table width="100%">
	<%
		java.util.HashMap<String, String> errores = (java.util.HashMap<String,String>)request.getAttribute("errores");
			
			BuscadorTipoProducto buscadorTipoProd = (BuscadorTipoProducto)request.getAttribute("buscador");
			
		//			buscadorTipoProd.setNombre((String)request.getParameter("nombre"));
			//if (errores == null || errores.isEmpty()) {
		//		buscadorTipoProd.ejecutarBusqueda();
			//}
	%>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<tr>
		<td class="helpText" colspan="2" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
	</tr>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" name="nombre" id="nombre" size="50" value="<%=Utiles.getNotNullValue(buscadorTipoProd.getNombre())%>"/>&nbsp</td>
	</tr>
	<% if (errores != null && errores.containsKey("nombre")){ %>
		<tr>
			<td></td>
			<td class="errorEntrada"><%=errores.get("nombre")%></td>
		</tr>
	<%}%>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<fieldset>
				<legend>Resultado de la búsqueda</legend>
				<%
				java.util.ArrayList<TipoProducto> resultado = buscadorTipoProd.getResultado();
				java.util.ArrayList<String> listId = new java.util.ArrayList<String>();
				for (TipoProducto object : resultado) {
					listId.add(String.valueOf(object.getId()));
				}
				%>
				<table border="1" width="100%" cellpading="0" cellspacing="0">
					<tr>
						<td align="center"><input type="checkbox" name="<%="seleccionados_TODOS"%>" value="FALSE" onclick="javascript:changeAllSelection(this,<%=listId%>);"></input></td>
						<td align="center">Nombre</td>
						<td align="center">Descripcion</td>
						<td align="center">Editar</td>
						<td align="center">Borrar</td>
					</tr>
					<% for (TipoProducto row : resultado) {%>
						<tr>
							<td align="center"><input type="checkbox" name="<%="seleccionados_" + row.getId()%>" id="<%="seleccionados_" + row.getId()%>" value="FALSE" onclick="javascript:changeSelection(this);"></input></td>
							<td><%=Utiles.getNotNullValue(((TipoProducto)row).getNombre())%></td>
							<td><%=Utiles.getNotNullValue(((TipoProducto)row).getDescripcion())%></td>
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