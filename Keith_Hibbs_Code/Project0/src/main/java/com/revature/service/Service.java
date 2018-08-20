package com.revature.service;

import java.sql.SQLException;
//import java.util.List;

//import com.revature.main.app;
import com.revature.dao.AccountDao;
//import com.revature.dao.AccountTypeDao;
//import com.revature.dao.UsersDao;
import com.revature.pojos.Account;

public class Service {
	
	static Account a = new Account();
	static AccountDao ad = new AccountDao();
	

	public static void onWithdraw(int aid, int amt) throws SQLException {
		
		ad.withdraw(aid, amt);
		
	}
	public static void onDeposit(int aid, int amt) throws SQLException {
		
		ad.deposit(aid, amt);
		
	}
	
	
}