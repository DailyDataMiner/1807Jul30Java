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
import com.ex.service.TestUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	static TestUserService uService = new TestUserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("username");
		String pass =req.getParameter("password");
		
		System.out.println("LOGGIN IN USER "+ name+ ";" + pass);
		
		User u = uService.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		if(u == null) {
			//out.println("Sorry, Invalid username");
			resp.sendRedirect("login");
		}else if (!u.getPassword().equals(pass)) {
			out.println("Sorry, Invalid password");
		}else {
			//valid login getSession - returns current session 
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
		  //out.println("Welcome user "+ name);}
			resp.sendRedirect("home");
		}

	}

}
