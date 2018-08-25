package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//does anotation servlet have to match document.getelementbyid?
@WebServlet("/doStuff")
public class AjaxServlet extends HttpServlet {

	static int counter = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String info1 = req.getContextPath();
		String info2 = req.getProtocol();
		Enumeration<String> info3 = req.getHeaderNames();
		
		String headers = "";
		
		do {
			headers+=", ";
			headers+=info3.nextElement();
		}while(info3.hasMoreElements());
	
		out.write("Request #" + ++counter + "\nContext Path: " + info1 + "\nProtocol: " + info2 + "\nHeader Names: " + info3);
	}
}
