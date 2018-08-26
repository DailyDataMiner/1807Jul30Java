package com.ex.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.UserDao;
import com.ex.dao.UserDaoImpl;
import com.ex.model.User;
import com.ex.model.UserInformation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {
	
	private static UserDao userDao = UserDaoImpl.getInstance();
	
	
//	public static UserInformation login(User user) {
	public static UserInformation login(HttpServletRequest request, HttpServletResponse response) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		User user = null;
		
		try {
			
//			System.out.println("UserService: UserInformation: request.getInputStream(): " + request.getInputStream());
			
//			BufferedReader br = new BufferedReader(new InputStreamReader( request.getInputStream() ));
			json = "";
//			
//			if (br != null) {
//				System.out.println("inside br");
//				json = br.readLine();
//				System.out.println("json: " + json);
//			} else {
//				System.out.println("else, br is null");
//			}
			
			System.out.println("Before request getReader()");
			System.out.println(request.getReader());
			System.out.println("After request getReader()");
			
//			user = mapper.readValue(json, User.class);
			user = mapper.readValue(request.getReader(), User.class);
			
			System.out.println(user.toString());
			
		} catch (IOException e) {
			
			System.out.println("in io exception");
			e.printStackTrace();
			
		}
		
		
		User authorized = userDao.getUser(user.getUsername());
		
		System.out.println("authorized -> " + authorized);
		
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) 
			return userDao.getUserInformation(user.getUsername());
		
		return null;
		
	}
}
