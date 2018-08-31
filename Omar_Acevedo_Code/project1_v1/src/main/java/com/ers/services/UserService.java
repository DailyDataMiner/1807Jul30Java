package com.ers.services;

import java.util.List;

import com.ers.dao.UserDaoImplementation;
import com.ers.pojos.User;

public class UserService extends UserDaoImplementation {
	
	public String getHashValue(User usrObj) {
		return getUserPW_hash(usrObj);
	}
	
	public User getUser(String username) {
		return getUserInfo(username);
	}
	
	public List<User> getAllUsers() {
		return getUsers();
	}
}
