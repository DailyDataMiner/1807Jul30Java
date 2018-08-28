package Services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAOs.UserDAO;
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
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
	public static User getByUsername(String name) {
		List<User> users = uDao.findAll();
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
	
	public static User login(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("reached here 3");
		User u = null;
		User i = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			i = mapper.readValue(req.getReader(), User.class);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		String iusername = i.getUsername();
		String ipassword = i.getPassword();
		
		if (getUsername(iusername) != null) {
			u = getByUsername(iusername);
			System.out.println("reached here 4");
			if (u.getPassword().equals(ipassword)) {
				System.out.println(u);
				return u;
			}
			else {
				return getUsername(iusername);
			}
		}
		return null;
	}
	
	public static User userUpdateUser(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("reached here 3");
		User i = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			i = mapper.readValue(req.getReader(), User.class);
			System.out.println(i);
			}
			catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		User a = getOne(i.getUserID());
		updateUsername(a, i.getUsername());
		updateName(a, i.getFirstname(), i.getLastname());
		updateEmail(a, i.getEmail());
		
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
}
