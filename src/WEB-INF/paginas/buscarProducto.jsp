<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<templates:paginaProductosProducto nombreFuncionalidad="Buscar Producto">
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
		document.form.action = "modificarProducto.jsp";
		document.form.accion.value = 'editar';
		document.form.submit();
	}
	
	function mostrarDetalles(idObject){
		document.getElementById('detalles_' + idObject).className = "";
		document.getElementById('mas_' + idObject).className = "oculto";
		document.getElementById('menos_' + idObject).className = "";
	}
	
	function ocultarDetalles(idObject){
		document.getElementById('detalles_' + idObject).className = "oculto";
		document.getElementById('mas_' + idObject).className = "";
		document.getElementById('menos_' + idObject).className = "oculto";
	}	
</script>
</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
					<table>
						<tr>
							<td colspan="5" class="separador"></td>
						</tr>
						<tr>
							<td class="labelForm">Nombre:</td>
							<td><input type="text" style="width: 300px" name="nombre"
					id="nombre" value="${buscador.nombre}" /> <c:if
						test="${!empty errores.campo.nombre}">
									<div class="errorEntrada">${errores.campo.nombre}</div>
								</c:if></td>
							<td class="labelForm"></td>
							<td class="labelForm">Marca:</td>
							<td><select style="width: 200px" name="idMarca"
					onchange="redirect(this.options.selectedIndex)">
									<option
							<c:if test="${empty buscador.idMarca}">selected="selected"</c:if>
							value=""></option>
									<c:forEach items="${marcas}" var="marca">
										<option
								<c:if test="${buscador.idMarca == marca.id}">selected="selected"</c:if>
								value="${marca.id}">${marca.nombre}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="labelForm">Código:</td>
							<td><input type="text" style="width: 100px" name="codigo"
					id="codigo" value="${buscador.codigo}" /> <c:if
						test="${!empty errores.campo.codigo}">
									<div class="errorEntrada">${errores.campo.codigo}</div>
								</c:if></td>
							<td class="labelForm"></td>
							<td class="labelForm">Tipo de producto:</td>
							<td><select style="width: 200px" name="idTipoProducto"
					onchange="redirect(this.options.selectedIndex)">
									<option
							<c:if test="${empty buscador.idTipoProducto}">selected="selected"</c:if>
							value=""></option>
									<c:forEach items="${tiposProducto}" var="tipoProducto">
										<option
								<c:if test="${buscador.idTipoProducto == tipoProducto.id}">selected="selected"</c:if>
								value="${tipoProducto.id}">${tipoProducto.nombre}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td colspan="5" class="separador"></td>
						</tr>
						<tr>
							<td colspan="4"><input name="chkIncluir" type="checkbox"
					value="true"
					<c:if
									test="${empty buscador.enVenta}">checked="checked"</c:if> />Incluir
								productos que no es encuentren a la venta.</td>
							<td align="right"><input type="submit" value="Buscar"
					name="btnAceptar" /></td>
						</tr>
						<tr>
							<td colspan="5" class="separador"></td>
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
								<td style="text-align: center; border: 1px solid #CCC">Tipo</td>
								<td style="text-align: center; border: 1px solid #CCC">Marca</td>
								<td
						style="width: 500px; text-align: center; border: 1px solid #CCC">Nombre</td>
								<td
						style="width: 100px; text-align: center; border: 1px solid #CCC">Precio</td>
								<td style="width: 100px; border: 1px solid #CCC"></td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="producto">
								<tr
						<c:if
									test="${!producto.enVenta}">style="color: #666; font-style: italic" </c:if>>
									<td style="border: 1px solid #CCC"><input type="checkbox"
							name="seleccionados_${producto.id}"
							id="seleccionados_${producto.id}" value="FALSE"
							onclick="javascript:changeSelection(this);" /></td>
									<td
							style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"><c:out
								value="${producto.tipoProducto.nombre}" /></td>
									<td
							style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"><c:out
								value="${producto.marca.nombre}" /></td>
									<td
							style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"><c:out
								value="${producto.nombre}" /></td>
									<td
							style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
							align="right"><c:out value="${producto.precio}" /></td>
									<td align="center" style="border: 1px solid #CCC"><img
							src="imagenes/iconos/lupa_mas.gif"
							onclick="javascript:mostrarDetalles('${producto.id}')"
							id="mas_${producto.id}" alt="Más información"
							style="margin-right: 10px" /> <img
							src="imagenes/iconos/lupa_menos.gif"
							onclick="javascript:ocultarDetalles('${producto.id}')"
							id="menos_${producto.id}" alt="Más información"
							style="margin-right: 10px" class="oculto" /> <img
							src="imagenes/iconos/edit.gif"
							onclick="javascript:editObject('${producto.id}')" alt="Editar"
							style="margin-right: 8px" /> <img
							src="imagenes/iconos/button_delete.gif"
							onclick="javascript:deleteObject('${producto.id}');" alt="Borrar" /></td>
								</tr>
								<tr id="detalles_${producto.id}" class="oculto">
									<td colspan="6"
							style="border: 1px solid #CCC; background-color: #699; color: White; padding: 8px; padding-left: 2em"><table>
											<c:if test="${!producto.enVenta}">
												<tr>
													<td></td>
													<td align="center"
											style="color: red; padding: 1ex; background-color: White; border: 1px solid #CCC">Este
														producto no está a la venta.</td>
												</tr>
											</c:if>
											<tr>
												<td></td>
												<td align="center">
													<table style="border-collapse: separate;">
														<tr>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center">Código</td>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center">Garantía</td>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center">Stock</td>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center">Stock Mínimo</td>
														</tr>
														<tr style="background-color: White; color: Black;">
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center">${producto.codigo}</td>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center"><c:choose>
																	<c:when test="${!empty producto.garantia}">${producto.garantia} meses</c:when>
																	<c:otherwise>N/A</c:otherwise>
																</c:choose></td>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center">${producto.stock} unidades</td>
															<td
													style="padding-left: 1em; padding-right: 1em; border: 1px solid #CCC"
													align="center"><c:choose>
																	<c:when test="${!empty producto.stockMinimo}">${producto.stockMinimo} unidades</c:when>
																	<c:otherwise>N/A</c:otherwise>
																</c:choose></td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td class="labelForm">Descripción:</td>
												<td><textarea rows="10"
											style="width: 600px; resize: none;" readonly="readonly">${producto.descripcion}</textarea></td>
											</tr>
										</table></td>
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
		<input type="submit" value="Aceptar" name="btnAceptar" /> <input
			type="submit" value="Borrar" name="btnBorrar"
			onclick="return algunoCheckeado(${listaId}) && confirm('¿Esta seguro que desea borrar los productos seleccionados?')" />
	</jsp:attribute>

</templates:paginaProductosProducto>