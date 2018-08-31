package com.rev.servlets;

import java.io.IOException;
import java.sql.SQLException;

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

	// this needs to take in prefilled reimbursements fields and save a
	// reimbursement

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try {
			ObjectMapper mapper = new ObjectMapper();
			Reimbursement reimbursement = new Reimbursement();

			reimbursement = mapper.readValue(request.getReader(), Reimbursement.class);

			ReimbursementDao.saveNewReimbursement(reimbursement);

			response.setContentType("application/json");

			response.getWriter().write(mapper.writeValueAsString(reimbursement));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
