package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		case "/ServletsExample/login.ng": // if you get this request, 
			return UserService.login(request, response); // return the output of this function
		
		default:
			return "not yet implemented";
		}
		
	}
	
}
