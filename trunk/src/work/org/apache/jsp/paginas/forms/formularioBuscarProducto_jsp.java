package org.apache.jsp.paginas.forms;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import unlp.info.ingenieriaii.modelo.*;
import unlp.info.ingenieriaii.web.*;

public final class formularioBuscarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      unlp.info.ingenieriaii.modelo.Producto producto = null;
      synchronized (session) {
        producto = (unlp.info.ingenieriaii.modelo.Producto) _jspx_page_context.getAttribute("producto", PageContext.SESSION_SCOPE);
        if (producto == null){
          producto = new unlp.info.ingenieriaii.modelo.Producto();
          _jspx_page_context.setAttribute("producto", producto, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("producto"), request);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction deleteObject (idObject) {\r\n");
      out.write("\t\tif (confirm(\"¿Esta seguro que desea borrarlo?\")){\r\n");
      out.write("\t\t\tdocument.test.id.value = idObject;\r\n");
      out.write("\t\t\tdocument.test.action.value = 'borrar';\r\n");
      out.write("\t\t\tdocument.test.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction editObject (idObject) {\r\n");
      out.write("\t\tdocument.test.id.value = idObject;\r\n");
      out.write("\t\tdocument.test.action.value = 'editar';\r\n");
      out.write("\t\tdocument.test.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<table width=\"80%\">\r\n");
      out.write("\t<tr colspan=4>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"helpText\" colspan=\"4\" align=\"right\">Si necesita ayuda haga <a href=\"javascript:abrirPopUp('popupAyudaGenerica.html')\">click aquí</a></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" height=\"40\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td size=\"100\" class=\"labelForm\">Nombre:</td>\r\n");
      out.write("\t\t\t<td  align=\"left\"><input type=\"text\" name=\"nombre\" id=\"nombre\" size=\"25\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getNombre()));
      out.write("\"/> *</td>\r\n");
      out.write("\t\t\t<td align=\"left\" class=\"labelForm\" align=\"left\">Marca:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<SELECT name=\"marca\" size=\"1\" onChange=\"redirect(this.options.selectedIndex)\">\r\n");
      out.write("\t\t\t\t\t<OPTION SELECTED>-------SELECCIONAR MARCA-------</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION></OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis2</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis3</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis4</OPTION> \r\n");
      out.write("\t\t\t\t</SELECT> *\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td size=\"100\" class=\"labelForm\">Código:</td>\r\n");
      out.write("\t\t\t<td align=\"left\"><input type=\"text\" name=\"nombre\" id=\"nombre\" size=\"25\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getNombre()));
      out.write("\"/> *</td>\r\n");
      out.write("\t\t\t<td align=\"left\" class=\"labelForm\" align=\"left\">Categoria:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<SELECT name=\"marca\" size=\"1\" onChange=\"redirect(this.options.selectedIndex)\">\r\n");
      out.write("\t\t\t\t\t<OPTION SELECTED>----SELECCIONAR CATEGORIA---</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION></OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis2</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis3</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis4</OPTION> \r\n");
      out.write("\t\t\t\t</SELECT> *\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"enVenta\">En Venta\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</td>\t\r\n");
      out.write("</table>");
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
