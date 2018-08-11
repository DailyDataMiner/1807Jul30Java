package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;

public class UserService {
	
	static UserDAO uDao = new UserDAO();
	
	public List<User> getAll(){
		return uDao.findAll();
	}
	
	public User getOne(String uName) {
		return uDao.findOne(uName);
	}
	
	public User save(User u) {
		return uDao.save(u);
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

}
