package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.User;

@WebServlet("/home")
public class HomeServlets extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		User u = (User) session.getAttribute("user");
		if(u == null) {
			//invalid session. take to login -->redirect if user directly puts in .../home
			resp.sendRedirect("login");
		}
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
					
		}
	}

}
