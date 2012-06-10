<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno"%>
<%@ page import="unlp.info.ingenieriaii.web.Validador"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VentaPro - Buscar Orden de venta</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
<script type="text/javascript">
	function anularObject(idObject) {
		if (confirm("¿Esta seguro que desea anular la orden?")) {
			document.form.id.value = idObject;
			document.form.accion.value = 'anular';
			document.form.submit();
		}
	}
	
	function viewDetails (idObject) {
		
		
	}

	function editObject(idObject) {
		document.form.id.value = idObject;
		document.form.action = "modificarMarca.jsp";
		document.form.accion.value = 'editar';
		document.form.submit();
	}
</script>
</head>
<body>
	<form method="post" name="form">
		<input type="hidden" name="id" value="" /> <input type="hidden"
			name="accion" value="" />
		<div class="header">
			<div class="nombreSucursal"><%=SucursalUno.getSingleInstance().getNombre()%></div>
			<div class="nombreUsuario">
				<%=("Rodolfo Perez")%>
				<input type="submit" value="Cerrar sesión" name="btnCerrarSesion"></input>
			</div>
			<div class="clear"></div>
		</div>

		<table class="principal">
			<tr>
				<td></td>
				<td class="funcs funcsSecundarias">
				<a class="func" href="buscarProducto.jsp">TODO</a> 
				<a class="func funcAct" href="#">Buscar Orden</a> 
				<a class="func" href="cobrarOrden.jsp">Cobrar Orden</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales">
					<a class="funcPrincipal" href="buscarProducto.jsp">Gestión de productos</a> 
					<a class="funcPrincipal funcPrincipalAct" href="#">Ventas</a> 
					<a class="funcPrincipal" href="#">Administración de clientes</a> 
					<a class="funcPrincipal" href="#">Reportes</a> 
					<a class="funcPrincipal" href="#">Administración de usuarios</a></td>
				<td class="panelPrincipal">
					<div class="helpText">
						Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a>
					</div>
					<table>
						<tr>
							<td class="labelForm">DNI Comprador:</td>
							<td><input type="text" name="dni" id="dni" size="50" value="${buscador.dni}" onkeypress="return isNumberKey(event)"/>
								<c:if test="${!empty errores.campo.dni}">
									<div class="errorEntrada">${errores.campo.dni}</div>
								</c:if></td>
						</tr>
						<tr>
							<td class="labelForm">Vendedor:</td>
							<td><select name="vendedor" style="width: 30ex" onchange="redirect(this.options.selectedIndex)">
									<option
										<c:if test="${empty buscador.vendedor}">selected="selected"</c:if> value=""></option>
										<c:forEach items="${vendedores}" var="vrow">
										<option <c:if test="${buscador.vendedor == vrow.id}">selected="selected"</c:if> value="${vrow.id}">${vrow.nombre}
										</option>
									</c:forEach>
								</select> 
								<c:if test="${!empty errores.campo.vendedor}">
									<div class="errorEntrada">${errores.campo.vendedor}</div>
								</c:if></td>
						</tr>
						<tr>
							<td class="labelForm">Cod. Producto:</td>
							<td><input type="text" name="producto" id="producto" size="50" value="${buscador.producto}" />
								<c:if test="${!empty errores.campo.producto}">
									<div class="errorEntrada">${errores.campo.producto}</div>
								</c:if></td>
						</tr>
						<tr>
							<td class="labelForm">Fecha:</td>
							<td><input type="text" name="dia" id="dia" size="2" value="${buscador.dia}" />
								<input type="text" name="mes" id="mes" size="2" value="${buscador.mes}" />
								<input type="text" name="anio" id="anio" size="4" value="${buscador.anio}" />
								<c:if test="${!empty errores.campo.fecha}">
									<div class="errorEntrada">${errores.campo.fecha}</div>
								</c:if></td>
						</tr>
						<tr>
							<td></td>
							<td class="comment">dd/mm/yyy</td>
						</tr>
						<tr>
							<td class="labelForm">Estado:</td>
							<td><select name="estado" style="width: 30ex" onchange="redirect(this.options.selectedIndex)">
									<option
										<c:if test="${empty buscador.estado}">selected="selected"</c:if> value=""></option>
										<c:forEach items="${estados}" var="erow">
										<option <c:if test="${buscador.estado == erow.id}">selected="selected"</c:if> value="${erow.id}">${erow.descripcion}
										</option>
									</c:forEach>
								</select> 
								<c:if test="${!empty errores.campo.vendedor}">
									<div class="errorEntrada">${errores.campo.vendedor}</div>
								</c:if></td>
						</tr>
						<tr>
							<td colspan="2" class="separador"></td>
						</tr>
					</table>

					<fieldset>
						<legend>Resultado de la búsqueda</legend>
						<table border="1" width="100%" cellspacing="0">
							<tr>
								<td>Fecha</td>
								<td>Comprador</td>
								<td>Vendedor</td>
								<td>Cant. Productos</td>
								<td>Monto</td>
								<td>Detalles</td>
								<td>Anular</td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="row">
								<tr>
									<td><c:out value="${row.fecha}" /></td>
									<td><c:out value="${row.comprador}" /></td>
									<td><c:out value="${row.vendedor}" /></td>
									<td><c:out value="${row.cantProductos}" /></td>
									<td><c:out value="${row.montoTotal}" /></td>
									<td align="center"><img src="imagenes/iconos/glasses.gif" onclick="javascript:abrirPopUpConParam('popupDetalleOrden.jsp','idOrden','${row.id}')" alt="Ver" /></td>
									<td align="center">
										<c:if test="${row.estado == 1}">
											<img src="imagenes/iconos/delete.gif" onclick="javascript:anularObject('${row.id}');" alt="Anular" />
										</c:if><c:if test="${row.estado != 1}">
											<img src="imagenes/iconos/delete-off.gif"/>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</table>
					</fieldset>
					<c:if test="${!empty errores.general}">
						<div class="errorEntrada" style="text-align: center; margin: 2em;">
							<c:out value="${errores.general}"></c:out>
						</div>
					</c:if>
					<c:if test="${!empty erroresEliminar.general}">
						<div class="errorEntrada" style="text-align: center; margin: 2em;">
							<c:out value="${erroresEliminar.general}"></c:out>
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera">
					<input type="submit" value="Buscar" name="btnBuscar" /> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>