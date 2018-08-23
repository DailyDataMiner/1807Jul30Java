package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/loadHome")
public class LoadHomeViewServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoadHomeViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("I am in the get!");
		//resp.addHeader("Access-Control-Allow-Origin", "*");
		//resp.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTION, HEAD");
		req.getRequestDispatcher("partials/homeview.html").forward(req, resp);
	}
}
