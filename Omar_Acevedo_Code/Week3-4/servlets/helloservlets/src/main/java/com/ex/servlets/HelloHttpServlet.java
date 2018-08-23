package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloHttpServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("--- IN HELLOHTTPSERVLET init() ");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("--- IN HELLOHTTPSERVLET destroy() ");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("--- IN HELLOHTTPSERVLET doGet() ");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
//		resp.setContentType("application/json");
		
		String info = getServletConfig().getInitParameter("info");
		out.write("<h1> Hello there</h1><br />" + 
				  "<i>Init params: " + info +  "</i>");
		
//		out.write("{'name':'Omar', 'age':'28'}");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.write("IN HTTPSERVLET POST METHOD!\n");
		
	}
	
}
