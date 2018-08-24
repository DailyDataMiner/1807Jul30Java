package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewsServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log.trace("Initializing LoadViewServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resource = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resource).forward(req, resp);
		
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {

//		log.info("REQUEST SENT TO: " + req.getRequestURI());
		log.info("REQUEST SENT TO: " + req.getContextPath());

		System.out.println("REQUEST SENT TO: " + req.getRequestURI());
		
//		/bookstore-jdbc/authors.view
		
		switch (req.getRequestURI()) {
			
			case "/bookstore-jdbc/home.view":
				return "homeView";
				
			case "/bookstore-jdbc/genre.view":
				return "genreView";
			
			case "/bookstore-jdbc/books.view":
				return "booksview";
				
			case "/bookstore-jdbc/authors.view":
				return "authorsView";
			
			default:
				return "errorView";
		}
		
	}
	
}
