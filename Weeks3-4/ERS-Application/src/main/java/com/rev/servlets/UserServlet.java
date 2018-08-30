package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.service.UserService;
import com.rev.dao.UsersDAO;


@WebServlet("/users")
public class Users extends HttpServlet {
	
	static UserService bs = new UserService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<com.rev.pojos.Users> user = bs.getAll();
		if(user.size()>0) {
			//return books 
			
			//JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
			
		}else {
			resp.setStatus(404);
		}
}

	
	
	
	

}
