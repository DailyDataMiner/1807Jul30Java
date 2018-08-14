package com.rev.service;

import java.util.Scanner;

import com.rev.dao.AccountDao;
import com.rev.pojos.Account;
import com.rev.pojos.Deposit;
import com.rev.pojos.User;
import com.rev.pojos.Withdrawal;

public class AccountService {
	
	public static void makeDeposit(User loggedInUser) {
		
		Scanner iceCave = new Scanner(System.in);
		
		System.out.println("Which account would you like to deposit into?\n");
		int accountToDepositInto = iceCave.nextInt();
		
		System.out.println("How much would you like to deposit?\n");
		double amountToDeposit = iceCave.nextDouble();
		
		Deposit deposit = new Deposit();
		
		deposit.setAccountid(accountToDepositInto);
		deposit.setAmountToDeposit(amountToDeposit);

		AccountDao.Deposit(accountToDepositInto, amountToDeposit);
		System.out.println("You have deposited $" + amountToDeposit + "0");
		
		UserService.welcomeUserMenu(loggedInUser);
		
		iceCave.close();
	}
	
	public static void makeWithdrawal(User loggedInUser) {
		Scanner iceCave = new Scanner(System.in);
		
		System.out.println("Which account would you like to withdraw from?\n");
		int accountToWithdrawFrom = iceCave.nextInt();
		
		System.out.println("How much would you like to withdraw?\n");
		double amountToWithdraw = iceCave.nextDouble();

		Withdrawal withdrawal = new Withdrawal();
		
		withdrawal.setAccountid(accountToWithdrawFrom);
		withdrawal.setAmountToWithdraw(amountToWithdraw);

//		AccountDao.Withdraw(accountToWithdrawFrom, amountToWithdraw);
		
		if(AccountDao.Withdraw(accountToWithdrawFrom, amountToWithdraw, loggedInUser)) {
			System.out.println("You have withdrawn $" + amountToWithdraw + "0");
			UserService.welcomeUserMenu(loggedInUser);
		}
		
		iceCave.close();
	}
	
	public static void openAccount(User loggedInUser) {
		System.out.println("What type of account would you like to open?\n" + "Enter 1 to open new savings account\n"
				+ "Enter 2 to open new checking account\n");
		
		Scanner iceCave = new Scanner(System.in);
		String s = iceCave.nextLine();
		int option = Integer.parseInt(s);

		if(option != 1 && option != 2 || s == null) {
			System.out.println("Sorry, you must enter 1 or 2!");
			openAccount(loggedInUser);
		}
		
		String typeOfAccountToMake = "";
		
		if(option == 1) {
			typeOfAccountToMake = "savings";
		}
		else if(option == 2) {
			typeOfAccountToMake = "checking";
		}
		
		Account newAccount = new Account();
		newAccount.setAccounttype(typeOfAccountToMake);
		
		AccountDao.save(newAccount, loggedInUser);
		
		UserService.welcomeUserMenu(loggedInUser);
		
		iceCave.close();
	}
	
	public static User easyAccess(User loggedInUser) {
		
		
		
		return loggedInUser;
	}
	
	public static void openCheckingAccount(User loggedInUser) {
//		CheckingAccount sa = new CheckingAccount();
//		
//		sa.setUserid(loggedInUser.getUserid());
//		sa.setAmount(0);
//		
//		SavingsAccountDao.save(sa, loggedInUser);
	}
	
}