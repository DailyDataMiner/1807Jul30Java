package com.ex.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.model.UserInfo;
import com.ex.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static UserInfo process(HttpServletRequest req, HttpServletResponse res) {
		switch(req.getRequestURI()) {
		case "/ServletsExample/login.ng":
			return UserService.login(req,res);
		
		
		

			
		}
		return null;
	}
}
