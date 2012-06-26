<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ attribute name="nombreEntidadParaTitulo" required="true"%>
<%@ attribute name="subfuncion" required="true" fragment="true" %>
<%@ attribute name="panelPrincipal" required="true" fragment="true"%>
<%@ attribute name="mensajeConfirmacion" required="true"%>
<%@ attribute name="funcSecundaria" required="true"%>
<t:paginaProductos nombreFuncionalidad="Buscar ${nombreEntidadParaTitulo}">
	<jsp:attribute name="head">
		<script type="text/javascript">
			function deleteObject(idObject) {
				if (confirm("¿Esta seguro que desea borrarlo?")) {
					var form = document.forms['frmPrincipal'];

					form.id.value = idObject;
					form.accion.value = 'borrar';
					form.submit();
				}
			}

			function editObject(idObject) {
				var form = document.forms['frmPrincipal'];

				form.id.value = idObject;
				form.action = "${jspModificar}";
				form.accion.value = 'editar';
				form.submit();
			}

			function mostrarDetalles(idObject) {
				document.getElementById('detalles_' + idObject).className = "";
				document.getElementById('mas_' + idObject).className = "oculto";
				document.getElementById('menos_' + idObject).className = "";
			}

			function ocultarDetalles(idObject) {
				document.getElementById('detalles_' + idObject).className = "oculto";
				document.getElementById('mas_' + idObject).className = "";
				document.getElementById('menos_' + idObject).className = "oculto";
			}
		</script>
</jsp:attribute>

	<jsp:attribute name="subfunciones">
		<a class="subFunc subFuncAct" href="#">Buscar</a> 
		<a class="subFunc" href="agregarMarca.jsp">Agregar</a>
	</jsp:attribute>

	<jsp:attribute name="panelPrincipal">
		<jsp:invoke	fragment="panelPrincipal" />
	</jsp:attribute>
	
	<jsp:attribute name="botonera">
		<input type="submit" value="Aceptar" name="btnAceptar" />
		<input type="submit" value="Borrar" name="btnBorrar"
			onclick="return confirm('${mensajeConfirmacion}')" />
	</jsp:attribute>
	
	
	<jsp:attribute name="funcSecundaria">${funcSecundaria}</jsp:attribute>
</t:paginaProductos>