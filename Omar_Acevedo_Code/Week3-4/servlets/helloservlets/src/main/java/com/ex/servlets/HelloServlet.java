/**
 * 
 */
package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author omaracevedo
 *
 */
public class HelloServlet extends GenericServlet {

	static int counter = 0;
	
	/*
	 * 
	 * LIFECYCLE OF A SERVLET init(), service(), destroy()
	 * init is called b the container when the servlet is initialized.
	 * here you can configure things like parameters,s
	 * loggers, etc. basically anything you want to happen
	 * upon ...
	 * 
	 * */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("--- IN HELLOSERVLET init() ");
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("--- IN HELLOSERVLET service() -- count: " + counter);
		System.out.println(" --> " + req.toString());
		
		PrintWriter writer = res.getWriter();
		String bio = getServletContext().getInitParameter("Bio");
		
		writer.println("Hello you!<br />"+
					   "Know that " + bio);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("--- IN HELLOSERVLET destroy()");
	}

}
