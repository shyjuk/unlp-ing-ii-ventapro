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
<title>Venta Pro - Buscar Marca</title>

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
				<td class="funcs funcsSecundarias"><a class="func"
					href="buscarProducto.jsp">Producto</a> <a class="func funcAct"
					href="#">Marca</a> <a class="func" href="buscarTipoProducto.jsp">Tipo
						de producto</a></td>
			</tr>
			<tr>
				<td class="funcs funcsPrincipales"><a
					class="funcPrincipal funcPrincipalAct" href="#">Gestión de
						productos</a> <a class="funcPrincipal" href="#">Ventas</a> <a
					class="funcPrincipal" href="#">Administración de clientes</a> <a
					class="funcPrincipal" href="#">Reportes</a> <a
					class="funcPrincipal" href="#">Administración de usuarios</a></td>

				<td class="panelPrincipal">
					<div class="subFuncs">
						<a class="subFunc subFuncAct" href="#">Buscar</a> <a
							class="subFunc" href="agregarMarca.jsp">Agregar</a>
					</div>
					<div class="helpText">
						Si necesita ayuda haga <a
							href="javascript:abrirPopUp('popupAyudaGenerica.html')">click
							aquí</a>
					</div>
					<table>
						<tr>
							<td class="labelForm">Nombre:</td>
							<td><input type="text" name="nombre" id="nombre" size="50"
								value="${buscador.nombre}" /> *</td>
						</tr>
						<tr>
							<td colspan="2" class="separador"></td>
						</tr>
					</table>

					<fieldset>
						<legend>Resultado de la búsqueda</legend>
						<table border="1" width="100%" cellspacing="0">
							<tr>
								<td><input type="checkbox" name="seleccionados_TODOS"
									value="FALSE"
									onclick="javascript:changeAllSelection(this,${listaId});" /></td>
								<td>Nombre</td>
								<td>Sitio web</td>
								<td>Contacto</td>
								<td>Información adicional</td>
								<td>Editar</td>
								<td>Eliminar</td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="marca">
								<tr>
									<td><input type="checkbox"
										name="seleccionados_${marca.id}"
										id="seleccionados_${marca.id}" value="FALSE"
										onclick="javascript:changeSelection(this);" /></td>
									<td><c:out value="${marca.nombre}" /></td>
									<td><c:out value="${marca.sitioWeb}" /></td>
									<td><c:out value="${marca.contacto}" /></td>
									<td><c:out value="${marca.infoAdicional}" /></td>
									<td align="center"><img src="imagenes/iconos/edit.gif"
										onclick="javascript:editObject('${marca.id}')" alt="Editar" /></td>
									<td align="center"><img
										src="imagenes/iconos/button_delete.gif"
										onclick="javascript:deleteObject('${marca.id}');" alt="Borrar" /></td>
								</tr>
							</c:forEach>
						</table>
					</fieldset>
								<c:if test="${!empty buscador.errorGenerico}">
				
					<div class="errorEntrada" style="text-align: center; margin: 2em;"><c:out
							value="${buscador.errorGenerico}"></c:out></div>
				
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
					onclick="return confirm('¿Esta seguro que desea borrar las marcas seleccionadas?')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>