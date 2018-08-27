package com.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servicepackage.EmployeeService;
import com.servicepackage.ReimbursementService;

public class MasterDispatcher {

private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		
		case "/Project1/login.ng":
			return EmployeeService.login(request, response);
		case "/Project1/findBySome.ng":
			return ReimbursementService.findBySome(request, response);
		case "/Project1/submitNew.ng":
			ReimbursementService.submitNew(request, response);
		default:
			return "not yet implemented";
		}
		
	}
	
}
