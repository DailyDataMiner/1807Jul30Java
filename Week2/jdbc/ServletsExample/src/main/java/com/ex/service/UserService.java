package com.ex.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.UserDao;
import com.ex.dao.UserDaoImpl;
import com.ex.model.User;
import com.ex.model.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {

	private static UserDao userDao = UserDaoImpl.getInstance();

	//1. Read the Request body (JSON, and set it to the 'json' String variable
	//2. Using the Object Mapper, map the json into an object of type User
	//3. Perform rest of logic that requires a User POJO
	
	public static UserInfo login(HttpServletRequest req, HttpServletResponse res) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInfo(user.getUsername());
		return null;
	}
}
