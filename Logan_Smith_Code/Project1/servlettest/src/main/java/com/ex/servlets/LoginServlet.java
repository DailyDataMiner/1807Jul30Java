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
import com.ex.service.TestService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	static TestService ts = new TestService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("Logging in user: " + name + " " + pass + ".");
		User u = ts.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		if (u == null) {
			req.getRequestDispatcher("Login.html").forward(req, resp);
		}
		else if (!u.getPassword().equals(pass)){
			out.println("Sorry, invalid password.");
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			resp.sendRedirect("home");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Found.");
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}

}
