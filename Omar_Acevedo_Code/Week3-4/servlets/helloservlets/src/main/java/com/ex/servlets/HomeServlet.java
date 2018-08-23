package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.utils.HTMLCode;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User u = (User) session.getAttribute("user");
		if (u == null) {
			resp.sendRedirect("login");
		} else {
			
			PrintWriter out = resp.getWriter();
			
			String _html = HTMLCode.htmlcode(u);
			out.write(_html);
			
		}
		
	}
	
}
