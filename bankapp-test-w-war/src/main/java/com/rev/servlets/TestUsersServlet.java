package com.rev.servlets;

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
import com.rev.dao.UserDao;
import com.rev.pojos.User;

@WebServlet("/testusers")
public class TestUsersServlet extends HttpServlet {

	List<User> userstest = UserDao.findAll();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(userstest.size() > 0) { 									//this whole if-else may not be needed, FYI
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(userstest);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
		else {														//this whole if-else may not be needed, FYI
			resp.setStatus(404);									//this whole if-else may not be needed, FYI
		}															//this whole if-else may not be needed, FYI
	}
	
	User userstestone;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TAKE BOOK JSON STRING AND TURN TO JAVA OBJ
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		System.out.println(u.toString());
		
		u = UserDao.save(u);
		System.out.println(u.toString());
		
		String ret = mapper.writeValueAsString(u);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(ret);
	}
	
}
