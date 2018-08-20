package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.pojos.Account;
//import com.revature.dao.AccountTypeDao;
import com.revature.pojos.AccountType;

public class AccountService {
	static Account a = new Account();
	static AccountDao ad = new AccountDao();
	
	public static void onOpenAccount() {
		 
		System.out.println(a.toString());
		}
		
		
	}
//}
