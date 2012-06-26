package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Cliente;
import unlp.info.ingenieriaii.modelo.Localidad;

public class ModificarClienteServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8652155285922932186L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("buscarCliente.jsp");
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException,
			SQLException {
		Cliente cliente = new Cliente();
		Errores errores;

		cliente.setId(Utiles.esVacio(req.getParameter("id")) ? null : Integer
				.parseInt(req.getParameter("id")));

		if ("editar".equals(req.getParameter("accion"))) {

			errores = cliente.recuperar();
			req.setAttribute("cliente", cliente);
			req.setAttribute("localidades", Localidad.buscarLocalidad(null));
			req.setAttribute("errores", errores);
			super.procesarPost(req, resp);
		} else if (req.getParameter("btnAceptar") != null) {
			String localidad = req.getParameter("localidad");

			cliente.setNombre(req.getParameter("nombre"));
			cliente.setApellido(req.getParameter("apellido"));
			cliente.setNroDocumento(req.getParameter("nroDocumento"));
			cliente.setTelefono(req.getParameter("telefono"));
			cliente.setCelular(req.getParameter("celular"));
			cliente.setEmail(req.getParameter("email"));

			cliente.setCalle(req.getParameter("calle"));
			cliente.setNumeroCalle(req.getParameter("numeroCalle"));
			cliente.setDpto(req.getParameter("dpto"));
			cliente.setLocalidad(!Utiles.esVacio(localidad) ? localidad : req
					.getParameter("localidadNueva"));

			errores = cliente.guardar();

			if (errores.esVacio()) {

				resp.sendRedirect("buscarCliente.jsp");
			} else {

				req.setAttribute("cliente", cliente);
				req.setAttribute("localidades", Localidad.buscarLocalidad(null));				
				req.setAttribute("errores", errores);
				super.procesarPost(req, resp);
			}
		} else
			resp.sendRedirect("buscarCliente.jsp");

	}
}
