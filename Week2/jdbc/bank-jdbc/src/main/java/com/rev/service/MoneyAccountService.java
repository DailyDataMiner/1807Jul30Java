package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.MoneyAccountDao;
import com.rev.dao.ClientDao;
import com.rev.pojos.Client;
import com.rev.pojos.MoneyAccount;

public class MoneyAccountService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<MoneyAccount, Integer> ucDao = new MoneyAccountDao();
	
	public List<MoneyAccount> getAll(){
		return (List<MoneyAccount>) ucDao.findOne(null);
	}
	
	public MoneyAccount change(MoneyAccount ma){
		return ucDao.update(ma);
	}
	public MoneyAccount getSession(String username) {
		return ((MoneyAccountDao) ucDao).getAccount(username);
	}
	
	
	
}