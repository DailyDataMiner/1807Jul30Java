package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.UsersDAO;
import com.rev.pojos.Users;

public class UserService {
		/*
		 * SERVICE LAYER IS BUSINESS LOGIC
		 * maybe need two dao methods at once
		 * or dao methods from different classes
		 * or some sort of manipulation of data either
		 * pre or post dao method call should go here
		 */
		
		public UsersDAO bDao = new UsersDAO();
		
		public  List<Users> getAll(){
			return bDao.findAll();
		}
		
		public void insert(Users b) {
			
			
			bDao.save(b);
			
			
		}
		
		public Object findOneId(Integer b) {
			
			
			return bDao.findOneID(b);
			
		}
		
		
	}


