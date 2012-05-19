<%@ page contentType="text/html; charset=utf-8" language="java" import="java.lang.String" errorPage="" %>
<%@ page import="unlp.info.ingenieriaii.modelo.SucursalUno" %>
<%
	// esto es un comentario java
	String variable = "Yo soy una variable java string";
	SucursalUno claseJava = SucursalUno.getSingleInstance();
	claseJava.setNombre("Sucursal La Loma I");
%>
<!--esto es un comentario en html-->
<table border="1">
	<tr>
		<td><%=variable%></td>
		<td><%=claseJava.getNombre()%></td>
		<td>Comentario html<td>
	</tr>
</table>