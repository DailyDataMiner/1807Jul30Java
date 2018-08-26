package com.ex.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("From the MasterDispatcher: " + request.getRequestURI());
		
		switch (request.getRequestURI()) {
			
			case "/ServletsExample/login.ng":
				return UserService.login(request, response);
		
			default:
				return "not yet implemented";
		
		}
		
	}
	
}
