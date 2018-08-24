package com.gin.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gin.services.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {

	}

	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
		case "/ServletExample/login.ng":
			return UserService.login(req, resp);
		
		default:
			return "not yet implemented";
		}
	}

}
