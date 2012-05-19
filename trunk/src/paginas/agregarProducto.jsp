<%@ page contentType="text/html; charset=utf-8" language="java" import="java.lang.String" errorPage="" %>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno" %>
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

<table border="1" align="center" width="80%">
	<tr>
		<td width="15%"></td>
		<td width="85%">
		<table border="0" width="80%">
			<tr bgcolor="#4AA">
				<td><b>PRODUCTO</b></td>
				<td><b>MARCA</b></td>
				<td><b>TIPO DE PRODUCTO</b></td>
			</tr>
			<tr style="font-family:Sans-serif; color:#3B5998; font-size:12px">
				<td><b><u>Buscar</u></b></td>
				<td><b><u>Agregar</u></b></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td valign="top" width="15%">
		<table align="center" border="1">
			<tr bgcolor="#4AA"><td height="30"><b>Gestion de producto</b></td></tr>
			<tr><td height="10"></td></tr>
			<tr bgcolor="#4AA"><td height="30"><b>Venta</b></td></tr>
			<tr><td height="10"></td></tr>
			<tr bgcolor="#4AA"><td height="30"><b>Cliente</b></td></tr>	
			<tr><td height="10"></td></tr>
		</table>
		</td>
		<td width="85%">
			<table width="100%" border="0" align="center">
				<tr height="300">
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td align="right"><button type="button">Aceptar</button></td>
					<td><button type="button">Cancelar</button></td>
				</tr>
			</table>
		</td>
	<tr>
</table>

</td>
</tr>
</table>
</body>