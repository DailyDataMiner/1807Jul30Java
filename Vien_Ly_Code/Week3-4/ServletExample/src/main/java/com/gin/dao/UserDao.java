package com.gin.dao;

import com.gin.models.User;
import com.gin.models.UserInformation;

public interface UserDao {
	User getUser(String username);
	String getPasswordHash(User user);
	UserInformation getUserInformation(String user);	
}
