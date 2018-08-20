package com.rev.service;

import java.util.List;

import com.rev.dao.AccountDao;
import com.rev.pojo.Account;

public class AccountService {

	static AccountDao aDao = new AccountDao();

	public List<Account> checkAccount(int userid) {
		return aDao.checkAcc(userid);
	}
	
	public void createAccount(int userid, String accName, String accType) {
		aDao.makeAccount(userid, accName, accType);
	}

	public void change(int id, String name, String type, double bal) {
		aDao.update(id, name, type , bal);
	}
	
	

	
}


