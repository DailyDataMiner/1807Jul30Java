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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Tickets;
import com.revature.service.TicketsService;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet{
	
	static TicketsService ts = new TicketsService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        Tickets b = mapper.readValue(json, Tickets.class);
        System.out.println(b.toString());
        System.out.println("AMOUNT: " + b.getCash());
        
        ts.addTicket(b);
        String ret = mapper.writeValueAsString(b);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.write(ret);
        
	}   
}
