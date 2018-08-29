package com.ers.dao;

public interface UserDao<User> {

	String getUserPW_hash(User obj);
	User getUserInfo(String username);
	
}
