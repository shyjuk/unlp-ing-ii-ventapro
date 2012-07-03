package org.apache.jsp.WEB_002dINF.paginas.formularios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import unlp.info.ingenieriaii.web.*;

public final class reporteProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>VentaPro - Agregar Cliente</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"basico.css\" />\r\n");
      out.write("<script src=\"funciones.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");


Connection  conexion = AccesoDb.abrirConexion();
ResultSet rs = conexion.createStatement().executeQuery((String)request.getAttribute("query"));
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=1>\r\n");
      out.write("\r\n");
      out.write("<tr><th>Codigo</th><th>Nombre</th><th>Tipo</th><th>Marca</th><th>Precio</th><th>Garantia</th><th>Stock</th><th>Stock Minimo</th><th>En Venta</th><th>Descripcion</th></tr>\r\n");
      out.write("\r\n");
while (rs.next()) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getString("codigo"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getString("nombre"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getString("tipo"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getString("marca"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getFloat("precio"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getInt("garantia"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getInt("stock"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getInt("stockMinimo"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getString("enVenta"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
out.println(rs.getString("descripcion"));
      out.write("</td>\r\n");
 
}

out.println("</table>");

conexion.close();


    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
