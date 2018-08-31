package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.User;
import com.revature.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	UserService uService = new UserService();
	private static Logger log = Logger.getLogger(User.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("In the get of user servlet");
		User u = (User) req.getSession().getAttribute("user");
		if(u!=null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(u);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
