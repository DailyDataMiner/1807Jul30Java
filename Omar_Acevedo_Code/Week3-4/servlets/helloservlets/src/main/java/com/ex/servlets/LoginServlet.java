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
import com.ex.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
//		req.getRequestDispatcher("login.html");
	}
	
	static DummyUserService uService = new DummyUserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get info from form
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("[post] Loggin in user " + name + ":" + pass);
		
		// 	get parameter - binding
		//	get parameter - map
		//	get parameter - key value pairs
		//	get parameter -	values
		
		User u = uService.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		
		if (u == null) {
			out.println("Sorry, you are not the person we want... bye");
			resp.sendRedirect("login");
			
		} else if (!u.getPassword().equals(pass)) {
			out.println("Sorry again, ... your password is not cool, therefore... byeeee");
			
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			out.println("Oh, hey there Mrs./Mr. " + name);
			resp.sendRedirect("home");
		}
		
	}
	
}
