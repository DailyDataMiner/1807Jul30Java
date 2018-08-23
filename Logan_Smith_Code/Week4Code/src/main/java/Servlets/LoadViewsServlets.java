package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewsServlets extends HttpServlet {
	private static Logger log = Logger.getLogger(LoadViewsServlets.class);

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log.trace("In LoadViewsServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resources = "Partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resources).forward(req, resp);
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("REQUEST SENT TO: " + req.getRequestURI());
		log.info("PATH: " + req.getPathInfo());
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/Bookstore/home.view":
			return "HomeView";
		case "/Bookstore/genre.view":
			return "GenreView";
		case "/Bookstore/books.view":
			return "BooksView";
		default:
			return "ErrorView";
		}
		
	}
}