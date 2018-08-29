package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlets extends GenericServlet {
	
	static int counter =0;
	
	
	@Override
	public void init() throws ServletException {
		/*
		 * LifeCycle of a SERVLET 11 init() service() destroy()
		 * init is called by the container when the servlet is initialized. 
		 * here you can 
		 * 
		 * */
		
		// TODO Auto-generated method stub
		super.init();
		System.out.println("INIT HELLO SERVLET");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("--- IN HELLOSERVLET service() -- count:"+ counter);
		
		PrintWriter writer = res.getWriter();
		String bio = getServletContext().getInitParameter("Bio");
		writer.println("Hello World! Welcome to Java Servlets");

	}
	
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Hello .. DESTROY!!!");
	}

}


