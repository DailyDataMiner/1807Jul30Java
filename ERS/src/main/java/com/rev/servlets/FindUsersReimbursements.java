package com.rev.servlets;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/findusersreimbursements")
public class FindUsersReimbursements extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		User u = UserDao.findUserByUsername(user.getUsername());
		
		List<Reimbursement> ReimbursementList = ReimbursementDao.findReimbursementsByUsername(u.getUsername());

		response.setContentType("application/json");

		String json = mapper.writeValueAsString(ReimbursementList);

		response.getWriter().write(json);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	
	}

}
