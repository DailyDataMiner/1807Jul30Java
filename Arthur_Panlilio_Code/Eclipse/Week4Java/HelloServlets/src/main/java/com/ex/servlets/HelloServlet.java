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
 * @author Panli
 *
 */
public class HelloServlet extends GenericServlet {
	
	
	int counter = 0;

	/*
	 * Lifecycle of a servlet!init() service() destroy()
	 * init is called by the container when the servlet is
	 * initialized. here you can configure things like
	 * parameters, loggers, etc. basically anything you want
	 * to happen upon initalization of this servlet
	 * 
	 * the container then calls the service() method every 
	 * time a request is sent to the url-pattern that you have
	 * assigned this servlet. baiscally this the part where 
	 * the servelt services the request
	 * 
	 * Lastly, the container calls destroy which will deallocate 
	 * memory to the servlet. we often don tsee this happen bc we don't
	 * typically limit the lifetime of the servlet
	 * and if we simply stop the app from running, this method 
	 * call is not shown. 
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Iniatializing Hello Servlet!");
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, 
		ServletResponse res) throws ServletException, IOException {
		System.out.println("--- IN HELLOSERVLET service method -- count: " + counter++ );
		
		PrintWriter writer = res.getWriter();
		
		//servlet context is any config details applying to the entire servlet container
		String bio = getServletContext().getInitParameter("Bio");
		
		writer.println("<h1>HELLO WORLD! WELCOME TO JAVA SERVLETS!</h1>"
				+ "About me: " + bio);

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("In helloservlet destroy()!");
	}

}
