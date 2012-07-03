package org.apache.jsp.tag.web.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class paginaProductosMarca_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(6);
    _jspx_dependants.add("/WEB-INF/funciones.tld");
    _jspx_dependants.add("/WEB-INF/tags/templates/paginaProductos.tag");
    _jspx_dependants.add("/WEB-INF/tags/templates/pagina.tag");
    _jspx_dependants.add("/WEB-INF/tags/funcPrincipal.tag");
    _jspx_dependants.add("/WEB-INF/tags/funcSecundaria.tag");
    _jspx_dependants.add("/WEB-INF/tags/subfuncion.tag");
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
    if( getPanelPrincipal() != null ) 
      _jspx_page_context.setAttribute("panelPrincipal", getPanelPrincipal());
    if( getBotonera() != null ) 
      _jspx_page_context.setAttribute("botonera", getBotonera());
    if( getHead() != null ) 
      _jspx_page_context.setAttribute("head", getHead());

    try {
      if (_jspx_meth_templates_005fpaginaProductos_005f0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_templates_005fpaginaProductos_005f0(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  templates:paginaProductos
    org.apache.jsp.tag.web.templates.paginaProductos_tag _jspx_th_templates_005fpaginaProductos_005f0 = new org.apache.jsp.tag.web.templates.paginaProductos_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_templates_005fpaginaProductos_005f0);
    _jspx_th_templates_005fpaginaProductos_005f0.setJspContext(_jspx_page_context);
    _jspx_th_templates_005fpaginaProductos_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) name = nombreFuncionalidad type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpaginaProductos_005f0.setNombreFuncionalidad((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nombreFuncionalidad}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) name = funcSecMarcaActiva type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpaginaProductos_005f0.setFuncSecMarcaActiva("true");
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) name = paginaBuscar type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpaginaProductos_005f0.setPaginaBuscar("buscarMarca.jsp");
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) name = paginaAgregar type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpaginaProductos_005f0.setPaginaAgregar("agregarMarca.jsp");
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) name = paginaModificar type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpaginaProductos_005f0.setPaginaModificar("modificarMarca.jsp");
    javax.servlet.jsp.tagext.JspFragment _jspx_temp0 = new Helper( 0, _jspx_page_context, _jspx_th_templates_005fpaginaProductos_005f0, null);
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) null
    _jspx_th_templates_005fpaginaProductos_005f0.setHead(_jspx_temp0);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp1 = new Helper( 1, _jspx_page_context, _jspx_th_templates_005fpaginaProductos_005f0, null);
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) null
    _jspx_th_templates_005fpaginaProductos_005f0.setPanelPrincipal(_jspx_temp1);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp2 = new Helper( 2, _jspx_page_context, _jspx_th_templates_005fpaginaProductos_005f0, null);
    // /WEB-INF/tags/templates/paginaProductosMarca.tag(11,0) null
    _jspx_th_templates_005fpaginaProductos_005f0.setBotonera(_jspx_temp2);
    _jspx_th_templates_005fpaginaProductos_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_templates_005fpaginaProductos_005f0);
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getHead() != null) {
        getHead().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getPanelPrincipal() != null) {
        getPanelPrincipal().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      return false;
    }
    public boolean invoke2( JspWriter out ) 
      throws Throwable
    {
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getBotonera() != null) {
        getBotonera().invoke(_jspx_sout);
      }
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        this.jspContext.getELContext().putContext(JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
          case 2:
            invoke2( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
