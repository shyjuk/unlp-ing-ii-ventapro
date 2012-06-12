<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unlp.info.ingenieriaii.modelo.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import=" java.math.BigDecimal"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Ayuda</title>
	<link rel="stylesheet" type="text/css" href="basico.css" />
</head>
<body>
	<%	String idOrden = request.getParameter("idOrden");
		ArrayList<Item> items = Item.buscarItems(Integer.valueOf(idOrden));
	%>
	<table width="508">
		<tr>
			<td>
				<fieldset>
					<legend>Detalle de compra</legend>
					<table border="1" width="100%" cellspacing="0">
						<tr  style="background-color: #4AA; color: White;">
							<td style="width: 15px; text-align: center; border: 1px solid #CCC" align="center">Producto</td>
							<td style="width: 15px; text-align: center; border: 1px solid #CCC" align="center">Cantidad</td>
							<td style="width: 15px; text-align: center; border: 1px solid #CCC" align="center">Monto</td>
							<td style="width: 15px; text-align: center; border: 1px solid #CCC" align="center">Total</td>
						</tr>
						<%
						BigDecimal total = BigDecimal.ZERO; 
						for (Item item : items) {%>
							<tr>
								<% String detalleProducto = "(" + item.getProducto().getCodigo() + ") " + item.getProducto().getNombre() + " - " + item.getProducto().getMarca().getNombre();%>
								<td style="border: 1px solid #CCC" align="center"><c:out value="<%=detalleProducto%>" /></td>
								<td style="border: 1px solid #CCC" align="center"><c:out value="<%=item.getCantidad() %>" /></td>
								<td style="border: 1px solid #CCC" align="center"><c:out value="<%=item.getPrecio()%>" /></td>
								<% 	BigDecimal subtotal = item.getPrecio().multiply(new BigDecimal(item.getCantidad()));
									total = total.add(subtotal); %>
								<td style="border: 1px solid #CCC" align="center">$<c:out value="<%=subtotal%>" /></td>
							</tr>
						<%} %>
						<tr>
							<td style="border: 1px solid #CCC" align="center" colspan="3"></td>
							<td style="border: 1px solid #CCC" align="center" align="center"><b>Total</b>: $<%=total %></td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</table>
</body>
</html>