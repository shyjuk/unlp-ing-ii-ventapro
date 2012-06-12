<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
	<table width=100%>
		<legend>Datos de la Orden</legend>
			<tr>
				<td align="left" colspan=1><label>Nombre del Vendedor:</label></td>
				
				<td>
				  <select name="nombreV" id="idVendedor"  style="width: 200px"
				   onchange="redirect(this.options.selectedIndex)">
						<option 
					  	<c:if test="${empty orden.idUsuario}">selected="selected"</c:if>value="">
						</option>
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
			<tr><td colspan=12><hr></hr></td></tr>
		</table>	
		<table>
			<tr>
				<td colspan=2 width="10%" align="left">DNI Cliente:</td>
				<td width="15%" colspan=2><input align=left type="text" name="dni" id="dni" size="30" value=""> </input></td>
				<td width="20%" colspan=1 align="left"><button style="width: 120px">Buscar Cliente</button></td>
			</tr>
			<tr style="height: 10px"></tr>
			<tr>
				<td colspan=2 width="10%" align="left">Nombre del Cliente:</td>
				<td colspan=3><input style="width: 350px"></input></td>
			</tr>
	</table>
	<table width=100%>
		<tr style="height: 5px"><tr>
		<tr>
			<td  style="width:145px" colspan=1 class="labelForm">Fecha:</td>
			<td align="left">
					<input align="left" type="text" name="dia" id="dia" size="2" value="" />
					<input align="left" type="text" name="mes" id="mes" size="2" value="" />
					<input align="left" type="text" name="anio" id="anio" size="4" value="" />
					<div class="errorEntrada"></div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td class="labelForm"  align="left"> dd/mm/aaaa</td>
		</tr>
	</table>
	<table width=100%>
		<tr>
			<td colspan=2>DIRECCION</td>
		</tr>
		<tr>
			<td style="width: 175px">CALLE</td>
			<td align="left"><input style="width: 250px"></input></td>
			<td align="left">Nro.</td>
			<td><input style="width:60px"></input></td>
			<td>COD. POSTAL</td>
			<td align="left"><input style="width:60px"></input></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><input style="width: 250px"></input></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<table width=100%>
		<legend>Productos</legend>
			<tr>
				<td colspan=3 align="left"><font size=1>Ingrese un criterio de búsqueda, luego haga clic en "Buscar":</font></td>
			</tr>
			<tr>
				<td align="right">TIPO:</td>
				<td align="left"><input  style="width: 200px"></input></td>
				<td align="right">MARCA:</td>
				<td align="left"><input align="left" style="width: 200px"></input></td>
				<td align="right" colspan=3 >OTROS:</td>
				<td colspan=6 align="right"><input align="left" style="width: 300px"></input></td>
			</tr>
			<tr>
				<td colspan=12 align="left"><font size=1>Seleccione un item, la cantidad y luego haga clic en "Agregar a la Orden", para que sea incluido en la misma":</font></td>
				<td align="right"><button style="width: 125px">BUSCAR</button></td>
			</tr>
	</table>
	<table border="1" width=100% cellpading="0" cellspacing="0">
		<tr>
			<td><input type="checkbox" name="seleccionados_TODOS" value="FALSE"
				onclick="javascript:changeAllSelection(this,${listaId});" /></td>
								<td>Código</td>
								<td>Nombre</td>
								<td>Precio</td>
								<td>Marca</td>
								<td>Tipo de Producto</td>
								<td>Garantía</td>
								<td>Stock</td>
								<td>En Venta</td>
								<td>Descripción</td>
		</tr>
		<c:forEach items="${buscador.resultado}" var="producto">
		<tr>
									<td><input type="checkbox"
										name="seleccionados_${producto.id}"
										id="seleccionados_${producto.id}" value="FALSE"
										onclick="javascript:changeSelection(this);" /></td>
									<td><c:out value="${producto.codigo}" /></td>
									<td><c:out value="${producto.nombre}" /></td>
									<td>$<c:out value="${producto.precio}" /></td>
									<td><c:out value="${producto.marca.nombre}" /></td>
									<td><c:out value="${producto.tipoProducto.nombre}" /></td>
									<td><c:out value="${producto.garantia}" /></td>
									<td><c:out value="${producto.stock}" /></td>
									<td><c:out value="${producto.descripcion}" /></td>
		</tr>
		</c:forEach>
	</table>
	<table width=100%>
		<tr>
			<td style="width: 100px" align="left">CANTIDAD:</td>
			<td align="left" width=90%><input></input></td>
			<td align="center"><button align="right" style="width: 200px">Agregar Item a la Orden</button></td>
		</tr>
	</table>
	<table border="1" width=100% cellpading="0" cellspacing="0">
					<tr>
						<td align="center"><input type="checkbox" name="" value="FALSE" onclick=""></input></td>
						<td align="center">Codigo Producto</td>
						<td align="center">Nombre</td>
						<td align="center">Precio</td>
						<td align="center">Marca</td>
						<td align="center">Tipo Producto</td>
					</tr>
					<c:forEach items="${buscador.resultado}" var="producto">
					<tr>
									<td><input type="checkbox"
										name="seleccionados_${producto.id}"
										id="seleccionados_${producto.id}" value="FALSE"
										onclick="javascript:changeSelection(this);" /></td>
									<td><c:out value="${producto.codigo}" /></td>
									<td><c:out value="${producto.nombre}" /></td>
									<td>$<c:out value="${producto.precio}" /></td>
									<td><c:out value="${producto.marca.nombre}" /></td>
									<td><c:out value="${producto.tipoProducto.nombre}" /></td>
									<td><c:out value="${producto.garantia}" /></td>
									<td><c:out value="${producto.stock}" /></td>
									<td><c:out value="${producto.descripcion}" /></td>
					</tr>
					</c:forEach>
	</table>
	<table width=100%>
		<tr>
			<td style="width: 85px" align="right">TOTAL:</td>
			<td align="left"><input align="left"></input></td>
		</tr>
	</table>
</fieldset>