package com.revature.project0.service;

import java.util.List;

import com.revature.project0.dao.UserDAO;
import com.revature.project0.myexceptions.InvalidUsernameException;
import com.revature.project0.myexceptions.UsernameTakenException;
import com.revature.project0.projectobjects.User;

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
	public User updateUsername(User a, String iusername) throws UsernameTakenException, InvalidUsernameException {
		iusername = iusername.toLowerCase();
		newUsername(iusername);
		a.setUsername(iusername);
		return uDao.updateUsername(a);
	}
	
	public boolean newUsername(String newUsername) throws UsernameTakenException, InvalidUsernameException {
		newUsername = newUsername.toLowerCase();
		if (newUsername.equals("") || newUsername.equals("return")) {
			throw new InvalidUsernameException();
		}
		List<User> users = getAll();
		for (User user : users) {
			if (user.getUsername().equals(newUsername)) {
				throw new UsernameTakenException();
			}
		}
		return true;
	}
	
	public User updatePassword(User a, String ipassword) {
		a.setPassword(ipassword);
		return uDao.updatePassword(a);
	}
	public User updateName(User a, String ifirstname, String ilastname) {
		a.setFirstName(ifirstname);
		a.setLastName(ilastname);
		return uDao.updateName(a);
	}
	public User login(String iusername, String ipassword) {
		List<User> users = getAll();
		User chosenUser = null;
		for (User user : users) {
			if (user.getUsername().equals(iusername.toLowerCase())) {
				chosenUser = user;
				break;
			}
		}
		if (chosenUser != null && chosenUser.getPassword().equals(ipassword)) {
			return chosenUser;
		}
		return null;
	}
	public User createUser(String iusername, String ipassword, String ifirstname, String ilastname) 
			throws UsernameTakenException, InvalidUsernameException  {
		newUsername(iusername);
		User newUser = new User(iusername.toLowerCase(), ipassword, ifirstname, ilastname);
		saveUser(newUser);
		return newUser;
	}
}
