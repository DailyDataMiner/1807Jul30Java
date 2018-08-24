package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("HttpServlet::IndexServlet::init()");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("HttpServlet::IndexServlet::destroy()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("HttpServlet::IndexServlet::doGet()");
		
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>"
				+ "<body>"
				+ "<h3>Hello</h3>"
				+ "</body>"
				+ "</html>");
		
		
	}
	
}
