package com.one.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.service.UserService;
import com.one.service.ReimbursementService;

public class MasterDispatcher {

	private MasterDispatcher() {
		
	}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Project1/login.ng":
			return UserService.login(request, response);
		case "/Project1/getAllReimbs.ng":
			return ReimbursementService.getAllReimbs(request, response);
		case "/Project1/getReimbs.ng":
			return ReimbursementService.getReimbs(request, response);
		case "/Project1/addReimb.ng":
			return ReimbursementService.addReimb(request, response);
		case "/Project1/approveReimb.ng":
			return ReimbursementService.approveReimb(request, response);
		case "/Project1/denyReimb.ng":
			return ReimbursementService.denyReimb(request, response);
		case "/Project1/getUsers.ng":
			return UserService.getUsers(request, response);
		default:
			return "not implemented";
		}
	}
}
