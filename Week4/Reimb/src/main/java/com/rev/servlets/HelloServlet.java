/**
 * 
 */
package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author knisp
 *
 */
public class HelloServlet extends GenericServlet {
	
	/*
	 * Lifecycle of a servlet init() service() destroy()
	 * init is called by the container when the servlet is initialized. here you can configure things like parametes, loggers, etc. 
	 * basically anything you want to
	 * happen upon initialization of this servlet
	 * 
	 * the container then calls the service() method every time a request
	 * is sent to the url-patter that you have assigned this servlet.
	 * Basically this is the part where the servlet "services the request
	 * 
	 * lastly, the container calls destroy which will deallocated
	 * memory to the servlet. We often
	 */

	static int counter;
	@Override
	public void init() throws ServletException {
		
		
		// TODO Auto-generated method stub
		super.init();
		System.out.println("in servlet init");
	}
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println(("---IN HELLOSERVLET service()") + counter);
		
		PrintWriter writer = res.getWriter();
		String bio = getServletContext().getInitParameter("Bio");
		writer.println("Hello Servlet" + bio);
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy helloservlet");
	}

}
