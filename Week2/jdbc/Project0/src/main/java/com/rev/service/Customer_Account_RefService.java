package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.ClientDao;
import com.rev.pojos.Client;
import com.rev.pojos.Customer_Account_Ref;

public class Customer_Account_RefService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<Customer_Account_Ref, Integer> ucDao = new Customer_Account_Ref();
	
	public List<Client> getAll(){
		return ucDao.findAll();
	}
	
	public Client addClient(Client cl){
		return ucDao.save(cl);
	}
	
}