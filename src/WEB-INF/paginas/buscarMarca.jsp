<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Venta Pro - Buscar Marca</title>

<link rel="stylesheet" type="text/css" href="basico.css" />
<script type="text/javascript">
	function deleteObject(idObject) {
		if (confirm("¿Esta seguro que desea borrarlo?")) {
			document.form.id.value = idObject;
			document.form.action.value = 'borrar';
			document.form.submit();
		}
	}

	function editObject(idObject) {
		document.form.id.value = idObject;
		document.form.action.value = 'editar';
		document.form.submit();
	}
</script>
</head>
<body>
	<form method="post" name="form">
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
					<div style="color: red">OJO, no funciona nada de acá todavía,
						solo se muestran las marcas de prueba más las agregadas por
						agregarMarca.jsp</div>
					<fieldset>
						<legend>Resultado de la búsqueda</legend>
						<table border="1" width="100%" cellspacing="0">
							<tr>
								<td>Nombre</td>
								<td>Sitio web</td>
								<td>Contacto</td>
								<td>Información adicional</td>
								<td>Editar</td>
								<td>Eliminar</td>
							</tr>
							<c:forEach items="${buscador.resultado}" var="marca">
								<tr>
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
				</td>
			</tr>
			<tr>
				<td colspan="2" class="separador"></td>
			</tr>
			<tr>
				<td></td>
				<td class="botonera"><input type="submit" value="Aceptar"
					name="btnAceptar"></input> <input type="submit" value="Cancelar"
					name="btnCancelar"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>