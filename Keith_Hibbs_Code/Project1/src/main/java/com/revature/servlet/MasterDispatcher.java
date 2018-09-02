package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Project1/login.ng":
			return UserService.login(request, response);
		
		default:
			return "Path is messed up";
		}
	}
}