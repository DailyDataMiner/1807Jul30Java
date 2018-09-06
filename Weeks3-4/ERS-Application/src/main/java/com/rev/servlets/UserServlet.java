package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UsersDAO;
import com.rev.pojos.Users;
import com.rev.service.UserService;

//@WebServlet("/login")
public class UserServlet extends HttpServlet {

	static UserService bs = new UserService();
	
	@Override
	public void init() throws ServletException {
		System.out.println("In servlet init");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("IN DO GET");
		
		UsersDAO user = bs.login(req, resp); 
		
		
//		
//		List<com.rev.pojos.Users> user1 = bs.getAll();
//		if (user1.size() > 0) {
//
//			// Make sure the user is logged in.
//			HttpSession session = req.getSession(false);
//			if (session == null || session.getAttribute("user") == null) {
//				resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Must be logged in to access the API.");
//				return;
//			}
//			
//			Users u = (Users) session.getAttribute("user");
//			UserService uService = new UserService();
//			
//			try {
//				u = ((List<Users>) uService).get(u.getUsersID());
//				session.setAttribute("user", u);
//				
//			}  catch (Exception e) {
//	            
//	            }
			

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);

//		} else {
//			resp.setStatus(418);
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsersDAO user = bs.login(req, resp);

	}

}
