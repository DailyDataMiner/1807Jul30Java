package com.rev.dao;

import com.rev.models.User;
import com.rev.models.UserInformation;

public interface UserDao {

	User getUser(String username);
	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	
}
