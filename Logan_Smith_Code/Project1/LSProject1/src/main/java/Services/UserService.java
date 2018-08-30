package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAOs.UserDAO;
import Models.UserModel;
import POJOs.User;

public class UserService {

	static UserDAO uDao = new UserDAO();

	public static List<User> getAll() {
		return uDao.findAll();
	}

	public static List<User> getAllByRole(int roleID) {
		return uDao.findAllByRole(roleID);
	}

	public static User getOne(int input) {
		return uDao.findOne(input);
	}

	public static User saveUser(User a) {
		return uDao.save(a);
	}

	public static void deleteUser(User a) {
		uDao.delete(a);
	}

	public static User getUsername(String name) {
		List<User> users = uDao.findAllUsernames();
		User u = users.stream().filter(x -> x.getUsername().equals(name.toLowerCase())).findAny().orElse(null);
		System.out.println(u);
		return u;
	}

	public static User getByUsername(String name) {
		List<User> users = uDao.findAll();
		User u = users.stream().filter(x -> x.getUsername().equals(name.toLowerCase())).findAny().orElse(null);
		return u;
	}

	public static User login(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("reached here 3");
		User u = null;
		User i = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			i = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String iusername = i.getUsername().toLowerCase();
		String ipassword = i.getPassword();

		if (getUsername(iusername) != null) {
			u = getByUsername(iusername);
			System.out.println("reached here 4");
			if (u.getPassword().equals(ipassword)) {
				return u;
			} else {
				System.out.println(u.getPassword());
				return null;
			}
		}
		System.out.println("Huh?");
		return null;
	}

	public static Boolean checkLogin(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("reached here 3");
		User i = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			i = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String iusername = i.getUsername().toLowerCase();
		String ipassword = i.getPassword();
		User u = getByUsername(iusername);
		u = getByUsername(iusername);
		System.out.println("reached here 4");
		if (u.getPassword().equals(ipassword)) {
			System.out.println(u);
			return true;
		} else {
			return null;
		}
	}

	public static User userUpdateUser(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("reached here 3");
		User i = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			i = mapper.readValue(req.getReader(), User.class);
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		User a = getOne(i.getUserID());
		updateUsername(a, i.getUsername());
		updateName(a, i.getFirstname(), i.getLastname());
		updateEmail(a, i.getEmail());
		if (i.getPassword() != null) {
			updatePassword(a, i.getPassword());
		}

		return a;
	}

	public static User updateUsername(User a, String iusername) {
		iusername = iusername.toLowerCase();
		if (getUsername(iusername) != null || iusername.equals("")) {
			return null;
		}
		a.setUsername(iusername);
		return uDao.updateUsername(a);
	}

	public static User updatePassword(User a, String ipassword) {
		if (ipassword.equals("")) {
			return null;
		}
		a.setPassword(ipassword);
		return uDao.updatePassword(a);
	}

	public static User updateEmail(User a, String iemail) {
		a.setEmail(iemail);
		return uDao.updateEmail(a);
	}

	public static User updateName(User a, String ifirstname, String ilastname) {
		a.setFirstname(ifirstname);
		a.setLastname(ilastname);
		return uDao.updateUsername(a);
	}

	public static List<User> getAssociates() {
		System.out.println("reached here 4");
		return getAllByRole(1);
	}

	static public User promoteUser(HttpServletRequest req, HttpServletResponse resp) {
		String input = "";
		try (BufferedReader bf = req.getReader()) {
			input = bf.readLine();
			System.out.println("Input: " + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u = getOne(Integer.parseInt(input));
		u.setUserRole(UserRoleService.getOne(6));
		return uDao.updateUserRole(u);
	}

	static public User addUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("reached here 3");
		UserModel u = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			u = mapper.readValue(req.getReader(), UserModel.class);
			System.out.println(u);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if (getUsername(u.getUsername()) != null) {
			System.out.println("Error occured");
			return null;
		}
		User user = new User();
		user.setUsername(u.getUsername());
		user.setPassword(u.getPassword());
		user.setEmail(u.getEmail());
		user.setUserRole(UserRoleService.getByRoleName(u.getUserRole()));
		System.out.println(user.getUserRole());
		return saveUser(user);
	}
}
