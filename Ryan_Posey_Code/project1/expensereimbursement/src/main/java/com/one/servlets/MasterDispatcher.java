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
		case "/expensereimbursement/login.ng":
			return UserService.login(request, response);
		case "/expensereimbursement/getAllReimbs.ng":
			return ReimbursementService.getAllReimbs(request, response);
		case "/expensereimbursement/getReimbs.ng":
			return ReimbursementService.getReimbs(request, response);
		default:
			return "not implemented";
		}
	}
}
