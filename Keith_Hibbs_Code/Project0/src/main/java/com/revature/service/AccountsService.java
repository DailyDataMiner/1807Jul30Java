package com.revature.service;

import java.util.List;

import com.revature.dao.AccountsDao;
import com.revature.dao.Dao;
import com.revature.pojos.Accounts;

public class AccountsService {

	static Dao<Accounts, Integer> aDao = new AccountsDao();
	public static List <Accounts> getAll(){
		return aDao.findAll();
	}
}
