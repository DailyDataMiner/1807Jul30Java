package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.ReimbursementDao;
import com.rev.pojos.Reimbursement;

@WebServlet("/denyrequest")
public class DenyRequestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement r = new Reimbursement();
		
		try {
			r = mapper.readValue(request.getReader(), Reimbursement.class);
			System.out.println(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ReimbursementDao.denyRequest(r.getReimbId());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
	
}