package com.ers.servlets;

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
import javax.servlet.http.HttpSession;

import com.ers.pojos.Reimbursement;
import com.ers.services.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/reimbursements")
public class ReimbursementsServlet extends HttpServlet {

	static ReimbursementService rService = new ReimbursementService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = null;
		String expenseType = req.getParameter("type");
		
		System.out.println("in post method, expenseType: " + expenseType);
		
		// Read JSON from client side
		BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		System.out.println("JSON line is -> ");
		System.out.println(json);
		
		mapper = new ObjectMapper();
		
		System.out.println(Reimbursement.class);
		Reimbursement reimbObj = mapper.readValue(json, Reimbursement.class);
		
		System.out.println(reimbObj.toString());
		
		rService.addReimbursement(reimbObj);
		
//		rService = new BookService();
//		rService.addReimbursementReq(r);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Reimbursement> reimbursements = null;
		ObjectMapper mapper = null;
		String expenseType = req.getParameter("type");
		
//		List<Reimbursement> reimbursements = rService.getAllReimbursements();	// pase type as param
//		List<Reimbursement> reimbursements = rService.getAllReimbursements(expenseType);

		switch (expenseType) { // case ""  --> if type is empty, means we want all reimbs (from manager)
		
			case "food":

//				List<Reimbursement> reimbursements = rService.getAllReimbursements();	// pase type as param
				reimbursements = rService.getAllReimbursements_ofType(expenseType);
				
				if (reimbursements.size() > 0) {
					
					mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(reimbursements);
					
					PrintWriter pWriter = resp.getWriter();
					
					resp.setContentType("application/json");
					pWriter.write(json);
					
				} else {
					System.out.println("reimbursements.size() -> " + reimbursements.size() + ", expenseType: " + expenseType);
					resp.setStatus(404);
				}
				
				break;
				
			case "office":
				
				reimbursements = rService.getAllReimbursements_ofType(expenseType);
				
				if (reimbursements.size() > 0) {
					
					mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(reimbursements);

					PrintWriter pWriter = resp.getWriter();
					
					resp.setContentType("application/json");
					pWriter.write(json);
					
					
				} else {
					System.out.println("reimbursements.size() -> " + reimbursements.size() + ", expenseType: " + expenseType);
					resp.setStatus(404);
				}
				
				System.out.println("we have a office expense 'view' request! -> use Service");
				break;
			
			case "transportation":
				
				reimbursements = rService.getAllReimbursements_ofType(expenseType);
				
				if (reimbursements.size() > 0) {
					
					mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(reimbursements);
					
					PrintWriter pWriter = resp.getWriter();
					
					resp.setContentType("application/json");
					pWriter.write(json);
					
				} else {
					System.out.println("reimbursements.size() -> " + reimbursements.size() + ", expenseType: " + expenseType);
					resp.setStatus(404);
					
					mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(reimbursements);
					System.out.println("-> " + json);
					PrintWriter pWriter = resp.getWriter();
					
					resp.setContentType("application/json");
					pWriter.write(json);
					
				}
				
				break;
				
			default:
				System.out.println("shit, we don't have " + expenseType + " type expense here");
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
