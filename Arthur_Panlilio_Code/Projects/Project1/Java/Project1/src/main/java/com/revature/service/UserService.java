package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;

public class UserService {
	
	private UserDAO uDao = new UserDAO();
	
	public List<User> getAll(){
		List<User> users =  uDao.findAll();
		for(User u : users) {
			u.setRole(getRole(u));
		}
		return users;
	}
	
	public User find(String username) {
		User u = uDao.findOne(username);
		if(u!=null)
			u.setRole(getRole(u));
		return u;
	}
	
	public boolean checkLogin(String username, String password) {
		User u = uDao.findOne(username);
		return u.getPassword().equals(password);
	}
	
	public String getRole(User u) {
		if(u!=null) {
		return uDao.findRole(u.getRoleId());
		} else {
			return "";
		}
	}
	
	public User addUser(User u) {
		return uDao.save(u);
	}

}
