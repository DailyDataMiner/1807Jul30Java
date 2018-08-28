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
public class UserServlet extends HttpServlet {
	
	List<User> testUserList = UserDao.findAllUsers();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		if(testUserList.size() > 0) { 								//this whole if-else may not be needed, FYI
			
			response.setContentType("application/json");
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(testUserList);
//			PrintWriter out = resp.getWriter();
			
//			out.write(json);
			response.getWriter().write(json);
//		}
//		else {														//this whole if-else may not be needed, FYI
//			resp.setStatus(404);									//this whole if-else may not be needed, FYI
//		}															//this whole if-else may not be needed, FYI
	}
	
	User testOneUser;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TAKE BOOK JSON STRING AND TURN TO JAVA OBJ
		
		doGet(request, response);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//		String json = "";
//		if(br != null) {
//			json = br.readLine();
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		User u = mapper.readValue(json, User.class);
//		System.out.println(u.toString());
//		
//		u = UserDao.saveNewUser(u);
//		System.out.println(u.toString());
//		
//		String ret = mapper.writeValueAsString(u);
//		PrintWriter out = resp.getWriter();
//		resp.setContentType("application/json");
//		out.write(ret);
	}

}
