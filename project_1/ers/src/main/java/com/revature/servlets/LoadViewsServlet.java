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
				
		String resource = "partials/" + process(req, resp) + ".html";
		resp.addHeader("Access-Control-Allow-Origin", "*");

		req.getRequestDispatcher(resource).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("Request Sent to: " + req.getRequestURI());
		log.info("Path: " + req.getPathInfo());
		switch(req.getRequestURI()) {
		case "/ers/ticket.view":
			return "ticketView";
		case "/ers/home.view":
			return "homeView";
		case "/ers/login.view":
			return "loginView";

		default:
			return "errorView";
		}
				
		
	}
	
}
