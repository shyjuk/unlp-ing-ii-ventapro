package org.apache.jsp.tag.web.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pagina_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/tags/funcPrincipal.tag");
    _jspx_dependants.add("/WEB-INF/funciones.tld");
  }

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String nombreFuncionalidad;
  private javax.servlet.jsp.tagext.JspFragment funcionesSecundarias;
  private java.lang.String funcPriProductosActiva;
  private java.lang.String funcPriVentasActiva;
  private java.lang.String funcPriClientesActiva;
  private java.lang.String funcPriReportesActiva;
  private javax.servlet.jsp.tagext.JspFragment subfunciones;
  private javax.servlet.jsp.tagext.JspFragment panelPrincipal;
  private javax.servlet.jsp.tagext.JspFragment botonera;
  private javax.servlet.jsp.tagext.JspFragment head;

  public java.lang.String getNombreFuncionalidad() {
    return this.nombreFuncionalidad;
  }

  public void setNombreFuncionalidad(java.lang.String nombreFuncionalidad) {
    this.nombreFuncionalidad = nombreFuncionalidad;
    jspContext.setAttribute("nombreFuncionalidad", nombreFuncionalidad);
  }

  public javax.servlet.jsp.tagext.JspFragment getFuncionesSecundarias() {
    return this.funcionesSecundarias;
  }

  public void setFuncionesSecundarias(javax.servlet.jsp.tagext.JspFragment funcionesSecundarias) {
    this.funcionesSecundarias = funcionesSecundarias;
    jspContext.setAttribute("funcionesSecundarias", funcionesSecundarias);
  }

  public java.lang.String getFuncPriProductosActiva() {
    return this.funcPriProductosActiva;
  }

  public void setFuncPriProductosActiva(java.lang.String funcPriProductosActiva) {
    this.funcPriProductosActiva = funcPriProductosActiva;
    jspContext.setAttribute("funcPriProductosActiva", funcPriProductosActiva);
  }

  public java.lang.String getFuncPriVentasActiva() {
    return this.funcPriVentasActiva;
  }

  public void setFuncPriVentasActiva(java.lang.String funcPriVentasActiva) {
    this.funcPriVentasActiva = funcPriVentasActiva;
    jspContext.setAttribute("funcPriVentasActiva", funcPriVentasActiva);
  }

  public java.lang.String getFuncPriClientesActiva() {
    return this.funcPriClientesActiva;
  }

  public void setFuncPriClientesActiva(java.lang.String funcPriClientesActiva) {
    this.funcPriClientesActiva = funcPriClientesActiva;
    jspContext.setAttribute("funcPriClientesActiva", funcPriClientesActiva);
  }

  public java.lang.String getFuncPriReportesActiva() {
    return this.funcPriReportesActiva;
  }

  public void setFuncPriReportesActiva(java.lang.String funcPriReportesActiva) {
    this.funcPriReportesActiva = funcPriReportesActiva;
    jspContext.setAttribute("funcPriReportesActiva", funcPriReportesActiva);
  }

  public javax.servlet.jsp.tagext.JspFragment getSubfunciones() {
    return this.subfunciones;
  }

  public void setSubfunciones(javax.servlet.jsp.tagext.JspFragment subfunciones) {
    this.subfunciones = subfunciones;
    jspContext.setAttribute("subfunciones", subfunciones);
  }

  public javax.servlet.jsp.tagext.JspFragment getPanelPrincipal() {
    return this.panelPrincipal;
  }

  public void setPanelPrincipal(javax.servlet.jsp.tagext.JspFragment panelPrincipal) {
    this.panelPrincipal = panelPrincipal;
    jspContext.setAttribute("panelPrincipal", panelPrincipal);
  }

  public javax.servlet.jsp.tagext.JspFragment getBotonera() {
    return this.botonera;
  }

  public void setBotonera(javax.servlet.jsp.tagext.JspFragment botonera) {
    this.botonera = botonera;
    jspContext.setAttribute("botonera", botonera);
  }

  public javax.servlet.jsp.tagext.JspFragment getHead() {
    return this.head;
  }

  public void setHead(javax.servlet.jsp.tagext.JspFragment head) {
    this.head = head;
    jspContext.setAttribute("head", head);
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  private void _jspInit(ServletConfig config) {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) config.getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    _jspInit(config);
    jspContext.getELContext().putContext(JspContext.class,jspContext);
    if( getNombreFuncionalidad() != null ) 
      _jspx_page_context.setAttribute("nombreFuncionalidad", getNombreFuncionalidad());
    if( getFuncionesSecundarias() != null ) 
      _jspx_page_context.setAttribute("funcionesSecundarias", getFuncionesSecundarias());
    if( getFuncPriProductosActiva() != null ) 
      _jspx_page_context.setAttribute("funcPriProductosActiva", getFuncPriProductosActiva());
    if( getFuncPriVentasActiva() != null ) 
      _jspx_page_context.setAttribute("funcPriVentasActiva", getFuncPriVentasActiva());
    if( getFuncPriClientesActiva() != null ) 
      _jspx_page_context.setAttribute("funcPriClientesActiva", getFuncPriClientesActiva());
    if( getFuncPriReportesActiva() != null ) 
      _jspx_page_context.setAttribute("funcPriReportesActiva", getFuncPriReportesActiva());
    if( getSubfunciones() != null ) 
      _jspx_page_context.setAttribute("subfunciones", getSubfunciones());
    if( getPanelPrincipal() != null ) 
      _jspx_page_context.setAttribute("panelPrincipal", getPanelPrincipal());
    if( getBotonera() != null ) 
      _jspx_page_context.setAttribute("botonera", getBotonera());
    if( getHead() != null ) 
      _jspx_page_context.setAttribute("head", getHead());

    try {
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>VentaPro - ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nombreFuncionalidad}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"basico.css\" />\r\n");
      out.write("<script src=\"funciones.js\" type=\"text/javascript\"></script>\r\n");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getHead() != null) {
        getHead().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"nombreSucursal\">Sucursal La Loma I</div>\r\n");
      out.write("\t\t<div class=\"nombreUsuario\">\r\n");
      out.write("\t\t\tRodolfo Perez <input type=\"submit\" value=\"Cerrar sesión\"\r\n");
      out.write("\t\t\t\tname=\"btnCerrarSesion\" onclick=\"return false;\"></input>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<form method=\"post\" name=\"form\">\r\n");
      out.write("\t\t<table class=\"principal\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td class=\"funcs funcsSecundarias\">");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getFuncionesSecundarias() != null) {
        getFuncionesSecundarias().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"funcs funcsPrincipales\">");
      if (_jspx_meth_t_005ffuncPrincipal_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_t_005ffuncPrincipal_005f1(_jspx_page_context))
        return;
      if (_jspx_meth_t_005ffuncPrincipal_005f2(_jspx_page_context))
        return;
      if (_jspx_meth_t_005ffuncPrincipal_005f3(_jspx_page_context))
        return;
      if (_jspx_meth_t_005ffuncPrincipal_005f4(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"panelPrincipal\">\r\n");
      out.write("\t\t\t\t\t<div class=\"subFuncs\">\r\n");
      out.write("\t\t\t\t\t\t");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getSubfunciones() != null) {
        getSubfunciones().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"helpText\">\r\n");
      out.write("\t\t\t\t\t\tSi necesita ayuda haga <a\r\n");
      out.write("\t\t\t\t\t\t\thref=\"javascript:abrirPopUp('popupAyudaGenerica.html')\">click\r\n");
      out.write("\t\t\t\t\t\t\taquí</a>\r\n");
      out.write("\t\t\t\t\t</div> ");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getPanelPrincipal() != null) {
        getPanelPrincipal().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" class=\"separador\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td class=\"botonera\">");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getBotonera() != null) {
        getBotonera().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      jspContext.getELContext().putContext(JspContext.class,super.getJspContext());
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }

  private boolean _jspx_meth_t_005ffuncPrincipal_005f0(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:funcPrincipal
    org.apache.jsp.tag.web.funcPrincipal_tag _jspx_th_t_005ffuncPrincipal_005f0 = new org.apache.jsp.tag.web.funcPrincipal_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f0);
    _jspx_th_t_005ffuncPrincipal_005f0.setJspContext(_jspx_page_context);
    _jspx_th_t_005ffuncPrincipal_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/pagina.tag(46,39) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f0.setPagina("buscarProducto.jsp");
    // /WEB-INF/tags/templates/pagina.tag(46,39) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f0.setNombre("Gestión de productos");
    // /WEB-INF/tags/templates/pagina.tag(46,39) name = activa type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f0.setActiva((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${funcPriProductosActiva}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
    _jspx_th_t_005ffuncPrincipal_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005ffuncPrincipal_005f1(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:funcPrincipal
    org.apache.jsp.tag.web.funcPrincipal_tag _jspx_th_t_005ffuncPrincipal_005f1 = new org.apache.jsp.tag.web.funcPrincipal_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f1);
    _jspx_th_t_005ffuncPrincipal_005f1.setJspContext(_jspx_page_context);
    _jspx_th_t_005ffuncPrincipal_005f1.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/pagina.tag(48,44) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f1.setPagina("generarOrden.jsp");
    // /WEB-INF/tags/templates/pagina.tag(48,44) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f1.setNombre("Ventas");
    // /WEB-INF/tags/templates/pagina.tag(48,44) name = activa type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f1.setActiva((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${funcPriVentasActiva}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
    _jspx_th_t_005ffuncPrincipal_005f1.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f1);
    return false;
  }

  private boolean _jspx_meth_t_005ffuncPrincipal_005f2(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:funcPrincipal
    org.apache.jsp.tag.web.funcPrincipal_tag _jspx_th_t_005ffuncPrincipal_005f2 = new org.apache.jsp.tag.web.funcPrincipal_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f2);
    _jspx_th_t_005ffuncPrincipal_005f2.setJspContext(_jspx_page_context);
    _jspx_th_t_005ffuncPrincipal_005f2.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/pagina.tag(50,41) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f2.setPagina("buscarCliente.jsp");
    // /WEB-INF/tags/templates/pagina.tag(50,41) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f2.setNombre("Administración de clientes");
    // /WEB-INF/tags/templates/pagina.tag(50,41) name = activa type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f2.setActiva((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${funcPriClientesActiva}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
    _jspx_th_t_005ffuncPrincipal_005f2.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f2);
    return false;
  }

  private boolean _jspx_meth_t_005ffuncPrincipal_005f3(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:funcPrincipal
    org.apache.jsp.tag.web.funcPrincipal_tag _jspx_th_t_005ffuncPrincipal_005f3 = new org.apache.jsp.tag.web.funcPrincipal_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f3);
    _jspx_th_t_005ffuncPrincipal_005f3.setJspContext(_jspx_page_context);
    _jspx_th_t_005ffuncPrincipal_005f3.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/pagina.tag(52,43) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f3.setPagina("reporteBajoStock.jsp");
    // /WEB-INF/tags/templates/pagina.tag(52,43) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f3.setNombre("Reportes");
    // /WEB-INF/tags/templates/pagina.tag(52,43) name = activa type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f3.setActiva((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${funcPriReportesActiva}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
    _jspx_th_t_005ffuncPrincipal_005f3.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f3);
    return false;
  }

  private boolean _jspx_meth_t_005ffuncPrincipal_005f4(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:funcPrincipal
    org.apache.jsp.tag.web.funcPrincipal_tag _jspx_th_t_005ffuncPrincipal_005f4 = new org.apache.jsp.tag.web.funcPrincipal_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f4);
    _jspx_th_t_005ffuncPrincipal_005f4.setJspContext(_jspx_page_context);
    _jspx_th_t_005ffuncPrincipal_005f4.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/pagina.tag(54,43) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f4.setPagina("#");
    // /WEB-INF/tags/templates/pagina.tag(54,43) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncPrincipal_005f4.setNombre("Administración de usuarios");
    _jspx_th_t_005ffuncPrincipal_005f4.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005ffuncPrincipal_005f4);
    return false;
  }
}
