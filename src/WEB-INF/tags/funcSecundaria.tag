<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="/WEB-INF/funciones.tld" prefix="f"%>
<%@ attribute name="pagina" required="true"%>
<%@ attribute name="nombre" required="true"%>
<%@ attribute name="activa" required="false"%>
<a class="func ${activa ? 'funcAct' : ''}" href="${pagina}">${nombre}</a>