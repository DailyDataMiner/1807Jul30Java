package com.revature.service;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;
import com.revature.models.UserInformation;

public class UserService {
	
	private static UserDao userDao = UserDaoImpl.getInstance();
	
	//1. Read the request body (JSON), and set it to the 'json' string variable
	//2. Using the ObjectMapper map the json into an object of type User
	//3. Perform rest of logic that requires a User POJO
	public static UserInformation login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {			
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			System.out.println("io exception");
		}
		if(user!=null) {
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInformation(user.getUsername());
		}
		return null;
	}
}
