package com.revature.project0.service;

import java.util.List;

import com.revature.project0.dao.AccountTypeDAO;
import com.revature.project0.projectobjects.AccountType;

public class AccountTypeService {

	static AccountTypeDAO atDao = new AccountTypeDAO();
	
	public List<AccountType> getAll() {
		return atDao.findAll();
	}
	
}
