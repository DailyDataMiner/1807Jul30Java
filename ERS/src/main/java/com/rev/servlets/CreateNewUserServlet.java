package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UserDao;
import com.rev.pojos.User;

@WebServlet("/createnewuser")
public class CreateNewUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		User user = new User();

//		user.setUsername("JohnSmith");
//		user.setPassword("password");

		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		UserDao.saveNewUser(user);

		response.setContentType("application/json");

		response.getWriter().write(mapper.writeValueAsString(user));
		

		// functionality to get info from login form

//		String name = req.getParameter("username");
//		String pass = req.getParameter("password");
//		
//		System.out.println("WooHoo! LOGGING IN USER " + name  + ":" + pass);
//		
//		User u = UserDao.findForLogin(name, pass);
//		
//		System.out.println(u);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	public static void main(String[] args) {
		User user = new User();

		user.setUsername("JackJones");
		user.setPassword("password");
		user.setFirstname("Jack");
		user.setLastname("Jones");
		user.setEmail("jjones@gmail.com");

		User u = UserDao.saveNewUser(user);

//		System.out.println(u.toString());
	}

}
