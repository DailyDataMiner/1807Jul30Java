package Services;

import java.util.List;

import DAOs.UserRoleDAO;
import POJOs.UserRole;

public class UserRoleService {

	static UserRoleDAO urDao = new UserRoleDAO();

	public List<UserRole> getAll() {
		return urDao.findAll();
	}

	public UserRole getOne(int input) {
		return urDao.findOne(input);
	}

	public UserRole saveReimbType(UserRole a) {
		return urDao.save(a);
	}
	
}
