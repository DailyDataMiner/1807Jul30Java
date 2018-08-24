package com.gin.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gin.dao.UserDao;
import com.gin.dao.UserDaoImpl;
import com.gin.models.User;
import com.gin.models.UserInformation;

public class UserService {
	private static UserDao userDao = new UserDaoImpl();

	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
			return userDao.getUserInformation(user.getUsername());
		}
		return null;
	}
}
