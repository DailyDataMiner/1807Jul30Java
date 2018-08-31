package com.rev.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.ReimbursementDao;
import com.rev.pojos.Reimbursement;

@WebServlet("/findallreimbursements")
public class FindAllReimbursementsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Reimbursement> ReimbursementList = ReimbursementDao.findAllReimbursements();

			response.setContentType("application/json");

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(ReimbursementList);

			response.getWriter().write(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
