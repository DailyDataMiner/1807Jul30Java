package com.ers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTMLBuilderServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getRequestURI());
		
/*
 * 
 * 		Change this logic like the one in LoadViewsServlet from the bookstore-jdbc app.
 * 
 * 
 * */
		
		switch (req.getRequestURI()) {
		
			case "/project1/header.view":
			
				String headerRsrc = "partials/header.html";
				RequestDispatcher headerReqDispatcher = req.getRequestDispatcher(headerRsrc);
				headerReqDispatcher.forward(req, resp);
				System.out.println("sending header resource");
				break;
				
			case "/project1/main.view":
				
				String mainRsrc = "partials/main.html";
				RequestDispatcher mainReqDispatcher = req.getRequestDispatcher(mainRsrc);
				mainReqDispatcher.forward(req, resp);
				System.out.println("sending main resource");
				break;
			
			
			case "/project1/footer.view":
				
				String footerRsrc = "partials/footer.html";
				RequestDispatcher footerReqDispatcher = req.getRequestDispatcher(footerRsrc);
				footerReqDispatcher.forward(req, resp);
				System.out.println("sending footer resource");
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
