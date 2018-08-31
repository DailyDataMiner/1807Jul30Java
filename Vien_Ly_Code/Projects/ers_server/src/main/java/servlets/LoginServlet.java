package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;
import exceptions.InvalidCredentialsException;
import exceptions.NoSuchUserException;
import services.UserService;
import servlets.models.Credentials;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = null;
		if (session == null || (user = (User) session.getAttribute("user")) == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "not found");
			return;
		}
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), user);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Credentials credentials = mapper.readValue(req.getReader(), Credentials.class);
		UserService userService = new UserService();
		User user = null;
		try {
			user = userService.login(credentials.getUsername(), credentials.getPassword());
			req.getSession().setAttribute("user", user);
			resp.setContentType("application/json");
			mapper.writeValue(resp.getWriter(), user);
		} catch (NoSuchUserException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "not found");
			return;
		} catch (InvalidCredentialsException e) {
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			mapper.writeValue(resp.getWriter(), "invalid credentials");
			return;
		}
	}
}
