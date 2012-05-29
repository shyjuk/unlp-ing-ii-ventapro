package org.apache.jsp.WEB_002dINF.paginas.formularios;

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
      out.write("\tfunction deleteObject (idObject) {\r\n");
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
      out.write("\t\r\n");
      out.write("\tfunction deleteAllSelectedObjecs () {\r\n");
      out.write("\t\tdocument.test.action.value = 'borrarSeleccionados';\r\n");
      out.write("\t\tdocument.test.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<table width=\"80%\">\r\n");
      out.write("\t");

		java.util.HashMap<String, String> errores = (java.util.HashMap<String,String>)request.getAttribute("errores");
		
		BuscadorProducto buscadorProd = new BuscadorProducto();
		buscadorProd.setNombre((String)request.getParameter("nombre"));
		buscadorProd.setCodigo((String)request.getParameter("codigo"));
		buscadorProd.setMarca((String)request.getParameter("marca"));
		buscadorProd.setCategoria((String)request.getParameter("tipoDeProducto"));
		//if (errores == null || errores.isEmpty()) {
			buscadorProd.ejecutarBusqueda();
		//}
	
      out.write("\r\n");
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
      out.write("\t\t\t\t<SELECT name=\"marca\" id=\"marca\" size=\"1\" onChange=\"redirect(this.options.selectedIndex)\">\r\n");
      out.write("\t\t\t\t\t<OPTION SELECTED></OPTION>\r\n");
      out.write("\t\t\t\t\t<OPTION>-------------------------------</OPTION>\r\n");
      out.write("\t\t\t\t\t");
for (ObjetoPersistente row :SucursalUno.getSingleInstance().getMarcas()) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<OPTION>");
      out.print(Utiles.getNotNullValue(((Marca)row).getNombre()));
      out.write("</OPTION>\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t</SELECT> *\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td size=\"100\" class=\"labelForm\">Código:</td>\r\n");
      out.write("\t\t\t<td align=\"left\"><input type=\"text\" name=\"codigo\" id=\"codigo\" size=\"25\" value=\"");
      out.print(Utiles.getNotNullValue(producto.getNombre()));
      out.write("\"/> *</td>\r\n");
      out.write("\t\t\t<td align=\"left\" class=\"labelForm\" align=\"left\">Categoria:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<SELECT name=\"tipoDeProducto\" width=\"30%\" size=\"1\"  onChange=\"redirect(this.options.selectedIndex)\">\r\n");
      out.write("\t\t\t\t\t\t\t<OPTION SELECTED></OPTION>\r\n");
      out.write("\t\t\t\t\t\t\t<OPTION>-------------------------------</OPTION>\r\n");
      out.write("\t\t\t\t\t\t\t");
for (ObjetoPersistente row : SucursalUno.getSingleInstance().getTiposDeProducto()) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<OPTION>");
      out.print(Utiles.getNotNullValue(((TipoDeProducto)row).getNombre()));
      out.write("</OPTION>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\r\n");
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
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" heigth=\"40\">&nbsp</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" heigth=\"40\">&nbsp</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<legend>Resultado de la búsqueda</legend>\r\n");
      out.write("\t\t\t\t");

				java.util.ArrayList<ObjetoPersistente> resultado = buscadorProd.getResultado();
				java.util.ArrayList<String> listId = new java.util.ArrayList<String>();
				for (ObjetoPersistente object : resultado) {
					listId.add(String.valueOf(object.getId()));
				}
				
      out.write("\r\n");
      out.write("\t\t\t\t<table border=\"1\" width=\"100%\" cellpading=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\"><input type=\"checkbox\" name=\"");
      out.print("seleccionados_TODOS");
      out.write("\" value=\"FALSE\" onclick=\"javascript:changeAllSelection(this,");
      out.print(listId);
      out.write(");\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Codigo</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Nombre</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Precio</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Marca</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Tipo de Producto</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Garantia</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Stock</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Stock Minimo</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">En Venta</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Descripcion</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Editar</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\">Borrar</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
 for (ObjetoPersistente row : resultado) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"center\"><input type=\"checkbox\" name=\"");
      out.print("seleccionados_" + row.getId());
      out.write("\" id=\"");
      out.print("seleccionados_" + row.getId());
      out.write("\" value=\"FALSE\" onclick=\"javascript:changeSelection(this);\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getCodigo()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getNombre()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getPrecio()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getMarca()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getTipoDeProducto()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getGarantia()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getStock()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getStockMinimo()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).isEnVenta()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(Utiles.getNotNullValue(((Producto)row).getDescripcion()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"center\"><img src=\"imagenes/iconos/edit.gif\" onclick=\"javascript:editObject('");
      out.print(row.getId());
      out.write("')\" alt=\"Editar\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"center\"><img src=\"imagenes/iconos/button_delete.gif\" onclick=\"javascript:deleteObject('");
      out.print(row.getId());
      out.write("');\" alt=\"Borrar\"/></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" heigth=\"40\">&nbsp</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t");
 if (errores != null && errores.containsKey(Validador.ERROR_GENERICO)){ 
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" heigth=\"40\" class=\"errorEntrada\" align=\"center\">");
      out.print(errores.get(Validador.ERROR_GENERICO));
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t</tr>\r\n");
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
