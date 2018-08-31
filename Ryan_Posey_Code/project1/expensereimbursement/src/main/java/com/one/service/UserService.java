package com.one.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.dao.UserDao;
import com.one.pojos.User;

public class UserService {
	private static UserDao uDao = new UserDao();
	
	public static User login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		
		User user = null;
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		User authorized = uDao.findOne(user.getUsername());
		System.out.println(authorized.toString());
		if (user.getPassword().equals(authorized.getPassword()))
			return uDao.findOne(user.getUsername());
		return null;
	}
}
