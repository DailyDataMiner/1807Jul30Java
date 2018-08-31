package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(RegisterServlet.class);
	UserService uService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(
						req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		log.trace("In post of Register Servlet");
		User u2 = uService.addUser(u);
		PrintWriter writer = resp.getWriter();
		if(u2==null) {
			writer.append("invalid");
			writer.flush();
		} else {
			writer.append("valid");
			writer.flush();
		}
	
	}

}
