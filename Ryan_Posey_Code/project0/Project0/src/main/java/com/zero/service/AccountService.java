package com.zero.service;

import java.util.List;

import com.zero.dao.AccountDao;
import com.zero.dao.Dao;
import com.zero.pojos.Account;

public class AccountService extends AccountDao {

	static Dao<Account, Integer> aDao = new AccountDao();
	
	public List<Account> listAccounts(Integer id) {
		return aDao.findSpecific(id);
	}
	
	public Account getAccount(Integer id) {
		return aDao.findOne(id);
	}
	
	public Account addAccount(Account at) {
		return aDao.save(at);
	}
	
	public Account updateAccount(Account at) {
		return aDao.update(at);
	}
}