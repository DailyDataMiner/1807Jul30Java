package com.ex.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.model.UserInfo;
import com.ex.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest req, HttpServletResponse res) {
		switch(req.getRequestURI()) {
		case "/ServletsExample/login.ng":
			return UserService.login(req,res);
		
		
		

		default: 
			return "not yet implemented";
		}
		
	}
}
