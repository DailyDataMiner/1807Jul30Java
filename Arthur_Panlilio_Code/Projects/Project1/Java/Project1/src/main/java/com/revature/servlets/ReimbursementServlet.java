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
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {
	
	ReimbursementService rService = new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN THE REIM");
		List<Reimbursement> reimbursements = rService.getAll();
		if(reimbursements.size() > 0) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(reimbursements);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
