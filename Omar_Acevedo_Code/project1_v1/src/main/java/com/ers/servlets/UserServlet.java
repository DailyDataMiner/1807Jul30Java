package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.User;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("1-user working");
		User user = new User();
		UserService uService = new UserService();
		ObjectMapper mapper = null;
		String json = "";
		
		List<User> userList = uService.getAllUsers();
		if (userList.size() > 0) {
			
			mapper = new ObjectMapper();
			json = mapper.writeValueAsString(userList);
			
			PrintWriter pWriter = resp.getWriter();
			
			resp.setContentType("application/json");
			pWriter.write(json);
			
		}
		
		System.out.println("2-user working");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User();
		UserService uService = new UserService();
		PrintWriter pWriter = resp.getWriter();
		
		System.out.println("This is post data!");
		
		String json = "";
		
		ObjectMapper mapper = null;
		BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
		
		if (br != null) {
			json = br.readLine();
		}
		
		System.out.println("json string -> " + json);

		mapper = new ObjectMapper();
		
		User userObj = mapper.readValue(json, User.class);
		
		System.out.println(userObj.toString());
		
		json = "{\"succeeded\":";
//		json += "\"" + uService.save(userObj) + "\"";
		json += uService.save(userObj);
		json += "}";
		
		resp.setContentType("application/json");
		
		System.out.println(json);
		pWriter.write(json);
//		pWriter.write("{\"succeeded\":\"true\"}");
	
	}
}
