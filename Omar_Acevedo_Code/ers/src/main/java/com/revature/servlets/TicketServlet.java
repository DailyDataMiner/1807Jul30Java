package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Tickets;
import com.revature.service.TicketsService;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet{
	
	TicketsService ts = new TicketsService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		
		System.out.println("hitting ticket servlet");
		List<Tickets> tickets = ts.getAllTickets();
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(tickets);
		PrintWriter out = resp.getWriter();
		
//		System.out.println(json);
		
		resp.setContentType("application/json");
		out.write(json);
	}
	
	
}
