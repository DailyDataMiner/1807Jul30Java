package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


public class LoadViewsServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Starting LoadViewsServlet");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("hey");
		
		String resource = "partials/" + process(req, resp) + ".html";
		resp.addHeader("Access-Control-Allow-Origin", "*");
		
		System.out.println(resource);
		
		req.getRequestDispatcher(resource).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		
		log.info("Request Sent to: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
			case "/ers/user.view":
				return "userView";
				
			case "/ers/home.view":
				return "homeView";
			
			case "/ers/login.view":
				
				System.out.println("here");
				return "loginView";
				
			case "/ers/employee.view":
				return "employeeView";
			default:
				return "errorView";
		}
				
		
	}
	
}
