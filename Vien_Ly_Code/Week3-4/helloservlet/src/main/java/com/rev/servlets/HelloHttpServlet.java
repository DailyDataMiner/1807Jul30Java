package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1381753810517802552L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("in HelloHttpServlet init()");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("in HelloHttpServlet destroy()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String info = getServletConfig().getInitParameter("info");
		out.write("<h1>Hello <b>Gin</b>!</h1><br>Random init params: <i>" + info + "</i>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write("httpservlet post");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
