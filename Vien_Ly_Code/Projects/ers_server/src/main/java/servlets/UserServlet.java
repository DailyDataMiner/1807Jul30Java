package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;
import beans.UserRole;
import exceptions.UsernameTakenException;
import services.UserService;
import servlets.models.UserData;
import utils.Password;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final ObjectMapper mapper = new ObjectMapper();
	private final UserService userService = new UserService();

	// users can only get info on themselves
	// admins can get any user
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");
		String idParam = req.getParameter("id");
		String usernameParam = req.getParameter("username");

		User user = null;

		// attempt to find by id then username, never both
		if (idParam != null) {
			int id = Integer.parseInt(idParam);
			System.out.println(id);
			if (actor.getId() == id || actor.getRole() == UserRole.MANAGER) {
				user = userService.findOne(id);
				System.out.println(user);
			} else {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "unauthorized");
				return;
			}
		} else if (usernameParam != null) {
			System.out.println(actor.getUsername() == usernameParam);
			if (actor.getUsername().equals(usernameParam) || actor.getRole() == UserRole.MANAGER) {
				user = userService.findByUsername(usernameParam);
			} else {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "unauthorized");
				return;
			}
		} else { // get all users, admins only
			if (actor.getRole() == UserRole.MANAGER) {
				List<User> users = userService.findAll();
				resp.setContentType("application/json");
				mapper.writeValue(resp.getWriter(), users);
				return;
			} else {
				resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
				mapper.writeValue(resp.getWriter(), "specify id or username");
				return;
			}
		}

		if (user == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "user not found");
			return;
		}
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), user);
	}

	// only admins
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");
		if (actor.getRole() != UserRole.MANAGER) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "Only admins can register new users");
			return;
		}
		UserService userService = new UserService();
		UserData userData = mapper.readValue(req.getReader(), UserData.class);

		User user = new User(userData.getUsername(), userData.getPassword(), userData.getFirstName(),
				userData.getLastName(), userData.getEmail(), userData.getRole());
		try {
			userService.createUser(user);
			resp.setContentType("application/json");
			mapper.writeValue(resp.getWriter(), user);
		} catch (UsernameTakenException e) {
			resp.setStatus(HttpServletResponse.SC_CONFLICT);
			mapper.writeValue(resp.getWriter(), "username or email taken");
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");
		UserData editData = mapper.readValue(req.getReader(), UserData.class);
		User user = userService.findOne(actor.getId());

		if (user == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "user not found");
			return;
		}

		if (actor.getId() != user.getId() && actor.getRole() != UserRole.MANAGER) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "Not allowed to edit other users");
			return;
		}

		if (editData.getUsername() != null)
			user.setUsername(editData.getUsername());
		if (editData.getFirstName() != null)
			user.setFirstName(editData.getFirstName());
		if (editData.getLastName() != null)
			user.setLastName(editData.getLastName());
		if (editData.getEmail() != null)
			user.setEmail(editData.getEmail());
		if (editData.getPassword() != null) {
			byte[] salt = Password.getSalt();
			user.setPwdSalt(salt);
			user.setPwdHash(Password.getHash(editData.getPassword(), salt));
		}

		if (editData.getRole() != null) {
			if (actor.getRole() != UserRole.MANAGER) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "Cannot edit role");
				return;
			} else {
				user.setRole(editData.getRole());
			}
		}

		userService.update(user);
		session.setAttribute("user", user);
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), user);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");
		String idParam = req.getParameter("id");
		if (idParam == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "user not found");
			return;
		}
		int id = Integer.parseInt(idParam);
		if (actor.getId() != id && actor.getRole() != UserRole.MANAGER) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "what are you doing?");
			return;
		}

		User user = userService.findOne(id);
		if (user == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "user not found");
			return;
		}

		userService.delete(user);
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), user);
	}
}
