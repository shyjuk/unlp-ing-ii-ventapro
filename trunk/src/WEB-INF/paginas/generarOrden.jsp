<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  session="true" %>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*"%>
<%@ page import="unlp.info.ingenieriaii.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="inputVenta" scope="session" class="unlp.info.ingenieriaii.web.InputVenta" /> 
<jsp:setProperty name="inputVenta" property="*" />

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="funciones.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VentaPro - Generar Orden</title>

<link rel="stylesheet" type="text/css" href="basico.css" />



<script type="text/javascript">
	function deleteObject (idObject) {
		if (confirm("¿Esta seguro que desea borrarlo?")){
			document.test.id.value = idObject;
			document.test.action.value = 'borrar';
			document.test.submit();
		}
	}
	
	function agregarItem (idProducto, cantidad) {
		document.formVenta.codigoAgregar.value = idProducto;
		document.formVenta.cantidadAgregar.value = (document.getElementById(cantidad)).value;
		document.formVenta.action.value = 'agregarProducto';
		document.formVenta.submit();
	}
	
	function quitarItem (idProducto) {
		document.formVenta.idProductoQuitar.value = idProducto;
		document.formVenta.action.value = 'quitarProducto';
		document.formVenta.submit();
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
</head>
<body>
	<form method="post" name="formVenta">
		<input type="hidden" name="estadoVenta" value="" />
		<input type="hidden" name="action" value="" />
		<input type="hidden" name="codigoAgregarLista" value="" />
		<input type="hidden" name="cantidadAgregarLista" value="" />
		<input type="hidden" name="idProductoQuitar" value="" />
		
		<% 
			String estadoVenta = (String)request.getAttribute("estadoVenta");
			Boolean enVenta = (Utiles.esVacio(estadoVenta)? false : (GenerarOrdenServlet.EN_VENTA.equals(estadoVenta)));
			
			if (inputVenta.getOrdenDeVenta() == null) {
				// busco si hay alguna orden en estado 4
				inputVenta.actualizarConActual();
			} else if (inputVenta.getOrdenDeVenta().getEstado().equals(String.valueOf(Estados.PENDIENTE.getId()))) {
				// La venta se realizo
				inputVenta.resetearInputVenta();
			}
			if ((BuscadorProducto)request.getAttribute("buscador") != null) {
				inputVenta.setBuscador((BuscadorProducto)request.getAttribute("buscador"));
			}
			
			enVenta = (inputVenta.getOrdenDeVenta() != null);

		%>
		<div class="header">
			<div class="nombreSucursal"><%=SucursalUno.getSingleInstance().getNombre()%></div>
			<div class="nombreUsuario"><%=("Rodolfo Perez")%>
				<input type="submit" value="Cerrar sesión" name="btnCerrarSesion"></input>
			</div>
			<div class="clear"></div>
		</div>

		<table class="principal">
			<tr>
				<td></td>
				<td class="funcs funcsSecundarias"><a class="func funcAct"
					href="generarOrden.jsp">Generar Orden</a> <a class="func"
					href="buscarOrden.jsp">Buscar Orden</a> <a class="func" href="cobrarOrden.jsp">Cobrar Orden</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales">
					<a class="funcPrincipal" href="buscarProducto.jsp">Gestión de productos</a> 
					<a class="funcPrincipal funcPrincipalAct" href="#">Ventas</a> 
					<a class="funcPrincipal" href="buscarCliente.jsp">Administración de clientes</a> 
					<a class="funcPrincipal" href="reporteBajoStock.jsp">Reportes</a> 
					<a class="funcPrincipal" href="#">Administración de usuarios</a></td>

				<td class="panelPrincipal">
					<div class="helpText">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a> </div>  
					
					<input type="submit" value="Comenzar" name="btnComenzar" <%= enVenta ? "disabled" : "" %> onclick=""/>
					
					<fieldset>
						<legend>Datos de la Orden</legend>
						
						<table width="100%">
							<tr>
								<td width="25%" class="labelForm">Vendedor:</td>
								<td width="75%"><b>${inputVenta.ordenDeVenta.vendedor}</b></td>
							</tr>
							<tr>
								<td class="labelForm">Fecha:</td>
								<td>${inputVenta.ordenDeVenta.fechaString}</td>
							</tr>
							<tr>
								<td class="labelForm">Medio de pago:</td>
								<td><select name="medioPago" style="width: 30ex" onchange="redirect(this.options.selectedIndex)" <%= enVenta ? "" : "disabled" %>>
										<option
											<c:if test="${empty inputVenta.ordenDeVenta.factura.medioPago}">selected="selected"</c:if> value=""></option>
											<c:forEach items="${listaMedioPago}" var="mprow">
											<option <c:if test="${inputVenta.ordenDeVenta.factura.medioPago == mprow.id}">selected="selected"</c:if> value="${mprow.id}">${mprow.descripcion}
											</option>
										</c:forEach>
									</select>*
									<c:if test="${!empty inputVenta.ordenDeVenta.factura.errores.campo.medioPago}">
										<div class="errorEntrada">${inputVenta.ordenDeVenta.factura.errores.campo.medioPago}</div>
									</c:if> 
								</td>
							</tr>
							<tr>
								<td colspan=2><hr></hr></td>
							</tr>
						</table>
						<table border="0">
							<tr>
								<td class="labelForm">DNI Cliente:</td>
								<td><input type="text" name="dniBusqueda" id="dniBusqueda" size="30" value="${inputVenta.dni}"  <%= enVenta ? "" : "disabled" %>/>*</td>
								<td colspan="2"><input type="submit" value="Buscar" name="btnBuscarCliente" <%= enVenta ? "" : "disabled" %>></input></td>
								<c:if test="${!empty erroresInputVenta.campo.dni}">
								<div class="errorEntrada">${erroresInputVenta.campo.dni}</div>
							</c:if>
							</tr>
							<tr style="height: 10px"></tr>
							<tr>
								<td class="labelForm">Apellido:</td>
								<td colspan=3><input type="text" style="width: 350px" name="apellidoCliente" value="${inputVenta.ordenDeVenta.cliente.apellido}"  <%= false ? "" : "disabled" %>></input>*
								<c:if test="${!empty inputVenta.ordenDeVenta.erroresCliente.campo.apellido}">
									<div class="errorEntrada">${inputVenta.ordenDeVenta.erroresCliente.campo.apellido}</div>
								</c:if>
								</td>
							</tr>
							<tr>
								<td class="labelForm">Nombre:</td>
								<td colspan=3><input type="text" style="width: 350px" name="nombreCliente" value="${inputVenta.ordenDeVenta.cliente.nombre}"  <%= false ? "" : "disabled" %>></input>*
								<c:if test="${!empty inputVenta.ordenDeVenta.erroresCliente.campo.nombre}">
									<div class="errorEntrada">${inputVenta.ordenDeVenta.erroresCliente.campo.nombre}</div>
								</c:if>
								</td>
							</tr>							

							<tr>
								<td class="labelForm"><%// Fecha nacimiento: %></td>
								<td colspan="3"><%// <input type="text" name="dia" id="dia" size="2" value="${fechaNacimientoDia}"  <%= enVenta ? "" : "disabled" %><%// /> %> 
									<%//<input type="text" name="mes" id="mes" size="2" value="${fechaNacimientoMes}" <%= enVenta ? "" : "disabled" %><%// /> %>
									<%//<input type="text" name="anio" id="anio" size="4" value="${fechaNacimientoAnio}" <%= enVenta ? "" : "disabled" %><%// /> * %>
									<%/**
									<c:if test="${!empty errores.campo.fechaNacimiento}">
										<div class="errorEntrada">${errores.campo.fechaNacimiento}</div>
									</c:if> **/%></td>
							</tr>	
							<tr>
								<td class="labelForm">Teléfono:</td>
								<td colspan=3><input type="text" style="width: 350px" name="telefono" value="${inputVenta.ordenDeVenta.cliente.telefono}" <%= false ? "" : "disabled" %>></input></td>
							</tr>
							<tr>
								<td class="labelForm">Celular:</td>
								<td colspan=3><input type="text" style="width: 350px" name="celular" value="${inputVenta.ordenDeVenta.cliente.celular}" <%= false ? "" : "disabled" %>></input></td>
							</tr>
							<tr>
								<td class="labelForm">E-mail:</td>
								<td colspan=3><input type="text" style="width: 350px" name="email" value="${inputVenta.ordenDeVenta.cliente.email}" <%= false ? "" : "disabled" %>></input></td>
							</tr>
							
						</table>
						<table width=100%>
							<tr>
								<td colspan=6 height="30">Dirección:</td>
							</tr>
							<tr>
								<td class="labelForm">Localidad:</td> <!-- FALTA MODIFICAR CARGA DE COMBO  -->
								<td><select name="localidad" style="width: 30ex" onchange="redirect(this.options.selectedIndex)" <%= false ? "" : "disabled" %>>
										<option
											<c:if test="${empty inputVenta.ordenDeVenta.cliente.localidad}">selected="selected"</c:if>>${inputVenta.ordenDeVenta.cliente.localidad}</option>
											<%/**
											<c:forEach items="${listaLocalidades}" var="rowLocalidad">
											<option <c:if test="${inputVenta.ordenDeVenta.cliente.localidad.id == rowLocalidad.id}">selected="selected"</c:if> value="${rowLocalidad.id}">${rowLocalidad.nombre}
											</option>
										</c:forEach> **/%>
									</select>
								</td>
								<td class="labelForm"><% //Codigo Postal:  %></td>
								<td><% //<input type="text" size="10" name="codPostal" value="${inputVenta.ordenDeVenta.cliente.codPostal}" <%= enVenta ? "" : "disabled"></input>%></td>
							</tr>
							<tr>
								<td class="labelForm">Calle:</td>
								<td><input type="text" style="width: 200px" name="calle" value="${inputVenta.ordenDeVenta.cliente.calle}" <%= false ? "" : "disabled" %>></input></td>
								<td class="labelForm">Altura:</td>
								<td><input type="text" size="10" name="numero" value="${inputVenta.ordenDeVenta.cliente.numeroCalle}" <%= false ? "" : "disabled" %>></input></td>
								<td class="labelForm">Dpto:</td>
								<td><input type="text" size="10" name="numero" value="${inputVenta.ordenDeVenta.cliente.dpto}" <%= false ? "" : "disabled" %>></input></td>
							</tr>
						</table>
					</fieldset>
					<fieldset>
						<legend>Productos</legend>
						<table>
							<tr>
								<td colspan="5" class="separador"></td>
							</tr>
							<c:if test="${!empty erroresInputVenta.campo.cliente}">
								<div class="errorEntrada">${erroresInputVenta.campo.cliente}</div>
							</c:if>
							<tr>
								<td class="labelForm">Nombre:</td>
								<td><input type="text" style="width: 300px" name="nombre" id="nombre" value="${inputVenta.buscador.nombre}"  <%= enVenta ? "" : "disabled" %>/> <c:if
										test="${!empty errores.campo.nombre}">
										<div class="errorEntrada">${errores.campo.nombre}</div>
									</c:if></td>
								<td class="labelForm"></td>
								<td class="labelForm">Marca:</td>
								<td><select style="width: 200px" name="idMarca" onchange="redirect(this.options.selectedIndex)"  <%= enVenta ? "" : "disabled" %>>
										<option
											<c:if test="${empty inputVenta.buscador.idMarca}">selected="selected"</c:if>
											value=""></option>
										<c:forEach items="${marcas}" var="marca">
											<option
												<c:if test="${inputVenta.buscador.idMarca == marca.id}">selected="selected"</c:if>
												value="${marca.id}">${marca.nombre}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td class="labelForm">Código:</td>
								<td><input type="text" style="width: 100px" name="codigo" id="codigo" value="${inputVenta.buscador.codigo}"  <%= enVenta ? "" : "disabled" %>/> <c:if
										test="${!empty errores.campo.codigo}">
										<div class="errorEntrada">${errores.campo.codigo}</div>
									</c:if></td>
								<td class="labelForm"></td>
								<td class="labelForm">Tipo de producto:</td>
								<td><select style="width: 200px" name="idTipoProducto" onchange="redirect(this.options.selectedIndex)"  <%= enVenta ? "" : "disabled" %>>
										<option
											<c:if test="${empty inputVenta.buscador.idTipoProducto}">selected="selected"</c:if>
											value=""></option>
										<c:forEach items="${tiposProducto}" var="tipoProducto">
											<option
												<c:if test="${inputVenta.buscador.idTipoProducto == tipoProducto.id}">selected="selected"</c:if>
												value="${tipoProducto.id}">${tipoProducto.nombre}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td colspan="5" class="separador"></td>
							</tr>
							<tr>
								<td colspan="5" align="right"><input type="submit" value="Buscar" name="btnBuscar"  <%= enVenta ? "" : "disabled" %>></input></td>
							</tr>
							<tr>
								<td colspan="5" class="separador"></td>
							</tr>
							<tr>
								<td colspan="5">
									Codigo de producto:
									<input type="text" name="codigoAgregar" id="codigoAgregar" value="${inputVenta.codigoAgregar}"  <%= enVenta ? "" : "disabled" %>/>
									<input type="text" name="cantidadAgregar" id="cantidadAgregar" value="${inputVenta.cantidadAgregar}"  <%= enVenta ? "" : "disabled" %> size="10"/>
									<input type="submit" value="Agregar" name="btnAgregarProdPorCod" <%= enVenta ? "" : "disabled" %>/>
								</td>
							</tr>
							<tr>
								<td colspan="5" class="separador"></td>
							</tr>
						</table>
						<table width="100%" style="border-collapse: collapse;">
							<tr style="background-color: #4AA; color: White;">
								<td style="text-align: center; border: 1px solid #CCC">Codigo</td>
								<td style="text-align: center; border: 1px solid #CCC">Tipo</td>
								<td style="text-align: center; border: 1px solid #CCC">Marca</td>
								<td style="text-align: center; border: 1px solid #CCC">Nombre</td>
								<td style="text-align: center; border: 1px solid #CCC">Precio</td>
								<td style="text-align: center; border: 1px solid #CCC">Stock</td>
								<td style="text-align: center; border: 1px solid #CCC">Cantidad</td>
								<td style="border: 1px solid #CCC"></td>
							</tr>
							<c:forEach items="${inputVenta.buscador.resultado}" var="producto">
								<tr>
									<td><c:out value="${producto.codigo}" /></td>
									<td><c:out value="${producto.tipoProducto.nombre}" /></td>
									<td><c:out value="${producto.marca.nombre}" /></td>
									<td><c:out value="${producto.nombre}" /></td>
									<td>$<c:out value="${producto.precio}" /></td>
									<td><c:out value="${producto.stock}" /></td>
									<td><input type="text" name="${producto.id}_cantidad" id="${producto.id}_cantidad" size="10" value="<c:out value="1" />" <%= enVenta ? "" : "disabled" %>/></td>
									<td><input type="submit" value="Agregar" name="btnAgregarItem" <%= enVenta ? "" : "disabled" %> onclick="javascript:agregarItem('${producto.codigo}','${producto.id}_cantidad')"></input></td>
								</tr>
							</c:forEach>
							<c:if test="${!empty erroresInputVenta.campo.codigoAgregar}">
								<div class="errorEntrada">Producto: ${erroresInputVenta.campo.codigoAgregar}</div>
							</c:if>
							<c:if test="${!empty erroresInputVenta.campo.cantidadAgregar}">
								<div class="errorEntrada">Cantidad: ${erroresInputVenta.campo.cantidadAgregar}</div>
							</c:if>
						</table>
						<table width="100%">
							<tr>
								<td class="separador"></td>
							</tr>
							<tr>
								<td>Listado de productos seleccionados:</td>
							</tr>
							<tr>
								<td class="separador"></td>
							</tr>
						</table>
						<table width="100%" style="border-collapse: collapse;">
							<tr style="background-color: #4AA; color: White;">
								<td style="text-align: center; border: 1px solid #CCC">Codigo</td>
								<td style="text-align: center; border: 1px solid #CCC">Tipo</td>
								<td style="text-align: center; border: 1px solid #CCC">Marca</td>
								<td style="text-align: center; border: 1px solid #CCC">Nombre</td>
								<td style="text-align: center; border: 1px solid #CCC">Precio</td>
								<td style="text-align: center; border: 1px solid #CCC">Cantidad</td>
								<td style="border: 1px solid #CCC"></td>
							</tr>
							<c:forEach items="${inputVenta.ordenDeVenta.items}" var="rowItem">
								<tr>
									<td><c:out value="${rowItem.producto.codigo}" /></td>
									<td><c:out value="${rowItem.producto.tipoProducto.nombre}" /></td>
									<td><c:out value="${rowItem.producto.marca.nombre}" /></td>
									<td><c:out value="${rowItem.producto.nombre}" /></td>
									<td>$<c:out value="${rowItem.producto.precio}" /></td>
									<td><c:out value="${rowItem.cantidad}" /></td>
									<td><input type="submit" value="Quitar" name="btnQuitar" onclick="javascript:quitarItem('${rowItem.producto.id}')"></input></td>
								</tr>
								<c:if test="${!empty rowItem.errores.campo.cantidad}">
									<tr><td colspan="7">
										<div class="errorEntrada" style="text-align: center; margin: 2em;">
										<c:out value="${rowItem.errores.campo.cantidad}"></c:out>
										</div>
										</td>
									</tr>
								</c:if>
							</c:forEach>
							<c:if test="${!empty erroresInputVenta.campo.items}">
								<div class="errorEntrada">${erroresInputVenta.campo.items}</div>
							</c:if>
						</table>	
						<table width="100%">
							<tr>
								<td style="width: 85px" align="right">TOTAL:</td>
								<td align="left"><input type="text" name="total" value="${inputVenta.ordenDeVenta.factura.monto}" disabled></input>
								<c:if test="${!empty inputVenta.ordenDeVenta.factura.errores.campo.monto}">
									<div class="errorEntrada">${inputVenta.ordenDeVenta.factura.errores.campo.monto}</div>
								</c:if> 
								</td>
							</tr>
						</table>
					</fieldset>
					
					<c:if
						test="${!empty erroresInputVenta.general}">
						<div class="errorEntrada" style="text-align: center; margin: 2em;">
							<c:out value="${erroresInputVenta.general}"></c:out>
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera"><input type="submit" value="Generar Orden" name="btnAceptar" <%= enVenta ? "" : "disabled" %>></input> 
				<input type="submit" value="Cancelar" name="btnCancelar" <%= enVenta ? "" : "disabled" %>  onclick="return confirm('¿Esta seguro que desea cancelar la operación?')"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>