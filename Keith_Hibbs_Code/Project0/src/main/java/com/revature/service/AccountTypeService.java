package com.revature.service;

import java.util.List;

import com.revature.dao.Account_Type_Dao;
import com.revature.dao.Dao;
import com.revature.pojos.Account_Type;

public class AccountTypeService {

	static Dao<Account_Type, Integer> atDao = new Account_Type_Dao();
	
	public List<Account_Type> getAll(){
		return atDao.findAll();
	}

	public static Object get(int accountTypeIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
