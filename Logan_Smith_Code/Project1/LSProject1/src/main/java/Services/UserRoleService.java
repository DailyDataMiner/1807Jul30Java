package Services;

import java.util.List;

import DAOs.UserRoleDAO;
import POJOs.ReimbType;
import POJOs.UserRole;

public class UserRoleService {

	static UserRoleDAO urDao = new UserRoleDAO();

	public static List<UserRole> getAll() {
		return urDao.findAll();
	}

	public static UserRole getOne(int input) {
		return urDao.findOne(input);
	}
	public static UserRole getByRoleName(String input) {
		return urDao.findByRoleName(input);
	}

	public static UserRole saveReimbType(UserRole a) {
		return urDao.save(a);
	}
	
}
