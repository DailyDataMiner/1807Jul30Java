package com.ex.dao;

import com.ex.model.User;
import com.ex.model.UserInformation;

public interface UserDao {

	User			getUser(String username);
	String 			getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	
}
