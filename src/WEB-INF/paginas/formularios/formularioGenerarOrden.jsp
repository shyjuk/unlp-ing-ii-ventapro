<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*"%>
<%@ page import="unlp.info.ingenieriaii.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
	<legend>Datos de la Orden</legend>
	<!--  
	<table width="100%">
		<tr>
			<td align="left" colspan=1><label>Nombre del Vendedor:</label></td>

			<td><select name="nombreV" id="idVendedor" style="width: 200px"
				onchange="redirect(this.options.selectedIndex)">
					<option
						<c:if test="${empty orden.idUsuario}">selected="selected"</c:if>
						value=""></option>
					<c:forEach items="${vendedores}" var="vendedor">
						<option
							<c:if test="${orden.idUsuario == vendedor.id}">selected="selected"</c:if>
							value="${vendedor.idUsuario}">${vendedor.nombre}</option>
					</c:forEach>
			</select> * <c:if test="${!empty errores.campo.idVendedor}">
					<div class="errorEntrada">${errores.campo.idMarca}</div>
				</c:if></td>
		</tr>
		<tr>
			<td colspan=1 width="10%" align=left>FECHA:</td>
			<td width="10%"><label id=fechaOrden>"${fechaO}"</label></td>
			<td width="10%" align=left>HORA:</td>
			<td width="10%"><label id=horaO> </label></td>
		</tr>
		<tr>
			<td colspan=12><hr></hr></td>
		</tr>
	</table>-->
	<table>
		<tr>
			<td colspan=2 width="10%" align="left">DNI Cliente:</td>
			<td width="15%" colspan=2><input type="text" name="dni" id="dni"
				size="30" value="10462783" /></td>
			<td width="20%" colspan=1 align="left">
				<!--<button
					style="width: 120px">Buscar Cliente</button> -->
			</td>
		</tr>
		<tr style="height: 10px"></tr>
		<tr>
			<td colspan=2 width="10%" align="left">Nombre del Cliente:</td>
			<td colspan=3><input style="width: 350px" value="Juan Perez"></input></td>
		</tr>
	</table>
	<!-- 
	<table width=100%>
		<tr style="height: 5px">
			<td style="width: 145px" colspan=1 class="labelForm">Fecha:</td>
			<td align="left"><input align="left" type="text" name="dia"
				id="dia" size="2" value="" /> <input align="left" type="text"
				name="mes" id="mes" size="2" value="" /> <input align="left"
				type="text" name="anio" id="anio" size="4" value="" />
				<div class="errorEntrada"></div></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td class="labelForm" align="left">dd/mm/aaaa</td>
		</tr>
	</table> -->
	<table width=100%>
		<tr>
			<td colspan=2>DIRECCION</td>
		</tr>
		<tr>
			<td style="width: 175px">CALLE</td>
			<td align="left"><input style="width: 250px" value="14"></input></td>
			<td align="left">Nro.</td>
			<td><input style="width: 60px" value="4084"></input></td>
			<td>COD. POSTAL</td>
			<td align="left"><input style="width: 60px" value="1897"></input></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><input style="width: 250px"></input></td>
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
			<td colspan="5" align="right"><button style="width: 125px">Buscar</button></td>
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