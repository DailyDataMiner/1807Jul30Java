package com.ex.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.data.UserRepository;
import com.ex.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static UserRepository repo = new UserRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
		String json = "";
		
		while (br != null) {
			json += br.readLine();
		}
//		
		ObjectMapper mapper = new ObjectMapper();
//		String[] info = mapper.readValue(req.getReader(), String[].class);
		String[] info = mapper.readValue(json, String[].class);
		
		User u = repo.findByUserName(info[0]);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		if (u != null) {
			if (u.getPassword().equals(info[1])) {
				out.write(mapper.writeValueAsString(u));
			} else {
				out.write("null");
			}
		} else {
			out.write("null");
		}
		
	}
	
}
