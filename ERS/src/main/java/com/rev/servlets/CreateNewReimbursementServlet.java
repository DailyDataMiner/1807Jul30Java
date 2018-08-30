package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.ReimbursementDao;
import com.rev.dao.UserDao;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

@WebServlet("/createnewreimbursement")
public class CreateNewReimbursementServlet extends HttpServlet {
	
	//this needs to take in prefilled reimbursements fields and save a reimbursement
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursement = new Reimbursement();

//		user.setUsername("JohnSmith");
//		user.setPassword("password");

		try {
			reimbursement = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ReimbursementDao.saveNewReimbursement(reimbursement);

		response.setContentType("application/json");

		response.getWriter().write(mapper.writeValueAsString(reimbursement));
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
	
	public static void main(String[] args) {
		Reimbursement reimbursement = new Reimbursement();

		reimbursement.setReimbAmount(889.90);
		reimbursement.setReimbDescription("Business trip to Portland in July");
		reimbursement.setReimbAuthor("JohnSmith");
		reimbursement.setReimbTypeId("Travel");

//		Reimbursement r = 
				ReimbursementDao.saveNewReimbursement(reimbursement);

//		System.out.println(reimbursement.toString());
	}
	
}
