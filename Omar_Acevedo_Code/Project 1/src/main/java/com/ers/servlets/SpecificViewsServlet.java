package com.ers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecificViewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		switch (req.getRequestURI()) {
		
			case "/project1/foodDataView.specificView":
				String foodExpRsrc = "partials/foodExpenses/foodDataView.html";
				RequestDispatcher foodExpDispatcher = req.getRequestDispatcher(foodExpRsrc);
				foodExpDispatcher.forward(req, resp);
				System.out.println("sending foodDataView resource");
				break;
			
			default:
				String errorRsrc = "partials/errorPage.html";
				RequestDispatcher errorReqDispatcher = req.getRequestDispatcher(errorRsrc);
				errorReqDispatcher.forward(req, resp);
				System.out.println("sending error resource");
				break;
		}

	}
	
}
