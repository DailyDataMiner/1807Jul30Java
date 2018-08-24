package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reimbursements")
public class ReimbursementsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String expenseType = req.getParameter("type");

		switch (expenseType) {
			case "food":
				System.out.println("we have a food expense 'view' request! -> use Service");
				break;
			case "office":
				System.out.println("we have a office expense 'view' request! -> use Service");
				break;
			default:
				System.out.println("shit");
		}
		
//		switch (req.getRequestURI()) {
//		
//			case "":
//				break;
//			
//			
//		
//		}
		
	}
	
}
