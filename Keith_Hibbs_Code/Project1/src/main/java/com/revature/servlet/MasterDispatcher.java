package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.UserInformation;
import com.revature.service.ReimbService;
import com.revature.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Project1/login.ng":
			return UserService.login(request, response);
		case "/Project1/logout.ng":
			return UserService.logout(request, response);
		case "/Project1/checksession.ng":
			return UserService.checkSession(request, response);
		case "/Project1/GetRiemb.ng":
			return ReimbService.GetReimb(request, response);
		default:
			return "Path is messed up";
		}
	}
}