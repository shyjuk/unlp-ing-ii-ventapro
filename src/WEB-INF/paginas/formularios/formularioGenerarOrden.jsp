<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*"%>
<%@ page import="unlp.info.ingenieriaii.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
	<legend>Datos de la Orden</legend>
	
	<table width="100%">
		<tr>
			<td width="25%" class="labelForm">Vendedor:</td>
			<td width="75%"><b>${vendedor.nombre}</b></td>
		</tr>
		<tr>
			<td class="labelForm">Fecha:</td>
			<td>${fechaO}</td>
		</tr>
		<tr>
			<td class="labelForm">Medio de pago:</td>
			<td><select name="medioPago" style="width: 30ex" onchange="redirect(this.options.selectedIndex)">
					<option
						<c:if test="${empty medioPago}">selected="selected"</c:if> value=""></option>
						<c:forEach items="${listaMedioPago}" var="mprow">
						<option <c:if test="${medioPago == mprow.id}">selected="selected"</c:if> value="${mprow.id}">${mprow.descripcion}
						</option>
					</c:forEach>
				</select> </td>
		</tr>
		<tr>
			<td class="labelForm">Cant. cuotas:</td>
			<td><select name="cuotas" style="width: 30ex" onchange="redirect(this.options.selectedIndex)">
				<option  value=""></option>
				</select></td>
		</tr>
		<tr>
			<td colspan=2><hr></hr></td>
		</tr>
	</table>
	<table border="0">
		<tr>
			<td class="labelForm">DNI Cliente:</td>
			<td><input type="text" name="dni" id="dni" size="30" value="${dni}" />*</td>
			<td colspan="2"><input type="submit" value="Buscar" name="btnBuscarCliente"></input></td>
		</tr>
		<tr style="height: 10px"></tr>
		<tr>
			<td class="labelForm">Nombre y Apellido:</td>
			<td colspan=3><input type="text" style="width: 350px" name="nombreCliente" value="${nombreCliente}"></input>*</td>
		</tr>
		<tr>
			<td class="labelForm">Fecha nacimiento:</td>
			<td colspan="3"><input type="text" name="dia" id="dia" size="2" value="${fechaNacimientoDia}"/>
				<input type="text" name="mes" id="mes" size="2" value="${fechaNacimientoMes}"/>
				<input type="text" name="anio" id="anio" size="4" value="${fechaNacimientoAnio}"/>*
				<c:if test="${!empty errores.campo.fechaNacimiento}">
					<div class="errorEntrada">${errores.campo.fechaNacimiento}</div>
				</c:if></td>
		</tr>
		<tr>
			<td class="labelForm">Teléfono:</td>
			<td colspan=3><input type="text" style="width: 350px" name="telefono" value="${telefono}"></input></td>
		</tr>
		<tr>
			<td class="labelForm">Celular:</td>
			<td colspan=3><input type="text" style="width: 350px" name="celular" value="${celular}"></input></td>
		</tr>
		<tr>
			<td class="labelForm">E-mail:</td>
			<td colspan=3><input type="text" style="width: 350px" name="email" value="${email}"></input></td>
		</tr>
		
	</table>
	<table width=100%>
		<tr>
			<td colspan=6 height="30">Dirección:</td>
		</tr>
		<tr>
			<td class="labelForm">Provincia:</td>
			<td><select name="provincia" style="width: 30ex" onchange="redirect(this.options.selectedIndex)">
					<option
						<c:if test="${empty provincia}">selected="selected"</c:if> value=""></option>
						<c:forEach items="${listaProvincias}" var="rowProvincia">
						<option <c:if test="${provincia == rowProvincia}">selected="selected"</c:if> value="${rowProvincia}">${rowProvincia}
						</option>
					</c:forEach>
				</select>
			</td>
			<td class="labelForm">Localidad:</td>
			<td colspan="3"><select name="localidad" style="width: 30ex" onchange="redirect(this.options.selectedIndex)">
					<option
						<c:if test="${empty localidad}">selected="selected"</c:if> value=""></option>
						<c:forEach items="${listaLocalidades}" var="rowLocalidad">
						<option <c:if test="${localidad == rowLocalidad}">selected="selected"</c:if> value="${rowLocalidad}">${rowLocalidad}
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="labelForm">Calle:</td>
			<td><input type="text" style="width: 200px" name="calle" value="${calle}"></input></td>
			<td class="labelForm">Nro:</td>
			<td><input type="text" size="10" name="numero" value="${numero}"></input></td>
			<td class="labelForm">Codigo Postal:</td>
			<td><input type="text" size="10" name="codPostal" value="${codPostal}"></input></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>Productos</legend>
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
			<td colspan="5" align="right"><input type="submit" value="Buscar" name="btnBuscar"></input></td>
		</tr>
	</table>
	<table width="100%" style="border-collapse: collapse;">
		<tr style="background-color: #4AA; color: White;">
			<td style="text-align: center; border: 1px solid #CCC">Tipo</td>
			<td style="text-align: center; border: 1px solid #CCC">Marca</td>
			<td style="text-align: center; border: 1px solid #CCC">Nombre</td>
			<td style="text-align: center; border: 1px solid #CCC">Precio</td>
			<td style="text-align: center; border: 1px solid #CCC">Stock</td>
			<td style="text-align: center; border: 1px solid #CCC">Cantidad</td>
			<td style="border: 1px solid #CCC"></td>
		</tr>
		<c:forEach items="${buscador.resultado}" var="producto">
			<tr>
				<td><c:out value="${producto.tipoProducto.nombre}" /></td>
				<td><c:out value="${producto.marca.nombre}" /></td>
				<td><c:out value="${producto.nombre}" /></td>
				<td>$<c:out value="${producto.precio}" /></td>
				<td><c:out value="${producto.stock}" /></td>
				<td><input type="text" name="${producto.id}_cantidad"
					id="${producto.id}_cantidad" size="10" value="<c:out value="1" />" /></td>
				<td><input type="button" value="Agregar"
					name="btnAgregar"></input></td>
			</tr>
		</c:forEach>
	</table>
	<table width="100%">
		<tr>
			<td style="width: 85px" align="right">TOTAL:</td>
			<td align="left"><input align="left"></input></td>
		</tr>
	</table>
</fieldset>