package com.ex.servlet;

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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Hello there from the doGet");
		
		ObjectMapper mapper = new ObjectMapper();
		
//		
//		String json = mapper.writeValueAsString(MasterDispatcher.process(request, response));
//		PrintWriter out = response.getWriter();
//				
//		
//		response.setContentType("application/json");
//		
//		response.getWriter().write(json);
		
		
		response.getWriter().write(mapper.writeValueAsString(MasterDispatcher.process(request, response)));
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
