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
<title>VentaPro - Buscar Producto</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script src="funciones.js" type="text/javascript"></script>
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
				<td class="funcs funcsSecundarias"><a class="func funcAct"
					href="#">Producto</a> <a class="func" href="buscarMarca.jsp">Marca</a>
					<a class="func" href="buscarTipoProducto.jsp">Tipo de producto</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales"><a
					class="funcPrincipal funcPrincipalAct" href="#">Gestión de
						productos</a> <a class="funcPrincipal" href="generarOrden.jsp">Ventas</a> <a
					class="funcPrincipal" href="#">Administración de clientes</a> <a
					class="funcPrincipal" href="#">Reportes</a> <a
					class="funcPrincipal" href="#">Administración de usuarios</a></td>

				<td class="panelPrincipal">
					<div class="subFuncs">
						<a class="subFunc subFuncAct" href="#">Buscar</a> <a
							class="subFunc" href="agregarProducto.jsp">Agregar</a>
					</div>
					<div class="helpText">
						Si necesita ayuda haga <a
							href="javascript:abrirPopUp('popupAyudaGenerica.html')">click
							aquí</a>
					</div>
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
							<td colspan="5"><input name="chkIncluir" type="checkbox"
								value="true"
								<c:if
									test="${empty buscador.enVenta}">checked="checked"</c:if> />Incluir
								productos que no es encuentren a la venta.</td>
						</tr>
						<tr>
							<td colspan="5" class="separador"></td>
						</tr>
					</table>

					<fieldset>
						<legend>Resultado de la búsqueda</legend>
						<table border="1" width="100%" cellspacing="0">
							<tr>
								<td><input type="checkbox" name="seleccionados_TODOS"
									value="FALSE"
									onclick="javascript:changeAllSelection(this,${listaId});" /></td>
								<td>Código</td>
								<td>Nombre</td>
								<td>Precio</td>
								<td>Marca</td>
								<td>Tipo de Producto</td>
								<td>Garantía</td>
								<td>Stock</td>
								<td>Stock Mínimo</td>
								<td>En Venta</td>
								<td>Descripción</td>
								<td>Editar</td>
								<td>Borrar</td>
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
									<td><c:out value="${producto.stockMinimo}" /></td>
									<td><c:out value="${producto.enVenta}" /></td>
									<td><c:out value="${producto.descripcion}" /></td>
									<td align="center"><img src="imagenes/iconos/edit.gif"
										onclick="javascript:editObject('${producto.id}')" alt="Editar" /></td>
									<td align="center"><img
										src="imagenes/iconos/button_delete.gif"
										onclick="javascript:deleteObject('${producto.id}');"
										alt="Borrar" /></td>
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
				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera"><input type="submit" value="Aceptar"
					name="btnAceptar" /> <input type="submit" value="Borrar"
					name="btnBorrar"
					onclick="return confirm('¿Esta seguro que desea borrar los productos seleccionados?')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>