package com.rev.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UserDao;
import com.rev.pojos.User;

@WebServlet("/findallusers")
public class FindAllUsersServlet extends HttpServlet {

	List<User> testUserList = UserDao.findAllUsers();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(testUserList);

		response.getWriter().write(json);
	}

}
