package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Cliente;
import unlp.info.ingenieriaii.modelo.Localidad;

public class AgregarClienteServlet extends ServletPagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7564921845475183016L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		req.setAttribute("Cliente", new Cliente());
		req.setAttribute("localidades", Localidad.buscarLocalidad(null));

		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		req.setAttribute("localidadNueva", req.getParameter("localidadNueva"));

		if (req.getParameter("btnAceptar") != null) {
			Cliente cliente = new Cliente();
			String localidad = req.getParameter("localidad");
			Errores errores;

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
