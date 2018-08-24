package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {
	private static final long serialVersionUID = -1331420513006179471L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("in HelloServlet init()");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("in HelloServlet -> service()");
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.println("Hello, welcome to java servlet<br>");
		String context = getServletContext().getInitParameter("random");
		writer.write("Random context params: <i>" + context + "</i>");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("in HelloServlet destroy()");
	}
}
