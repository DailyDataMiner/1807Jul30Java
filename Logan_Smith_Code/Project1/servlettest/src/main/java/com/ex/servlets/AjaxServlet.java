package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doStuff")
public class AjaxServlet extends HttpServlet {
	static int counter = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String info1 = req.getContextPath();
		String info2 = req.getContentType();
		String info3 = req.getServletPath();
		String info4 = resp.getCharacterEncoding();
		
		out.write("Request #" + ++counter + "\n Context Path: " + info1 + "\n Content Type: "
				+ info2 + "\n Servlet Path: " + info3 + "\n Character Encoding: " + info4);
	}
	
}
