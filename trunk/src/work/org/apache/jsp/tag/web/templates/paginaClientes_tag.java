package org.apache.jsp.tag.web.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class paginaClientes_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("f:esPaginaActual", unlp.info.ingenieriaii.web.funciones.FuncionesEL.class, "esPaginaActual", new Class[] {javax.servlet.jsp.PageContext.class, java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/WEB-INF/funciones.tld");
    _jspx_dependants.add("/WEB-INF/tags/templates/pagina.tag");
    _jspx_dependants.add("/WEB-INF/tags/funcPrincipal.tag");
    _jspx_dependants.add("/WEB-INF/tags/funcSecundaria.tag");
    _jspx_dependants.add("/WEB-INF/tags/subfuncion.tag");
  }

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(config);
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) config.getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      if (_jspx_meth_templates_005fpagina_005f0(_jspx_page_context))
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
      _jspDestroy();
    }
  }

  private boolean _jspx_meth_templates_005fpagina_005f0(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  templates:pagina
    org.apache.jsp.tag.web.templates.pagina_tag _jspx_th_templates_005fpagina_005f0 = new org.apache.jsp.tag.web.templates.pagina_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_templates_005fpagina_005f0);
    _jspx_th_templates_005fpagina_005f0.setJspContext(_jspx_page_context);
    _jspx_th_templates_005fpagina_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) name = nombreFuncionalidad type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpagina_005f0.setNombreFuncionalidad((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nombreFuncionalidad}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) name = funcPriClientesActiva type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpagina_005f0.setFuncPriClientesActiva("true");
    javax.servlet.jsp.tagext.JspFragment _jspx_temp0 = new Helper( 0, _jspx_page_context, _jspx_th_templates_005fpagina_005f0, null);
    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) null
    _jspx_th_templates_005fpagina_005f0.setHead(_jspx_temp0);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp1 = new Helper( 1, _jspx_page_context, _jspx_th_templates_005fpagina_005f0, null);
    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) null
    _jspx_th_templates_005fpagina_005f0.setFuncionesSecundarias(_jspx_temp1);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp2 = new Helper( 2, _jspx_page_context, _jspx_th_templates_005fpagina_005f0, null);
    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) null
    _jspx_th_templates_005fpagina_005f0.setSubfunciones(_jspx_temp2);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp3 = new Helper( 3, _jspx_page_context, _jspx_th_templates_005fpagina_005f0, null);
    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) null
    _jspx_th_templates_005fpagina_005f0.setPanelPrincipal(_jspx_temp3);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp4 = new Helper( 4, _jspx_page_context, _jspx_th_templates_005fpagina_005f0, null);
    // /WEB-INF/tags/templates/paginaClientes.tag(12,0) null
    _jspx_th_templates_005fpagina_005f0.setBotonera(_jspx_temp4);
    _jspx_th_templates_005fpagina_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_templates_005fpagina_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005ffuncSecundaria_005f0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:funcSecundaria
    org.apache.jsp.tag.web.funcSecundaria_tag _jspx_th_t_005ffuncSecundaria_005f0 = new org.apache.jsp.tag.web.funcSecundaria_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005ffuncSecundaria_005f0);
    _jspx_th_t_005ffuncSecundaria_005f0.setJspContext(_jspx_page_context);
    _jspx_th_t_005ffuncSecundaria_005f0.setParent(_jspx_parent);
    // /WEB-INF/tags/templates/paginaClientes.tag(20,1) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncSecundaria_005f0.setPagina("buscarCliente.jsp");
    // /WEB-INF/tags/templates/paginaClientes.tag(20,1) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncSecundaria_005f0.setNombre("Cliente");
    // /WEB-INF/tags/templates/paginaClientes.tag(20,1) name = activa type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005ffuncSecundaria_005f0.setActiva("true");
    _jspx_th_t_005ffuncSecundaria_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005ffuncSecundaria_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fsubfuncion_005f0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:subfuncion
    org.apache.jsp.tag.web.subfuncion_tag _jspx_th_t_005fsubfuncion_005f0 = new org.apache.jsp.tag.web.subfuncion_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005fsubfuncion_005f0);
    _jspx_th_t_005fsubfuncion_005f0.setJspContext(_jspx_page_context);
    _jspx_th_t_005fsubfuncion_005f0.setParent(_jspx_parent);
    // /WEB-INF/tags/templates/paginaClientes.tag(25,2) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005fsubfuncion_005f0.setPagina("buscarCliente.jsp");
    // /WEB-INF/tags/templates/paginaClientes.tag(25,2) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005fsubfuncion_005f0.setNombre("Buscar");
    _jspx_th_t_005fsubfuncion_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005fsubfuncion_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fsubfuncion_005f1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:subfuncion
    org.apache.jsp.tag.web.subfuncion_tag _jspx_th_t_005fsubfuncion_005f1 = new org.apache.jsp.tag.web.subfuncion_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005fsubfuncion_005f1);
    _jspx_th_t_005fsubfuncion_005f1.setJspContext(_jspx_page_context);
    _jspx_th_t_005fsubfuncion_005f1.setParent(_jspx_parent);
    // /WEB-INF/tags/templates/paginaClientes.tag(26,2) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005fsubfuncion_005f1.setPagina("agregarCliente.jsp");
    // /WEB-INF/tags/templates/paginaClientes.tag(26,2) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005fsubfuncion_005f1.setNombre("Agregar");
    _jspx_th_t_005fsubfuncion_005f1.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005fsubfuncion_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    // /WEB-INF/tags/templates/paginaClientes.tag(27,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${f:esPaginaActual(pageContext, 'modificarCliente.jsp')}", java.lang.Boolean.class, (PageContext)this.getJspContext(), _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_t_005fsubfuncion_005f2(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fsubfuncion_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  t:subfuncion
    org.apache.jsp.tag.web.subfuncion_tag _jspx_th_t_005fsubfuncion_005f2 = new org.apache.jsp.tag.web.subfuncion_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_t_005fsubfuncion_005f2);
    _jspx_th_t_005fsubfuncion_005f2.setJspContext(_jspx_page_context);
    _jspx_th_t_005fsubfuncion_005f2.setParent(_jspx_th_c_005fif_005f0);
    // /WEB-INF/tags/templates/paginaClientes.tag(28,3) name = pagina type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005fsubfuncion_005f2.setPagina("modificarCliente.jsp");
    // /WEB-INF/tags/templates/paginaClientes.tag(28,3) name = nombre type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005fsubfuncion_005f2.setNombre("Modificar");
    _jspx_th_t_005fsubfuncion_005f2.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_t_005fsubfuncion_005f2);
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
      if (_jspx_meth_t_005ffuncSecundaria_005f0(_jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke2( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_t_005fsubfuncion_005f0(_jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_t_005fsubfuncion_005f1(_jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_c_005fif_005f0(_jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke3( JspWriter out ) 
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
    public boolean invoke4( JspWriter out ) 
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
          case 3:
            invoke3( out );
            break;
          case 4:
            invoke4( out );
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
