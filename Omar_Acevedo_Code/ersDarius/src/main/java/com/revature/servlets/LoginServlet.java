package com.revature.servlets;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<User> userInfo = service.getAllUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(userInfo);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("we are in post");
		
		ObjectMapper mapper = null;
		
		
		// Read JSON from client side
		BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		System.out.println("JSON line is -> ");
		System.out.println(json);
		
		mapper = new ObjectMapper();
		
		System.out.println(User.class);
		User usrObj = mapper.readValue(json, User.class);
		
		System.out.println(usrObj.toString());
		
//		rService.addReimbursement(reimbObj);
		 
		
	}

}
