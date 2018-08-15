package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.BankUserDAO;
import com.rev.pojos.BankUser;

public class BankUserService<Genre> {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<BankUser, Integer> bDao = new BankUserDAO();
	
	public static List<BankUser> getAll(){
		return bDao.findAll();
	}
	
	public static void insert(BankUser b) {
		
		
		bDao.save(b);
		
		
	}
	
	public BankUser findOneId(BankUser b) {
		
		
		return bDao.findOneID(b);
		
	}
	
	
}