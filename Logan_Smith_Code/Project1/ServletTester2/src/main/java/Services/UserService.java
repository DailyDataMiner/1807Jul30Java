package Services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAOs.UserDAO;
import DAOs.UserDAOImpl;
import POJOs.User;
import POJOs.UserInformation;

public class UserService {

	private static UserDAO userDao = UserDAOImpl.getInstance();
	
	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
		user = mapper.readValue(req.getReader(), User.class);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		User authorized = userDao.getUser(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(authorized.getPassword());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
			System.out.println("Broken");
			return userDao.getUserInformation(user.getUsername());
		}
		return null;
	}
	
}
