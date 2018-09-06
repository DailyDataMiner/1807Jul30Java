package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS-Application/login.ng":
			return UserService.login(request, response);
		
		default:
			return "not yet implemented";
		}
	}
}