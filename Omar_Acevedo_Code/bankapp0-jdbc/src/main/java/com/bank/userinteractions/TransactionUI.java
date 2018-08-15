package com.bank.userinteractions;

import java.util.Scanner;

import com.bank.daos.TransactionDao;
import com.bank.pojos.Account;
import com.bank.pojos.Transaction;
import com.bank.utils.HelperFunctions;

public class TransactionUI extends HelperFunctions {
	
	private static Transaction transactionObj = null;
	
	public static void doTransactions(Account accountObj) {
		
		Scanner readFromUser = new Scanner(System.in);
		
		String userResponse;
		print(" - TRANSACTION MENU - ");
		print("    What type of transaction do you want to make: \n ( 1.deposit, 2.withdrawal, 3.transfer money ) ?");
		userResponse = readFromUser.next(); // try with nextLine()
		
		double transactionAmount = 0.00;

		switch (userResponse) {
			case "1":
				print("You chose DEPOSIT");
				print(accountObj.toString());
				print("Account Type: " + accountObj.getAccountTypeName());
				print("Account Balance: " + accountObj.getBalance());
				print("Account Account Type Id: " + accountObj.getAccount_accounttypeid());
				
				print("Enter amount to deposit: ");
				transactionAmount = readFromUser.nextDouble();
				
				// pass accountObj object into dao below
				transactionObj = TransactionDao.deposit(accountObj, transactionAmount);
				
				break;
			case "2":
				print("You chose WITHDRAWAL");
				
				print("Enter amount to withdraw: ");
				transactionAmount = readFromUser.nextDouble();
				
				transactionObj = TransactionDao.withdraw(accountObj, transactionAmount);
				
				break;
				
			case "3":
				print("You chose TRANSFER MONEY");
//				TransactionDao ? 
				break;
		}
		
	}
	
}
