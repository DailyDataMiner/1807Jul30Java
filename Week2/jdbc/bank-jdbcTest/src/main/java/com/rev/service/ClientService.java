package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.ClientDao;
import com.rev.pojos.Client;

public class ClientService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<Client, Integer> ucDao = new ClientDao();
	
	public List<Client> getAll(){
		return ucDao.findAll();
	}
	
	
}