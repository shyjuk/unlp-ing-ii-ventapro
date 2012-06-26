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
	function pagar(idObject) {
		document.form.id.value = idObject;
		document.form.accion.value = 'pagar';
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
				<a class="func" href="generarOrden.jsp">Generar Orden</a> 
				<a class="func" href="buscarOrden.jsp">Buscar Orden</a> 
				<a class="func funcAct" href="#">Cobrar Orden</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales">
					<a class="funcPrincipal" href="buscarProducto.jsp">Gestión de productos</a> 
					<a class="funcPrincipal funcPrincipalAct" href="generarOrden.jsp">Ventas</a> 
					<a class="funcPrincipal" href="#">Administración de clientes</a> 
					<a class="funcPrincipal" href="reporteProductos.jsp">Reportes</a> 
					<a class="funcPrincipal" href="#">Administración de usuarios</a></td>
				<td class="panelPrincipal">
					<div class="helpText">
						Si necesita ayuda haga <a href="javascript:abrirPopUp('popupAyudaGenerica.html')">click aquí</a>
					</div>
					<table>
						<tr>
							<td colspan="2" class="separador"></td>
						</tr>
					</table>

					<fieldset>
						<legend>Ordenes pendientes</legend>
						<table border="1" width="100%" cellspacing="0">
							<tr  style="background-color: #4AA; color: White;">
								<td style="width: 15px; text-align: center; border: 1px solid #CCC">Cod. Orden</td>
								<td style="width: 15px; text-align: center; border: 1px solid #CCC">Comprador</td>
								<td style="width: 15px; text-align: center; border: 1px solid #CCC">Vendedor</td>
								<td style="width: 15px; text-align: center; border: 1px solid #CCC">Monto</td>
								<td style="width: 15px; text-align: center; border: 1px solid #CCC">Medio de pago</td>
								<td style="width: 15px; text-align: center; border: 1px solid #CCC">Cobrar</td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="row">
								<tr>
									<td style="border: 1px solid #CCC"><c:out value="${row.id}" /></td>
									<td style="border: 1px solid #CCC"><c:out value="${row.comprador}" /></td>
									<td style="border: 1px solid #CCC"><c:out value="${row.vendedor}" /></td>
									<td style="border: 1px solid #CCC">$<c:out value="${row.factura.monto}" /></td>
									<td style="border: 1px solid #CCC"><c:out value="${row.montoDetalle}" /></td>
									<td style="border: 1px solid #CCC" align="center"><img src="imagenes/iconos/dolar.gif" onclick="javascript:pagar('${row.id}')" alt="Cobrar" /></td>
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
		</table>
	</form>
</body>
</html>