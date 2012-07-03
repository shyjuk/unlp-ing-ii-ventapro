package org.apache.jsp.paginas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import unlp.info.ingenieriaii.modelo.SucursalUno;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	// esto es un comentario java
	String variable = "Yo soy una variable java string";
	SucursalUno claseJava = SucursalUno.getSingleInstance();
	claseJava.setNombre("Sucursal La Loma I");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t<title>Venta Pro</title>\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"basico.css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.mensajePrincipal {\r\n");
      out.write("\t\t\tmargin: 5em;\r\n");
      out.write("\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t\tfont-size: 24px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form method=\"post\">\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"nombreSucursal\">");
      out.print(SucursalUno.getSingleInstance().getNombre());
      out.write("</div>\r\n");
      out.write("\t\t<div class=\"nombreUsuario\">\r\n");
      out.write("\t\t\t");
      out.print(("Rodolfo Perez"));
      out.write("\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"Cerrar sesión\" name=\"btnCerrarSesion\"></input>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<table class=\"principal\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td class=\"funcs funcsSecundarias invisible\">\r\n");
      out.write("\t\t\t\t<a class=\"func funcAct\" href=\"#\">Producto</a>\r\n");
      out.write("\t\t\t\t<a class=\"func\" href=\"#\">Marca</a>\r\n");
      out.write("\t\t\t\t<a class=\"func\" href=\"#\">Tipo de producto</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"funcs funcsPrincipales\">\r\n");
      out.write("\t\t\t\t<a class=\"funcPrincipal\" href=\"buscarProducto.jsp\">Gestión de productos</a>\r\n");
      out.write("\t\t\t\t<a class=\"funcPrincipal\" href=\"generarOrden.jsp\">Ventas</a>\r\n");
      out.write("\t\t\t\t<a class=\"funcPrincipal\" href=\"buscarCliente.jsp\">Administración de clientes</a>\r\n");
      out.write("\t\t\t\t<a class=\"funcPrincipal\" href=\"reporteProductos.jsp\">Reportes</a>\r\n");
      out.write("\t\t\t\t<a class=\"funcPrincipal\" href=\"#\">Administración de usuarios</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td class=\"panelPrincipal\">\r\n");
      out.write("\t\t\t\t<div class=\"subFuncs invisible\">\r\n");
      out.write("\t\t\t\t\t<a class=\"subFunc\" href=\"#\">Buscar</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"subFunc subFuncAct\" href=\"#\">Agregar</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"mensajePrincipal\">\r\n");
      out.write("\t\t\t\t\tHaga click en la opción deseada para comenzar.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" class=\"separador\"></td>\r\n");
      out.write("\t\t</tr>\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td class=\"botonera invisible\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Aceptar\" name=\"btnAceptar\"></input>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Cancelar\" name=\"btnCancelar\"></input>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
