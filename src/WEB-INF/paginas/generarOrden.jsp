<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*"%>
<%@ page import="unlp.info.ingenieriaii.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<% 
			String estadoVenta = (String)request.getAttribute("estadoVenta");
			Boolean enVenta = (Utiles.esVacio(estadoVenta)? false : (GenerarOrdenServlet.EN_VENTA.equals(estadoVenta)));
		
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
					<a class="funcPrincipal funcPrincipalAct"  href="generarOrden.jsp">Ventas</a> <a
					class="funcPrincipal" href="#">Administración de clientes</a> <a
					class="funcPrincipal" href="#">Reportes</a> <a
					class="funcPrincipal" href="#">Administración de usuarios</a></td>

				<td class="panelPrincipal">
					<div class="helpText">Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a> </div>  
					
					<input type="submit" value="Comenzar" name="btnComenzar" <%= enVenta ? "disabled" : "" %> onclick=""/>
					
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
								<td><select name="medioPago" style="width: 30ex" onchange="redirect(this.options.selectedIndex)" <%= enVenta ? "" : "disabled" %>>
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
								<td><select name="cuotas" style="width: 30ex" onchange="redirect(this.options.selectedIndex)"  <%= enVenta ? "" : "disabled" %>>
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
								<td><input type="text" name="dni" id="dni" size="30" value="${dni}"  <%= enVenta ? "" : "disabled" %>/>*</td>
								<td colspan="2"><input type="submit" value="Buscar" name="btnBuscarCliente" <%= enVenta ? "" : "disabled" %>></input></td>
							</tr>
							<tr style="height: 10px"></tr>
							<tr>
								<td class="labelForm">Nombre y Apellido:</td>
								<td colspan=3><input type="text" style="width: 350px" name="nombreCliente" value="${nombreCliente}"  <%= enVenta ? "" : "disabled" %>></input>*</td>
							</tr>
							<tr>
								<td class="labelForm">Fecha nacimiento:</td>
								<td colspan="3"><input type="text" name="dia" id="dia" size="2" value="${fechaNacimientoDia}"  <%= enVenta ? "" : "disabled" %>/>
									<input type="text" name="mes" id="mes" size="2" value="${fechaNacimientoMes}" <%= enVenta ? "" : "disabled" %>/>
									<input type="text" name="anio" id="anio" size="4" value="${fechaNacimientoAnio}" <%= enVenta ? "" : "disabled" %>/>*
									<c:if test="${!empty errores.campo.fechaNacimiento}">
										<div class="errorEntrada">${errores.campo.fechaNacimiento}</div>
									</c:if></td>
							</tr>
							<tr>
								<td class="labelForm">Teléfono:</td>
								<td colspan=3><input type="text" style="width: 350px" name="telefono" value="${telefono}" <%= enVenta ? "" : "disabled" %>></input></td>
							</tr>
							<tr>
								<td class="labelForm">Celular:</td>
								<td colspan=3><input type="text" style="width: 350px" name="celular" value="${celular}" <%= enVenta ? "" : "disabled" %>></input></td>
							</tr>
							<tr>
								<td class="labelForm">E-mail:</td>
								<td colspan=3><input type="text" style="width: 350px" name="email" value="${email}" <%= enVenta ? "" : "disabled" %>></input></td>
							</tr>
							
						</table>
						<table width=100%>
							<tr>
								<td colspan=6 height="30">Dirección:</td>
							</tr>
							<tr>
								<td class="labelForm">Provincia:</td> <!-- FALTA MODIFICAR CARGA DE COMBO  -->
								<td><select name="provincia" style="width: 30ex" onchange="redirect(this.options.selectedIndex)" <%= enVenta ? "" : "disabled" %>>
										<option
											<c:if test="${empty ''}">selected="selected"</c:if> value=""></option>
											<c:forEach items="${listaProvincias}" var="rowProvincia">
											<option <c:if test="${'' == rowProvincia.nombre}">selected="selected"</c:if> value="${rowProvincia.id}">${rowProvincia.nombre}
											</option>
										</c:forEach>
									</select>
								</td>
								<td class="labelForm">Localidad:</td> <!-- FALTA MODIFICAR CARGA DE COMBO  -->
								<td colspan="3"><select name="localidad" style="width: 30ex" onchange="redirect(this.options.selectedIndex)" <%= enVenta ? "" : "disabled" %>>
										<option
											<c:if test="${empty ''}">selected="selected"</c:if> value=""></option>
											<c:forEach items="${listaLocalidades}" var="rowLocalidad">
											<option <c:if test="${'falta' == rowLocalidad.nombre}">selected="selected"</c:if> value="${rowLocalidad.id}">${rowLocalidad.nombre}
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td class="labelForm">Calle:</td>
								<td><input type="text" style="width: 200px" name="calle" value="${calle}" <%= enVenta ? "" : "disabled" %>></input></td>
								<td class="labelForm">Nro:</td>
								<td><input type="text" size="10" name="numero" value="${numero}" <%= enVenta ? "" : "disabled" %>></input></td>
								<td class="labelForm">Codigo Postal:</td>
								<td><input type="text" size="10" name="codPostal" value="${codPostal}" <%= enVenta ? "" : "disabled" %>></input></td>
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
								<td><input type="text" style="width: 300px" name="nombre" id="nombre" value="${buscador.nombre}"  <%= enVenta ? "" : "disabled" %>/> <c:if
										test="${!empty errores.campo.nombre}">
										<div class="errorEntrada">${errores.campo.nombre}</div>
									</c:if></td>
								<td class="labelForm"></td>
								<td class="labelForm">Marca:</td>
								<td><select style="width: 200px" name="idMarca" onchange="redirect(this.options.selectedIndex)"  <%= enVenta ? "" : "disabled" %>>
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
								<td><input type="text" style="width: 100px" name="codigo" id="codigo" value="${buscador.codigo}"  <%= enVenta ? "" : "disabled" %>/> <c:if
										test="${!empty errores.campo.codigo}">
										<div class="errorEntrada">${errores.campo.codigo}</div>
									</c:if></td>
								<td class="labelForm"></td>
								<td class="labelForm">Tipo de producto:</td>
								<td><select style="width: 200px" name="idTipoProducto" onchange="redirect(this.options.selectedIndex)"  <%= enVenta ? "" : "disabled" %>>
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
								<td colspan="5" align="right"><input type="submit" value="Buscar" name="btnBuscar"  <%= enVenta ? "" : "disabled" %>></input></td>
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
									<td><input type="text" name="${producto.id}_cantidad" id="${producto.id}_cantidad" size="10" value="<c:out value="1" />" <%= enVenta ? "" : "disabled" %>/></td>
									<td><input type="button" value="Agregar" name="btnAgregar" <%= enVenta ? "" : "disabled" %>></input></td>
								</tr>
							</c:forEach>
						</table>
						<table width="100%">
							<tr>
								<td style="width: 85px" align="right">TOTAL:</td>
								<td align="left"><input type="text" name="total" disabled></input></td>
							</tr>
						</table>
					</fieldset>
					
					
					
						
					<c:if
						test="${!empty errores.general}">
						<div class="errorEntrada" style="text-align: center; margin: 2em;">
							<c:out value="${errores.general}"></c:out>
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
				<input type="submit" value="Cancelar" name="btnCancelar" onclick="return confirm('¿Esta seguro que desea cancelar la operación?')"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>