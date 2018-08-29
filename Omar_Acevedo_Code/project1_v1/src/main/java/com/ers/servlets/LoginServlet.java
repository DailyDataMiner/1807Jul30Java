package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = null;
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(" ---> " + req.getRequestURI());
		
		try {
			
			switch (req.getRequestURI()) {
			
				case "/project1_v1/login":
					
					user = mapper.readValue(req.getReader(), User.class);
					System.out.println("User -> " + user.toString());
					
					//return UserService.login(request, response);
					
				default:
					System.out.println("defaulted;");
		
			}
			
		} catch (IOException e) {
			System.out.println("in io exception");
			e.printStackTrace();
		}
		
//		response.getWriter().write(mapper.writeValueAsString(MasterDispatcher.process(request, response)));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
		
	}
	
}
