package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.pojo.Account;

public class AccountService {
	
	static AccountDAO aDao = new AccountDAO();
	
	public List<Account> getAll(){
		return aDao.findAll();
	}
	
	public List<Account> getAllMine(int userId){
		return aDao.findAllMine(userId);
	}
	
	public String getAccType(int accType) {
		return aDao.findAccountTypeName(accType);
	}
	
	public Account save(Account a) {
		return aDao.save(a);
	}

}
