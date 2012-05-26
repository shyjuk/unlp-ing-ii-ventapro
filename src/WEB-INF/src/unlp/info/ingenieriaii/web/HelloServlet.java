package unlp.info.ingenieriaii.web;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unlp.info.ingenieriaii.web.ServletPagina;

public class HelloServlet extends ServletPagina {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5612357445861162497L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Postprocess request: gather and validate submitted data and display
		// result in same JSP.

		// Prepare messages.
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		// Get and validate name.
		String name = request.getParameter("name");
		if (name == null || name.trim().isEmpty()) {
			messages.put("name", "Please enter name");
		} else if (!name.matches("\\p{Alnum}+")) {
			messages.put("name", "Please enter alphanumeric characters only");
		}

		// Get and validate age.
		String age = request.getParameter("age");
		if (age == null || age.trim().isEmpty()) {
			messages.put("age", "Please enter age");
		} else if (!age.matches("\\d+")) {
			messages.put("age", "Please enter digits only");
		}

		// No validation errors? Do the business job!
		if (messages.isEmpty()) {
			messages.put("success", String.format(
					"Hello, your name is %s and your age is %s!", name, age));
		}

		super.doPost(request, response);
	}

}
