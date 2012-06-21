<%@page import="java.sql.*" %>
<%@ page import="unlp.info.ingenieriaii.web.*"%>
<%

Class.forName("com.mysql.jdbc.Driver");
Connection  conexion = AccesoDb.abrirConexion();

Statement Estamento = conexion.createStatement();
ResultSet rs = Estamento.executeQuery("SELECT codigo,nombre,precio,garantia,stock,stockMinimo,enVenta,descripcion FROM tbl_productos ORDER BY codigo, enVenta;");

out.println("<table border=1>");

out.println("<tr><th>Codigo</th><th>Nombre</th><th>Precio</th><th>Garantia</th><th>Stock</th><th>Stock Minimo</th><th>En Venta</th><th>Descripcion</th></tr>");

while (rs.next()) {

out.println("<tr>");
        
out.println("<td>");    
        
out.println(rs.getInt("codigo"));

out.println("</td><td>");

out.println(rs.getString("nombre"));

out.println("</td><td>");

out.println(rs.getFloat("precio"));

out.println("</td>");

out.println("<td>");    

out.println(rs.getInt("garantia"));

out.println("</td><td>");

out.println(rs.getInt("stock"));

out.println("</td><td>");   

out.println(rs.getInt("stockMinimo"));

out.println("</td><td>");

out.println(rs.getInt("enVenta"));

out.println("</td><td>");

out.println(rs.getString("descripcion"));

out.println("</td>");

out.println("</tr>");

}

out.println("</table>");

rs.close();
Estamento.close();
conexion.close();

%>