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
import com.rev.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static DummyUserService uService = new DummyUserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + ":" + password);
		
		User u = uService.getByUsername(username);
		
		if (u == null) {
//			out.println("invalid username");
			resp.sendRedirect("login");
		} else if (!u.getPassword().equals(password)) {
			out.println("invalid password");
		} else if (u.getPassword().equals(password)){
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			resp.sendRedirect("home");
		}
	}
}
