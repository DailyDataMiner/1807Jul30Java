package com.ex.dao;

import com.ex.model.User;
import com.ex.model.UserInfo;

public interface UserDao {

	User getUser(String username);
	String getPasswordHash(User user);
	UserInfo getUserInfo(String username);
	
}
