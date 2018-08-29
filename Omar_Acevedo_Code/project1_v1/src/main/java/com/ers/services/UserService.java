package com.ers.services;

import com.ers.dao.UserDaoImplementation;
import com.ers.pojos.User;

public class UserService extends UserDaoImplementation {
	
	public String getHashValue(User usrObj) {
		return getUserPW_hash(usrObj);
	}
	
//	public User 
	
}
