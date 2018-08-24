package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewsServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);

	public void init() throws ServletException {
		super.init();
		log.trace("Initializing LoadViewsServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String endpoint = "partials/" + process(req, resp) + ".html";
		System.out.println(endpoint);
		log.info("request sent to: " + req.getRequestURI());
		req.getRequestDispatcher(endpoint).forward(req, resp);
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("request sent to: " + req.getServletPath());

		switch (req.getServletPath()) {
		case "/home.view":
			return "homeView";
		case "/book.view":
			return "bookView";
		case "/author.view":
			return "authorView";
		case "/genre.view":
			return "genreView";
		default:
			return "errorView";
		}
	}
}
