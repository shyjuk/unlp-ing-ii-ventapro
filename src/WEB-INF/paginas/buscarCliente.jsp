<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<templates:paginaClientes nombreFuncionalidad="Buscar Marca">
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
		document.form.action = "modificarCliente.jsp";
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
							<td class="labelForm">Apellido:</td>
							<td><input type="text" style="width: 300px" name="apellido"
					id="apellido" value="<c:out value="${buscador.apellido}" />" />
								<c:if test="${!empty errores.campo.apellido}">
									<div class="errorEntrada">${errores.campo.apellido}</div>
								</c:if></td>
						</tr>
						<tr>
							<td class="labelForm">Nombre:</td>
							<td><input type="text" style="width: 300px" name="nombre"
					id="nombre" value="<c:out value="${buscador.nombre}" />" /> <c:if
						test="${!empty errores.campo.nombre}">
									<div class="errorEntrada">${errores.campo.nombre}</div>
								</c:if></td>
						</tr>
						<tr>
							<td class="labelForm">DNI:</td>
							<td><input type="text" style="width: 200px"
					name="nroDocumento" id="nroDocumento"
					value="<c:out value="${buscador.nroDocumento}" />" /> <c:if
						test="${!empty errores.campo.nroDocumento}">
									<div class="errorEntrada">${errores.campo.nroDocumento}</div>
								</c:if></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><input type="submit"
					value="Buscar" name="btnAceptar" /></td>
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
						style="width: 120px; text-align: center; border: 1px solid #CCC">DNI</td>
								<td style="text-align: center; border: 1px solid #CCC">Nombre</td>
								<td style="width: 100px; border: 1px solid #CCC"></td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="cliente">
								<tr>
									<td style="border: 1px solid #CCC"><input type="checkbox"
							name="seleccionados_${cliente.id}"
							id="seleccionados_${cliente.id}" value="FALSE"
							onclick="javascript:changeSelection(this);" /></td>
									<td
							style="padding-right: 1em; border: 1px solid #CCC; text-align: right"><c:out
								value="${cliente.nroDocumento}" /></td>
									<td style="padding-left: 1em; border: 1px solid #CCC"><c:out
								value="${cliente.apellido}, ${cliente.nombre}" /></td>
									<td align="center" style="border: 1px solid #CCC"><img
							src="imagenes/iconos/lupa_mas.gif"
							onclick="javascript:mostrarDetalles('${cliente.id}')"
							id="mas_${cliente.id}" alt="Más información"
							style="margin-right: 10px" /> <img
							src="imagenes/iconos/lupa_menos.gif"
							onclick="javascript:ocultarDetalles('${cliente.id}')"
							id="menos_${cliente.id}" alt="Más información"
							style="margin-right: 10px" class="oculto" /> <img
							src="imagenes/iconos/edit.gif"
							onclick="javascript:editObject('${cliente.id}')" alt="Editar"
							style="margin-right: 8px" /> <img
							src="imagenes/iconos/button_delete.gif"
							onclick="javascript:deleteObject('${cliente.id}');" alt="Borrar" /></td>
								</tr>
								<tr id="detalles_${cliente.id}" class="oculto">

									<td colspan="4"
							style="border: 1px solid #CCC; background-color: #699; color: White; padding: 8px; padding-left: 2em"><table>
											<tr>
												<td class="labelForm">Teléfono:</td>
												<td><input type="text" style="width: 300px"
										name="telefono" id="telefono"
										value="<c:out value="${cliente.telefono}" />"
										readonly="readonly" /></td>
											</tr>
											<tr>
												<td class="labelForm">Celular:</td>
												<td><input type="text" style="width: 300px"
										name="telefono" id="telefono"
										value="<c:out value="${cliente.celular}" />"
										readonly="readonly" /></td>
											</tr>
											<tr>
												<td class="labelForm">E-mail:</td>
												<td><input type="text" style="width: 300px"
										name="email" id="email"
										value="<c:out value="${cliente.email}" />" readonly="readonly" /></td>
											</tr>
											<tr>
												<td colspan="2">
													<fieldset>
														<legend>Dirección</legend>
														<table>
															<tr>
																<td class="labelForm">Calle:</td>
																<td><input type="text" style="width: 250px"
														name="direccion" id="direccion"
														value="<c:out value="${cliente.calle}" />"
														readonly="readonly" /></td>
																<td class="labelForm"></td>
																<td class="labelForm">Altura:</td>
																<td><input type="text" style="width: 50px"
														name="altura" readonly="readonly" /></td>
																<td class="labelForm"></td>
																<td class="labelForm">Dpto:</td>
																<td><input type="text" style="width: 50px"
														name="dpto" id="dpto"
														value="<c:out value="${cliente.dpto}" />"
														readonly="readonly" /></td>
															</tr>
															<tr>
																<td class="labelForm">Localidad:</td>
																<td colspan="8"><input type="text"
														style="width: 250px" name="localidad"
														value="${cliente.localidad}" readonly="readonly" /></td>
															</tr>
														</table>
													</fieldset>
												</td>
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
	<input type="submit" value="Aceptar" name="btnAceptar" />
	<input type="submit" value="Borrar" name="btnBorrar"
			onclick="return algunoCheckeado(${listaId}) && confirm('¿Esta seguro que desea borrar los clientes seleccionados?')" />
</jsp:attribute>
</templates:paginaClientes>