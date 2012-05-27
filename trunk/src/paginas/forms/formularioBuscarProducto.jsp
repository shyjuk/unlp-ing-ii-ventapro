<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>
<jsp:useBean id="producto" class="unlp.info.ingenieriaii.modelo.Producto" scope="session"/>
<jsp:setProperty name="producto" property="*"/> 

<script type="text/javascript">
	
</script>

<table width="80%">
	<tr colspan=4>
						<td class="helpText" colspan="4" align="right">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a></td>
	</tr>
	<tr>
						<td colspan="2" height="40"></td>
	</tr>
	<td>
		<tr>
			<td class="labelForm">Nombre:</td>
			<td size="35%" align="right"><input type="text" name="nombre" id="nombre" size="25" value="<%=Utiles.getNotNullValue(producto.getNombre())%>"/> *</td>
			<td size="40%" class="labelForm" align="left">Marca:</td>
			<td>
				<SELECT name="marca" size="1" onChange="redirect(this.options.selectedIndex)">
					<OPTION SELECTED> </OPTION>
					<OPTION>aplisis1</OPTION>
					<OPTION>aplisis2</OPTION>
					<OPTION>aplisis3</OPTION>
					<OPTION>aplisis4</OPTION> 
				</SELECT> *
			</td>
		</tr>
</table>