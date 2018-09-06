package com.rev.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UsersDAO;
import com.rev.pojos.Users;

public class UserService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC maybe need two dao methods at once or dao
	 * methods from different classes or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	

	public UsersDAO bDao = new UsersDAO();

	public List<Users> getAll() {
		return bDao.findAll();
	}

	public void insert(Users b) {

		bDao.save(b);

	}

	public Users findOneId(Users users) {

		return bDao.findOneID(users);

	}
	
	public static UsersDAO login(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		
		
		ObjectMapper mapper = new ObjectMapper();
		Users obj = new Users();
		obj.setUsername(request.getParameter("username"));
		obj.setUsername(request.getParameter("password"));
		
			UsersDAO u = new UsersDAO();
			u.findOneByUsername(obj);
			if(u != null)
			{
				System.out.println(u);
				return u;
				
			}
			else return null;
			
		
//		Users authorized = UsersDAO.getUser(user.getUsername());
//		if (UsersDAO.getPassword(user).equals(authorized.getPassword()))
//			return UsersDAO.getUserInformation(user.getUsername());
//		return null;
	}

	
}
