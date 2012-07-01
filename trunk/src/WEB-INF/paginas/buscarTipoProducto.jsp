<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<templates:paginaProductosTipoProducto nombreFuncionalidad="Buscar Marca">
	<jsp:attribute name="head">
<script type="text/javascript">
	function deleteObject(idObject) {
		if (confirm("¿Esta seguro que desea borrarlo?")) {
			document.form.id.value = idObject;
			document.form.accion.value = 'borrar';
			document.form.submit();
		}
	}

	function editObject(idObject) {
		document.form.id.value = idObject;
		document.form.action = "modificarTipoProducto.jsp";
		document.form.accion.value = 'editar';
		document.form.submit();
	}
	
	</script>
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
					<table>
						<tr>
							<td class="labelForm">Nombre:</td>
							<td><input type="text" name="nombre" id="nombre" size="50"
					value="${buscador.nombre}" /> * <input type="submit"
					value="Buscar" name="btnAceptar" />
							<c:if test="${!empty errores.campo.nombre}">
									<div class="errorEntrada">${errores.campo.nombre}</div>
								</c:if></td>
						</tr>
						<tr>
							<td colspan="2" class="separador"></td>
						</tr>
					</table>

					<fieldset>
						<legend>Resultado de la búsqueda</legend>
						<table width="100%" style="border-collapse: collapse;">
							<tr style="background-color: #4AA; color: White;">
								<td
						style="width: 15px; text-align: center; border: 1px solid #CCC"><input
						type="checkbox" name="seleccionados_TODOS" value="FALSE"
						onclick="javascript:changeAllSelection(this,${listaId});" /></td>
								<td
						style="width: 250px; text-align: center; border: 1px solid #CCC">Nombre</td>
								<td style="text-align: center; border: 1px solid #CCC">Descripción</td>
								<td style="width: 100px; border: 1px solid #CCC"></td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="tipoProducto">
								<tr>
									<td style="border: 1px solid #CCC"><input type="checkbox"
							name="seleccionados_${tipoProducto.id}"
							id="seleccionados_${tipoProducto.id}" value="FALSE"
							onclick="javascript:changeSelection(this);" /></td>
									<td style="padding-left: 1em; border: 1px solid #CCC"><c:out
								value="${tipoProducto.nombre}" /></td>
									<td style="padding-left: 1em; border: 1px solid #CCC"><c:out
								value="${tipoProducto.descripcion}" /></td>
									<td align="center" style="border: 1px solid #CCC"><img
							src="imagenes/iconos/edit.gif"
							onclick="javascript:editObject('${tipoProducto.id}')"
							alt="Editar" style="margin-right: 8px" /> <img
							src="imagenes/iconos/button_delete.gif"
							onclick="javascript:deleteObject('${tipoProducto.id}');"
							alt="Borrar" /></td>
								</tr>
							</c:forEach>
						</table>
					</fieldset> <c:if test="${!empty errores.general}">
						<div class="errorEntrada" style="text-align: center; margin: 2em;">
							<c:out value="${errores.general}"></c:out>
						</div>
					</c:if> <c:if test="${!empty erroresEliminar.general}">
						<div class="errorEntrada" style="text-align: center; margin: 2em;">
							<c:out value="${erroresEliminar.general}"></c:out>
						</div>
					</c:if>
					<input type="hidden" name="id" value="" />
					<input type="hidden" name="accion" value="" />					
</jsp:attribute>
	<jsp:attribute name="botonera">
		<input type="submit" value="Aceptar" name="btnAceptar" /> 
		<input type="submit" value="Borrar" name="btnBorrar"
			onclick="return algunoCheckeado(${listaId}) && confirm('¿Esta seguro que desea borrar los tipos de producto seleccionados?')" />
	</jsp:attribute>
</templates:paginaProductosTipoProducto>