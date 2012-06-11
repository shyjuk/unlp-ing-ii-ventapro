<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*" %>

<fieldset>
	<table width=100%>
		<legend>Datos de la Orden</legend>
			<tr>
				<td colspan=2 align="left"><label>Nombre del Vendedor:</label></td>
				<td colspan=2><SELECT name="nombreV" id="nombreV" style="width: 200px"></SELECT> *</td>
				<td colspan=2 align="left">Medio de Pago:</td>
				<td><SELECT align="left" style="width: 200px">Descripción</SELECT> *</td>
			</tr>
			<tr>
				<td width="10%" align=left>FECHA:</td>
				<td width="10%"></td>
				<td width="10%">HORA:</td>
				<td width="10%"></td>
			</tr>
			<tr><td colspan=12><hr></hr></td></tr>
			<tr>
				<td colspan=2 width="10%" align="left">DNI Cliente:</td>
				<td><input style="width:200px" type="text" name="dni" id="dni" size="50" value="${buscador.dni}"> </input></td>
				<td width="20%" align="center"><button style="width: 120px">Buscar Cliente</button></td>
			</tr>
			<tr style="height: 10px"></tr>
			<tr>
				<td colspan=2 width="10%" align="left">Nombre del Cliente:</td>
				<td colspan=3><input style="width: 350px"></input></td>
			</tr>
	</table>
	<table width=100%>
		<tr style="height: 5px"><tr>
		<tr>
			<td  style="width:145px" colspan=1 class="labelForm">Fecha:</td>
			<td align="left">
					<input align="left" type="text" name="dia" id="dia" size="2" value="" />
					<input align="left" type="text" name="mes" id="mes" size="2" value="" />
					<input align="left" type="text" name="anio" id="anio" size="4" value="" />
					<div class="errorEntrada"></div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td class="labelForm"  align="left"> dd/mm/aaaa</td>
		</tr>
	</table>
	<table width=100%>
		<tr>
			<td>DIRECCION</td>
		</tr>
		<tr>
			<td style="width: 175px">CALLE</td>
			<td align="left"><input style="width: 250px"></input></td>
			<td align="left">Nro.</td>
			<td><input style="width:60px"></input></td>
			<td>COD. POSTAL</td>
			<td align="left"><input style="width:60px"></input></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><input style="width: 250px"></input></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<table width=100%>
		<legend>Productos</legend>
			<tr>
				<td colspan=3 align="left"><font size=1>Ingrese un criterio de búsqueda, luego haga clic en "Buscar":</font></td>
			</tr>
			<tr>
				<td align="right">TIPO:</td>
				<td align="left"><input  style="width: 200px"></input></td>
				<td align="right">MARCA:</td>
				<td align="left"><input align="left" style="width: 200px"></input></td>
				<td align="right" colspan=3 >OTROS:</td>
				<td colspan=6 align="right"><input align="left" style="width: 300px"></input></td>
			</tr>
			<tr>
				<td colspan=12 align="left"><font size=1>Seleccione un item, la cantidad y luego haga clic en "Agregar a la Orden", para que sea incluido en la misma":</font></td>
				<td align="right"><button style="width: 125px">BUSCAR</button></td>
			</tr>
	</table>
	<table border="1" width=100% cellpading="0" cellspacing="0">
					<tr>
						<td align="center"><input type="checkbox" name="" value="FALSE" onclick=""></input></td>
						<td align="center">TIPO</td>
						<td align="center">MARCA</td>
						<td align="center">PRECIO</td>
						<td align="center">DESCRIPCION</td>
					</tr>
					<tr>
							<td align="center"><input type="checkbox" name="="" id="" value="FALSE" onclick="javascript:changeSelection(this);"></input></td>
							<td></td>
							<td></td>
							<td align="center"><img src="imagenes/iconos/edit.gif" onclick="" alt="Editar" /></td>
							<td align="center"><img src="imagenes/iconos/button_delete.gif" onclick="" alt="Borrar"/></td>
					</tr>
	</table>
	<table width=100%>
		<tr>
			<td style="width: 100px" align="left">CANTIDAD:</td>
			<td align="left" width=90%><input></input></td>
			<td align="center"><button align="right" style="width: 200px">Agregar Item a la Orden</button></td>
		</tr>
	</table>
	<table border="1" width=100% cellpading="0" cellspacing="0">
					<tr>
						<td align="center"><input type="checkbox" name="" value="FALSE" onclick=""></input></td>
						<td align="center">TIPO</td>
						<td align="center">MARCA</td>
						<td align="center">PRECIO</td>
						<td align="center">DESCRIPCION</td>
					</tr>
					<tr>
							<td align="center"><input type="checkbox" name="="" id="" value="FALSE" onclick="javascript:changeSelection(this);"></input></td>
							<td></td>
							<td></td>
							<td align="center"><img src="imagenes/iconos/edit.gif" onclick="" alt="Editar" /></td>
							<td align="center"><img src="imagenes/iconos/button_delete.gif" onclick="" alt="Borrar"/></td>
					</tr>
	</table>
	<table width=100%>
		<tr>
			<td style="width: 85px" align="right">TOTAL:</td>
			<td align="left"><input align="left"></input></td>
		</tr>
	</table>
</fieldset>