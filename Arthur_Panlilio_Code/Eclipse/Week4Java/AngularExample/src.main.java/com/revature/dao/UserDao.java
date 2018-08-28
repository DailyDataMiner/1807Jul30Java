package com.revature.dao;

import com.revature.models.User;
import com.revature.models.UserInformation;

public interface UserDao {
	
	User getUser(String username);
	
	String getPasswordHash(User user);
	
	UserInformation getUserInformation(String username);

}
