package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadHome")
public class LoadHomeViewServlet extends HttpServlet{
//REPLACING WITH LOADVIEWSERVLET!
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	
		req.getRequestDispatcher("partials/homeView.html").forward(req, resp);
	}
}