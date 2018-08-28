package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ServletDispatcher
 */
public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		response.getWriter().write(mapper.writeValueAsString(MasterDispatcher.process(request, response)));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HERE");
		doGet(request, response);
	}

}
