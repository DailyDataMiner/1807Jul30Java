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
public class ReimbursementsServlet extends HttpServlet {

	static ReimbursementService rService = new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String expenseType = req.getParameter("type");
		
//		List<Reimbursement> reimbursements = rService.getAllReimbursements();	// pase type as param
//		List<Reimbursement> reimbursements = rService.getAllReimbursements(expenseType);

		switch (expenseType) {
			case "food":
				
				List<Reimbursement> reimbursements = rService.getAllReimbursements();	// pase type as param
//				List<Reimbursement> reimbursements = rService.getAllReimbursements_ofType(expenseType);
				
				if (reimbursements.size() > 0) {
					
					ObjectMapper mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(reimbursements);
					
					PrintWriter pWriter = resp.getWriter();
					
					resp.setContentType("application/json");
					pWriter.write(json);
					
				} else {
					resp.setStatus(404);
				}
				
				break;
			case "office":
				System.out.println("we have a office expense 'view' request! -> use Service");
				break;
			default:
				System.out.println("shit");
		}
		
//		switch (req.getRequestURI()) {
//		
//			case "":
//				break;
//			
//			
//		
//		}
		
	}
	
}
