package services;

import java.util.List;

import DAO.UserDAO;
import beans.User;
import beans.UserRole;
import exceptions.InvalidCredentialsException;
import exceptions.NoPermissionException;
import exceptions.NoSuchUserException;
import exceptions.UsernameTakenException;
import utils.Password;

public class UserService {
	private UserDAO userDAO;

	public UserService() {
		if (this.userDAO == null) {
			this.userDAO = new UserDAO();
		}
	}

	public boolean createUser(User user) throws UsernameTakenException {
		if (userDAO.findByUsername(user.getUsername()) != null) {
			throw new UsernameTakenException(user.getUsername());
		}

		return userDAO.insert(user);
	}

	public User login(String username, String password) throws NoSuchUserException, InvalidCredentialsException {
		User user = userDAO.findByUsername(username);
		if (user == null) {
			throw new NoSuchUserException(username);
		}
		if (!Password.validatePassword(password, user.getPwdHash(), user.getPwdSalt())) {
			throw new InvalidCredentialsException("wrong login information");
		}
		return user;
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	public User findOne(int id) {
		return userDAO.findOne(id);
	}
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public boolean update(User user) {
		return userDAO.update(user);
	}

	public boolean delete(User user) {
		return userDAO.delete(user);
	}
}
