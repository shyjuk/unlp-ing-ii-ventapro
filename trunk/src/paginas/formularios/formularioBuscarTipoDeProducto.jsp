<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>
<jsp:useBean id="buscadorTipoProd" class="unlp.info.ingenieriaii.web.BuscadorTipoDeProducto" scope="session"/>
<jsp:setProperty name="buscadorTipoProd" property="*"/> 

<script type="text/javascript">
	function delete (className, idObject) {
		alert('por q no anda?!!!!!!!!');
		if (confirm("¿Esta seguro que desea borrarlo?")){
			submit();
		}
	}
</script>
	
<table width="100%">
	<tr>
		<td class="labelForm">Nombre:</td>
		<td><input type="text" name="nombre" id="nombre" size="50" value="<%=Utiles.getNotNullValue(buscadorTipoProd.getNombre())%>"/>&nbsp*</td>
	</tr>
	<tr>
		<td colspan="2" heigth="40">&nbsp</td>
	</tr>
	<%
	//buscadorTipoProd.setNombre("a");
	// NECESITO EL SERVELT PARA HACER ESOT!!!
	if (buscadorTipoProd.getErrores().isEmpty() && buscadorTipoProd.esValidoParaBuscar()) {
		buscadorTipoProd.ejecutarBusqueda();
	}
	
	%>
	<tr>
		<td colspan="2">
			<fieldset>
				<legend>Resultado de la búsqueda</legend>
				<table border="1" width="100%" cellpading="0" cellspacing="0">
					<tr>
						<td align="center">Nombre</td>
						<td align="center">Descripcion</td>
						<td align="center">Editar</td>
						<td align="center">Borrar</td>
					</tr>
					<% for (ObjetoPersistente row : buscadorTipoProd.getResultado()) {%>
						<tr>
							<td><%=Utiles.getNotNullValue(((TipoDeProducto)row).getNombre())%></td>
							<td><%=Utiles.getNotNullValue(((TipoDeProducto)row).getDescripcion())%></td>
							<td align="center"><a href="editarTipoProducto.jsp"><img src="imagenes/iconos/edit.gif" alt="Editar"/></a></td>
							<td align="center"><img src="imagenes/iconos/button_delete.gif" onclick="javascript:delete('<%="TipoDeProducto"%>','<%=row.getId()%>');" alt="Borrar"/></td>
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
		<% if (!buscadorTipoProd.getErrores().isEmpty()) { %>
			<td colspan="2" heigth="40" align="center" class="errorEntrada"><%=buscadorTipoProd.getErrores().get(Validador.ERROR_GENERICO)%></td>
		<%}%>	
	</tr>
</table>