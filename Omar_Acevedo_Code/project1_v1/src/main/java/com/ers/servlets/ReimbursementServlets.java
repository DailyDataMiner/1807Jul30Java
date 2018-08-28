package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.Reimbursement;
import com.ers.services.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/reimbursements")
public class ReimbursementServlets extends HttpServlet {

	ReimbursementService rService = null;
	ObjectMapper objMapper = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		rService = new ReimbursementService();
		
		List<Reimbursement> reimbList = rService.findAll();
		String json = "";
		
		if (reimbList.size() > 0) {
			
			objMapper = new ObjectMapper();
			json = objMapper.writeValueAsString(reimbList);
			
			PrintWriter pWriter = resp.getWriter();
			
			resp.setContentType("application/json");
			pWriter.write(json);
			
		}
		
		System.out.println("req.getRequestURI() -> " + req.getRequestURI());
		PrintWriter pw = resp.getWriter();
//		pw.write("hello\n");
//		pw.write("hello again!\n");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
}