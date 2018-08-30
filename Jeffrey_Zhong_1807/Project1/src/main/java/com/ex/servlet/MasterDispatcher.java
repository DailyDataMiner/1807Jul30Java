package com.ex.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.EmployeeService;
import com.ex.service.ReimbursementService;

public class MasterDispatcher {

	private MasterDispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {
		case "/Project1/login.ng":
			return EmployeeService.login(request, response);
		case "/Project1/getAllReimbursement.ng":
			return  ReimbursementService.getAllReimbursement(request,response);
		case "/Project1/getReimbursement.ng":
			return  ReimbursementService.getReimbursement(request,response);
		case "/Project1/submitReimbursement.ng":
			return  ReimbursementService.submitReimbursement(request,response);
		case "/Project1/approveReimbursement.ng":
			return  ReimbursementService.approveReimbursement(request,response);
		case "/Project1/denyReimbursement.ng":
			return  ReimbursementService.denyReimbursement(request,response);
		case "/Project1/getReimbursementOrder.ng":
			return  ReimbursementService.getReimbursementOrder(request,response);
		case "/Project1/getAllReimbursementOrder.ng":
			return  ReimbursementService.getAllReimbursementOrder(request,response);
		default:
			return "not yet implemented";
		}
	}
}