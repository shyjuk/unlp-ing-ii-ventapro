package org.apache.jsp.WEB_002dINF.paginas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buscarTipoProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/WEB-INF/tags/templates/paginaProductosTipoProducto.tag");
    _jspx_dependants.add("/WEB-INF/funciones.tld");
    _jspx_dependants.add("/WEB-INF/tags/templates/paginaProductos.tag");
    _jspx_dependants.add("/WEB-INF/tags/templates/pagina.tag");
    _jspx_dependants.add("/WEB-INF/tags/funcPrincipal.tag");
    _jspx_dependants.add("/WEB-INF/tags/funcSecundaria.tag");
    _jspx_dependants.add("/WEB-INF/tags/subfuncion.tag");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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

      if (_jspx_meth_templates_005fpaginaProductosTipoProducto_005f0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_templates_005fpaginaProductosTipoProducto_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  templates:paginaProductosTipoProducto
    org.apache.jsp.tag.web.templates.paginaProductosTipoProducto_tag _jspx_th_templates_005fpaginaProductosTipoProducto_005f0 = new org.apache.jsp.tag.web.templates.paginaProductosTipoProducto_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_templates_005fpaginaProductosTipoProducto_005f0);
    _jspx_th_templates_005fpaginaProductosTipoProducto_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(6,0) name = nombreFuncionalidad type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_templates_005fpaginaProductosTipoProducto_005f0.setNombreFuncionalidad("Buscar Marca");
    javax.servlet.jsp.tagext.JspFragment _jspx_temp0 = new Helper( 0, _jspx_page_context, _jspx_th_templates_005fpaginaProductosTipoProducto_005f0, null);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(6,0) null
    _jspx_th_templates_005fpaginaProductosTipoProducto_005f0.setHead(_jspx_temp0);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp1 = new Helper( 1, _jspx_page_context, _jspx_th_templates_005fpaginaProductosTipoProducto_005f0, null);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(6,0) null
    _jspx_th_templates_005fpaginaProductosTipoProducto_005f0.setPanelPrincipal(_jspx_temp1);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp2 = new Helper( 2, _jspx_page_context, _jspx_th_templates_005fpaginaProductosTipoProducto_005f0, null);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(6,0) null
    _jspx_th_templates_005fpaginaProductosTipoProducto_005f0.setBotonera(_jspx_temp2);
    _jspx_th_templates_005fpaginaProductosTipoProducto_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_templates_005fpaginaProductosTipoProducto_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    // /WEB-INF/paginas/buscarTipoProducto.jsp(34,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty errores.campo.nombre}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div class=\"errorEntrada\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errores.campo.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    // /WEB-INF/paginas/buscarTipoProducto.jsp(56,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/paginas/buscarTipoProducto.jsp(56,7) '${buscador.resultado}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${buscador.resultado}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/paginas/buscarTipoProducto.jsp(56,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("tipoProducto");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<td style=\"border: 1px solid #CCC\"><input type=\"checkbox\"\r\n");
          out.write("\t\t\t\t\t\t\tname=\"seleccionados_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tipoProducto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"\r\n");
          out.write("\t\t\t\t\t\t\tid=\"seleccionados_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tipoProducto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" value=\"FALSE\"\r\n");
          out.write("\t\t\t\t\t\t\tonclick=\"javascript:changeSelection(this);\" /></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<td style=\"padding-left: 1em; border: 1px solid #CCC\">");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<td style=\"padding-left: 1em; border: 1px solid #CCC\">");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"border: 1px solid #CCC\"><img\r\n");
          out.write("\t\t\t\t\t\t\tsrc=\"imagenes/iconos/edit.gif\"\r\n");
          out.write("\t\t\t\t\t\t\tonclick=\"javascript:editObject('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tipoProducto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\"\r\n");
          out.write("\t\t\t\t\t\t\talt=\"Editar\" style=\"margin-right: 8px\" /> <img\r\n");
          out.write("\t\t\t\t\t\t\tsrc=\"imagenes/iconos/button_delete.gif\"\r\n");
          out.write("\t\t\t\t\t\t\tonclick=\"javascript:deleteObject('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tipoProducto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\"\r\n");
          out.write("\t\t\t\t\t\t\talt=\"Borrar\" /></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        throw new SkipPageException();
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(62,63) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tipoProducto.nombre}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(64,63) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tipoProducto.descripcion}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    // /WEB-INF/paginas/buscarTipoProducto.jsp(76,17) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty errores.general}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div class=\"errorEntrada\" style=\"text-align: center; margin: 2em;\">\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("</div>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(78,7) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errores.general}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    // /WEB-INF/paginas/buscarTipoProducto.jsp(80,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty erroresEliminar.general}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div class=\"errorEntrada\" style=\"text-align: center; margin: 2em;\">\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("</div>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /WEB-INF/paginas/buscarTipoProducto.jsp(82,7) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${erroresEliminar.general}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction deleteObject(idObject) {\r\n");
      out.write("\t\tif (confirm(\"¿Esta seguro que desea borrarlo?\")) {\r\n");
      out.write("\t\t\tdocument.form.id.value = idObject;\r\n");
      out.write("\t\t\tdocument.form.accion.value = 'borrar';\r\n");
      out.write("\t\t\tdocument.form.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction editObject(idObject) {\r\n");
      out.write("\t\tdocument.form.id.value = idObject;\r\n");
      out.write("\t\tdocument.form.action = \"modificarTipoProducto.jsp\";\r\n");
      out.write("\t\tdocument.form.accion.value = 'editar';\r\n");
      out.write("\t\tdocument.form.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>");
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      out.write("<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"labelForm\">Nombre:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"nombre\" id=\"nombre\" size=\"50\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buscador.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /> * <input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Buscar\" name=\"btnAceptar\" />\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_parent, _jspx_page_context))
        return true;
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" class=\"separador\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t<legend>Resultado de la búsqueda</legend>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"100%\" style=\"border-collapse: collapse;\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr style=\"background-color: #4AA; color: White;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width: 15px; text-align: center; border: 1px solid #CCC\"><input\r\n");
      out.write("\t\t\t\t\t\ttype=\"checkbox\" name=\"seleccionados_TODOS\" value=\"FALSE\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"javascript:changeAllSelection(this,");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${listaId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(");\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width: 250px; text-align: center; border: 1px solid #CCC\">Nombre</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align: center; border: 1px solid #CCC\">Descripción</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 100px; border: 1px solid #CCC\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_parent, _jspx_page_context))
        return true;
      out.write("</table>\r\n");
      out.write("\t\t\t\t\t</fieldset> ");
      if (_jspx_meth_c_005fif_005f1(_jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_c_005fif_005f2(_jspx_parent, _jspx_page_context))
        return true;
      out.write("<input type=\"hidden\" name=\"id\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"accion\" value=\"\" />");
      return false;
    }
    public boolean invoke2( JspWriter out ) 
      throws Throwable
    {
      out.write("<input type=\"submit\" value=\"Aceptar\" name=\"btnAceptar\" /> \r\n");
      out.write("\t\t<input type=\"submit\" value=\"Borrar\" name=\"btnBorrar\"\r\n");
      out.write("\t\t\tonclick=\"return algunoCheckeado(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${listaId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(") && confirm('¿Esta seguro que desea borrar los tipos de producto seleccionados?')\" />");
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
