package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {
	
	static int counter = 0;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("In helloservlet init");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		counter++;
		System.out.println("--- In Hello Servlet service(). Service count = " + counter);
		
		PrintWriter writer = res.getWriter();
		
		String bio = getServletContext().getInitParameter("Bio");
		
		writer.println("Hello World! Welcome to servlet. About me: " + bio);

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("In hello world destroy.");
	}

}
