<%@ page contentType="text/html; charset=utf-8" language="java" import="java.lang.String" errorPage="" %>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body style="font-family:Sans-serif; color:white">
<table width="100%">
<tr>
<td>

<table border="0" align="center" width="80%" bgcolor="#3B5998">
	<tr>
		<td><b><%=SucursalUno.getSingleInstance().getNombre()%></b></td>
		<td align="right"><b>Rodolfo Perez&nbsp</b></td>
		<td align="right" width="15%"><button type="button">Cerrar Sesion</button></td>
	</tr>
</table>

</td>
</tr>
<tr>
	<td height="20"></td>
</tr>	
<tr>
<td>

<table border="0" align="center" width="80%">
	<tr>
		<td width="15%"></td>
		<td width="85%" style="font-variant: small-caps;">
			<span style="display: inline-block; background-color:#4AA; padding: 1ex; margin-right: 1em; border-top: 4px solid #255;">Producto</span>
			<span style="display: inline-block; background-color:#4AA; padding: 1ex; margin-right: 1em;">Marca</span>
			<span style="display: inline-block; background-color:#4AA; padding: 1ex; margin-right: 1em;">Tipo de producto</span>
		</td>
	</tr>
	<tr>
		<td valign="top" width="15%">
		<div style="font-variant: small-caps;">
			<div style="background-color:#4AA; padding: 1ex; margin-right: 1em; margin: 4px; margin-right: 0px; border-left: 8px solid #255;">Gestión de productos</div>
			<div style="background-color:#4AA; padding: 1ex; margin-right: 1em; margin: 4px; margin-right: 0px; border-left: 8px solid #4AA;">Ventas</div>
			<div style="background-color:#4AA; padding: 1ex; margin-right: 1em; margin: 4px; margin-right: 0px; border-left: 8px solid #4AA;">Administración de clientes</div>
			<div style="background-color:#4AA; padding: 1ex; margin-right: 1em; margin: 4px; margin-right: 0px; border-left: 8px solid #4AA;">Reportes</div>
		</div>
		</td>
		<td width="85%">
			<div style="border: 1px solid #CCC; border-top: 4px solid #CCC; height:300px; position: relative; top: -4px; left: -4px;">
				<div style="font-family:Sans-serif; color:Black; font-size:12px; font-weight:bold;">
					<span style="display: inline-block; margin-left: 1ex; padding:1ex; border-left: 1px solid #AAA;border-right: 1px solid #AAA;border-bottom: 4px solid #AAA;">Buscar</span>
					<span style="display: inline-block; margin-left: 1ex; padding:1ex; border-left: 1px solid #ccc;border-right: 1px solid #ccc;border-bottom: 1px solid #ccc;">Agregar</span>
				</div>			
			</div>
				<div style="border: 1px solid #CCC; text-align: center; padding: 3px; position: relative; left: -4px;">
					<button type="button">Aceptar</button>&nbsp;&nbsp;&nbsp;
					<button type="button">Cancelar</button>
				</div>
		</td>
	<tr>
</table>

</td>
</tr>
</table>
</body>
</html>