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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		
//		user.setUsername("JohnSmith");
//		user.setPassword("password");
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		User u = UserDao.findForLogin(user.getUsername(), user.getPassword());
		
		response.setContentType("application/json");

		response.getWriter().write(mapper.writeValueAsString(u));
		
		//functionality to get info from login form 
		
//		String name = req.getParameter("username");
//		String pass = req.getParameter("password");
//		
//		System.out.println("WooHoo! LOGGING IN USER " + name  + ":" + pass);
//		
//		User u = UserDao.findForLogin(name, pass);
//		
//		System.out.println(u);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
		//		//functionality to get info from login form 
//		
//		String name = request.getParameter("username");
//		String pass = request.getParameter("password");
//		
//		System.out.println("posting stuff...LOGGING IN USER " + name  + " : " + pass);
//		
//		User u = UserDao.findForLogin(name, pass);
//		
//		System.out.println(u);
//		
//		response.setContentType("application/json");
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(u);
//		response.getWriter().write(json);
		
//		FROM HERE UP
		
//		PrintWriter out = resp.getWriter();
		
//		if(u == null) {
//			//out.println("Sorry, invalid username");
//			resp.sendRedirect("login");
//		}
//		else if(!u.getUserpassword().equals(pass)) {
//			out.println("Sorry, invalid passsword");
//		}
//		else {
			//valid login getSession() - returns 
			//current session or creates new one if none exists
//			HttpSession session = req.getSession();
//			session.setAttribute("user", u);
//			System.out.println(session.getId());
//			out.println("Welcome, " + name + "!");
//			resp.sendRedirect("testhome.view");
		
//		}
	}
	
	public static void main(String[] args) {
		User user = new User();
		
		user.setUsername("JohnSmith");
		user.setPassword("password");
		
		User u = UserDao.findForLogin(user.getUsername(), user.getPassword());
		
		System.out.println(u.toString());
	}
}
