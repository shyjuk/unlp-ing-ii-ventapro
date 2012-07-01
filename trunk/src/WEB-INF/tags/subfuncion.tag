<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ attribute name="pagina" required="true"%>
<%@ attribute name="nombre" required="true"%>
<a class="subFunc ${f:esPaginaActual(pageContext, pagina) ? 'subFuncAct' : ''}" href="${pagina}">${nombre}</a>