package Services;

import java.util.List;

import DAOs.UserDAO;
import POJOs.User;

public class UserService {

	static UserDAO uDao = new UserDAO();
	

	public List<User> getAll() {
		return uDao.findAll();
	}
	public User getOne(int input) {
		return uDao.findOne(input);
	}
	public User saveUser(User a) {
		return uDao.save(a);
	}
	public void deleteUser(User a) {
		uDao.delete(a);
	}
	public User getByUsername(String name) {
		List<User> users = uDao.findAll();
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
	
	public User updateUsername(User a, String iusername) {
		iusername = iusername.toLowerCase();
		if (getByUsername(iusername) != null || iusername.equals("")) {
			return null;
		}
		a.setUsername(iusername);
		return uDao.updateUsername(a);
	}
	public User updatePassword(User a, String ipassword) {
		if (ipassword.equals("")) {
			return null;
		}
		a.setPassword(ipassword);
		return uDao.updatePassword(a);
	}
	public User updateEmail(User a, String iemail) {
		a.setEmail(iemail);
		return uDao.updateEmail(a);
	}
	public User updateName(User a, String ifirstname, String ilastname) {
		a.setFirstname(ifirstname);
		a.setLastname(ilastname);
		return uDao.updateUsername(a);
	}
}
