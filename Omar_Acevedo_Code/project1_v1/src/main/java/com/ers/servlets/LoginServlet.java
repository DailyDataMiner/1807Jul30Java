package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.User;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = null;
		ObjectMapper mapper = new ObjectMapper();
		UserService uService = new UserService();
		
		System.out.println(" ---> " + req.getRequestURI());
		
		try {
			
			switch (req.getRequestURI()) {
			
				case "/project1_v1/login":
					
					user = mapper.readValue(req.getReader(), User.class);
					
					User authorizedUser = uService.getUser(user.getUsername());
					System.out.println("---> " + authorizedUser.toString());
					
					if (uService.getHashValue(user).equals(authorizedUser.getPassword())) {
						
						String json = "";
						json = mapper.writeValueAsString(authorizedUser);
						
						PrintWriter pWriter = resp.getWriter();

						resp.setContentType("application/json");
						pWriter.write(json);
						
					} else {
						String json = "";
						
						PrintWriter pWriter = resp.getWriter();

						resp.setContentType("application/json");
						pWriter.write("{'response':'invalid credentials'}");
						
					}
					
				default:
//					PrintWriter pWriter = resp.getWriter();

//					resp.setContentType("application/json");
//					pWriter.write("Oh, hey... what's up?");
					System.out.println("defaulted;");
		
			}
			
		} catch (IOException e) {
			System.out.println("in io exception");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
		
	}
	
}
