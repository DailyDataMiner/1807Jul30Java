package com.ers.dao;

import java.util.List;

public interface UserDao<User> {

	String getUserPW_hash(User obj);
	User getUserInfo(String username);
	List<User> getUsers();
	
}
