package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;

/**
 * User service handles the logic for users
 * 
 * @author Arthur Panlilio
 *
 */
public class UserService {
	
	//Is the userDAO
	static UserDAO uDao = new UserDAO();
	//Is the current user logged in
	private User currentUser = null;
	
	/**
	 * Gets all users
	 * 
	 * @return a list of usess
	 */
	public List<User> getAll(){
		return uDao.findAll();
	}
	
	/**
	 * Gets one specific user
	 * 
	 * @param uName is the username
	 * @return a user
	 */
	public User getOne(String uName) {
		return uDao.findOne(uName);
	}
	
	/**
	 * Adds a user to the database
	 * 
	 * @param u is the user to be added to the database
	 * @return a user for verification
	 */
	public User save(User u) {
		return uDao.save(u);
	}
	
	/**
	 * Checks is the user already exists
	 * 
	 * @param u is the user to be checked
	 * @return an int for show what happened
	 */
	public int registrationCheck(User u) {
		int reg = 0;
		if(uDao.findOne(u.getUserName()) != null) {
			reg = 1;//user name already exists
		} else if(uDao.save(u).getId() > 0) {//user registered successfully
			uDao.save(u);
			reg = 2;
		}
		return reg;
	}
	
	/**
	 * Checks if the user login is correct
	 * 
	 * @param un is the username to find
	 * @param pw is the password to check
	 * @return and int that represent what to relay back to interface,
	 *  0 = username not found
	 *  1 = password incorrect
	 *  2 = login succesful
	 */
	public int loginCheck(String un, String pw) {
		int login = 0;
		User user = uDao.findOne(un);
		if(user != null) {
			if(user.getPassword().equals(pw)) {
				login = 2;
			} else {
				login = 1;
			}
		}
		return login;
	}
	
	/**
	 * Sets the current user
	 * 
	 * @param u is the user
	 */
	public void setCurrentUser(User u) {
		currentUser = u;
	}
	
	/**
	 * Gets current user
	 * 
	 * @return the current user
	 */
	public User getCurrentUser() {
		User temp = null;
		if(currentUser != null) {
			temp = currentUser;
		}
		return temp;
	}

}
