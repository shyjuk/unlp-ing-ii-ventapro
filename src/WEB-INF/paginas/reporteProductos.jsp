<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VentaPro - Agregar Cliente</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
</head>
<body>
	<form method="post">
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
				<td class="funcs funcsSecundarias"><a class="func funcAct"
					href="#">Reportes Productos</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales"><a class="funcPrincipal"
					href="buscarProducto.jsp">Gestión de productos</a> <a
					class="funcPrincipal" href="generarOrden.jsp">Ventas</a> <a
					class="funcPrincipal" href="agregarCliente.jsp">Administración
						de clientes</a> <a class=" funcPrincipalAct funcPrincipal"
					href="reporteProductos.jsp">Reportes</a> <a class="funcPrincipal"
					href="#">Administración de usuarios</a></td>

				<td class="panelPrincipal">
					<div class="subFuncs">
						<a class="subFunc" href="reporteBajoStock.jsp">Bajo el Stock
							Minimo</a> <a class="subFunc" href="productosInactivos.jsp">Productos
							Inactivos</a> <a class="subFunc" href="productosEnVenta.jsp">Productos
							En Venta</a> <a class="subFunc subFuncAct"
							href="reporteProductos.jsp">Todos</a>
					</div>

					<div class="helpText">
						Si necesita ayuda haga <a
							href="javascript:abrirPopUp('popupAyudaGenerica.html')">click
							aquí</a>
					</div>

					<div style="margin: 8px; border: 1px solid #CCC">
						<object data="report.jsp#toolbar=1" type="application/pdf" width="100%"
							height="500px">
							
							<a href="report.jsp">Descargar reporte</a>
						</object>
					</div> <c:if test="${!empty errores.general}">
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
				<td class="botonera"><input type="submit" value="Imprimir"
					name="btnImprimir" disabled="disabled"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>