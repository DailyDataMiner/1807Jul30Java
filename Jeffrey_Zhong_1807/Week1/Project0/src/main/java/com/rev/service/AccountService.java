package com.rev.service;

import java.util.Scanner;

import com.rev.dao.AccountDao;
import com.rev.pojos.Account;

public class AccountService {

	static Scanner depamountscan = new Scanner(System.in);

	public static void createAccount(int a) {

		AccountDao AD = new AccountDao();

		Account temp = new Account();
		temp.setBalance(00.00);
		temp.setAccountTypeID(a);
		AD.save(temp);

	}
	
	public static void neverGonnaUseThis() throws MyCustomException {
		System.out.println("never gonna happen");
	}


	public static String convertTypeID(int i) {
		
		
		if(i == 1) {
			return "Checkings Account ";
		}
		else if(i == 2) {
			return "Savings Account ";
		}
		else if(i == 3) {
			return "Deposit Account ";
		}
		else {
			return "Account ";
		}
		
		
		
	}

}


