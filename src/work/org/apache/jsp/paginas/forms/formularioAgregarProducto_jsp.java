package org.apache.jsp.paginas.forms;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import unlp.info.ingenieriaii.modelo.*;
import unlp.info.ingenieriaii.web.*;

public final class formularioAgregarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t<title>Venta Pro - Agregar Producto</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"basico.css\" />\r\n");
      out.write("\t<script src=\"funciones.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction cancelar () {\r\n");
      out.write("\t\tif (confirm(\"¿Esta seguro que desea cancelar la operación?\")){\r\n");
      out.write("\t\t\tsubmit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction agregar () {\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"objectName\" value=\"unlp.info.ingenieriaii.modelo.Producto\">\r\n");
      out.write("\t");

	Producto producto = new Producto(); 
	java.util.HashMap<String, String> errores = (java.util.HashMap<String,String>)request.getAttribute("errores");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"helpText\" colspan=\"4\" align=\"right\">Si necesita ayuda haga <a href=\"javascript:abrirPopUp('popupAyudaGenerica.html')\">click aquí</a></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" height=\"40\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Codigo:</td>\r\n");
      out.write("\t\t\t<td colspan=3><input type=\"text\" name=\"nombre\" id=\"nombre\" size=\"50\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getNombre()));
      out.write("\"/> * (Ingreso del código de barras del Producto)</td>\r\n");
      out.write("\t\t</tr>\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Nombre:</td>\r\n");
      out.write("\t\t\t<td colspan=3><input type=\"text\" name=\"nombre\" id=\"nombre\" size=\"100\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getNombre()));
      out.write("\"/> *</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
 if (errores != null && errores.containsKey("nombre")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"errorEntrada\">");
      out.print(errores.get("nombre"));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Tipo de Producto:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<SELECT name=\"tipoDeProducto\" width=\"30%\" size=\"1\"  onChange=\"redirect(this.options.selectedIndex)\">\r\n");
      out.write("\t\t\t\t\t<OPTION SELECTED> </OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>-------------------------------</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis2</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis3</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis4</OPTION> \r\n");
      out.write("\t\t\t\t</SELECT> *\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"55%\" class=\"labelForm\" align=\"left\">Descripcion:</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Marca:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<SELECT name=\"marca\" size=\"1\" onChange=\"redirect(this.options.selectedIndex)\">\r\n");
      out.write("\t\t\t\t\t<OPTION SELECTED> </OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>-------------------------------</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis2</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis3</OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>aplisis4</OPTION> \r\n");
      out.write("\t\t\t\t</SELECT> *\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"55%\" align=\"left\" rowspan=5><textarea rows=\"9\" cols=\"45\"></textarea></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Precio:</td>\r\n");
      out.write("\t\t\t<td width=\"250\"><input type=\"text\" name=\"precio\" id=\"nombre\" size=\"25\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getPrecio()));
      out.write("\"/> *</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Garantia:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"garantia\" id=\"nombre\" size=\"5\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getGarantia()));
      out.write("\"/>meses *</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Stock:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"stock\" id=\"nombre\" size=\"5\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getStock()));
      out.write("\"/>unidades *</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"labelForm\">Stock Minimo:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"stockMinimo\" id=\"nombre\" size=\"5\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getStockMinimo()));
      out.write("\"/>unidades</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
 if (errores != null && errores.containsKey(Validador.ERROR_GENERICO)){ 
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" colspan=\"2\" class=\"errorEntrada\">");
      out.print(errores.get(Validador.ERROR_GENERICO));
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t");
}
      out.write("\r\n");
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
