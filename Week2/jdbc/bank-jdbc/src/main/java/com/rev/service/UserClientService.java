package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.UserClientDao;
import com.rev.pojos.Client;
import com.rev.pojos.UserClient;

public class UserClientService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<UserClient, Integer> ucDao = new UserClientDao();
	
	public List<UserClient> getAll(){
		return ucDao.findAll();
	}
	
	public boolean itsnotHere(String str ) {
		return ucDao.isUnique(str);
	}

	public UserClient addUserClient(UserClient cl){
		return ucDao.save(cl);
	}
	
	public boolean belong(String cl) {
		return  ((UserClientDao) ucDao).belongs(cl);
	}
}

	
