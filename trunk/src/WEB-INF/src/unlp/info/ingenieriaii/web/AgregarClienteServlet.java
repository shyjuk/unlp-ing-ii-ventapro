package unlp.info.ingenieriaii.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.modelo.Errores;
import unlp.info.ingenieriaii.modelo.Cliente;

public class AgregarClienteServlet extends ServletPagina {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7564921845475183016L;

	@Override
	protected void procesarGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		req.setAttribute("Cliente", new Cliente());

		super.procesarGet(req, resp);
	}

	@Override
	protected void procesarPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		if (req.getParameter("btnAceptar") != null) {
			Cliente cliente = new Cliente();
			Errores errores;

			cliente.setNombre(req.getParameter("nombre"));
			cliente.setNombre(req.getParameter("apellido"));
			cliente.setNroDocumento(req.getParameter("nroDocumento"));
			cliente.setTipoDocumento(req.getParameter("tipoDocumento"));
			cliente.setTelefono(req.getParameter("telefono"));
			cliente.setEmail(req.getParameter("email"));
			//cliente.setDireccion(req.getParameter("direccion"));			
			//cliente.setLocalidad(req.getParameter("localidad"));			
			//cliente.setProvincia(req.getParameter("provincia"));
				
			errores = cliente.guardar();

			if (errores.esVacio()) {

				resp.sendRedirect("buscarCliente.jsp");
			} else {

				req.setAttribute("cliente", cliente);
				req.setAttribute("errores", errores);
				super.procesarPost(req, resp);
			}
		} else
			resp.sendRedirect("buscarCliente.jsp");
	}
}
