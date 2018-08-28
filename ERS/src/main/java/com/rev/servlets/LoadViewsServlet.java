package com.rev.servlets;

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
		// TODO Auto-generated method stub
		super.init();
		log.trace("Initializing LoadViewsServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resource = "partials/" + process(req, resp) + ".html";
		resp.addHeader("Access-Control-Allow-Origin", "*");

		req.getRequestDispatcher(resource).forward(req, resp);
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(("REQUEST SENT TO: " + req.getRequestURI()));
		System.out.println(("PATH: " + req.getPathInfo()));
		
		switch (req.getRequestURI()) {
		case "/ERS/login.view":
			return "loggedInView";
		case "/ERS/testusers.view":
			return "testUsersView";
		case "/ERS/testhome.view":
			return "testHomeView";
		case "/ERS/testlogin.view":
			return "testLoginView";
		default:
			return "errorView";
		}
	}

}
