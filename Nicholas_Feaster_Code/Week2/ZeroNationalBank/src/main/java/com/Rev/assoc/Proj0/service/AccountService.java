package com.Rev.assoc.Proj0.service;

import java.util.Scanner;

import com.Rev.assoc.Proj0.DAO.BankAccountDao;
import com.Rev.assoc.Proj0.pojos.BankAccount;

public class AccountService {
	static BankAccountDao theOne = new BankAccountDao();
	static Scanner accountScanner = new Scanner(System.in);
	public BankAccount addAccount() {
		BankAccount outBank = new BankAccount();
		if(UserService.egg){
		System.out.println("Please enter a unique number for your account: ");
		outBank.setBAID(Integer.parseInt(accountScanner.nextLine()));
		System.out.println("Please enter a unique name for your account: ");
		outBank.setBAAccNAme(accountScanner.nextLine());
		System.out.println("What type of account would you like? Checking or savings");
		outBank.setBAType(accountScanner.nextLine());
		System.out.println("Please deposit funds into your new account: ");
		outBank.setBABalance(Double.parseDouble(accountScanner.nextLine()));
		System.out.println("Please enter your user id: ");
		outBank.setBAUserID(Integer.parseInt(accountScanner.nextLine()));
		//int newAcc = Integer.parseInt(accountScanner.nextLine());
		}
		theOne.save(outBank);
		return outBank;
	}
	public void updateBalance() {
		System.out.println("Please enter the bank account number: ");
		int accNum = Integer.parseInt(accountScanner.nextLine());
		System.out.println("Please enter the account name: ");
		String accName = accountScanner.nextLine();
		BankAccount chosen = theOne.findOne(accNum, accName);
		
		System.out.println("Please select a option:\n"
    			+ "1. Withdraw.\n"
    			+ "2. Deposit. ");
    	int option = 0;
		try { 
			option = Integer.parseInt(accountScanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 2 :)");
			updateBalance();
		}
		switch(option) {
		case 1:
			System.out.println("Please enter an amount to be withdrawn: ");
			Double NegScalr = Double.parseDouble(accountScanner.nextLine()); 
			if((chosen.getBABalance()) - NegScalr> 0) {
				NegScalr = (chosen.getBABalance())-NegScalr;
				
				
			}
			else {
				System.out.println("You can not withdraw");
			}
			break;
		case 2:
			System.out.println("Please enter an amount to be deposited");
			Double scalr = Double.parseDouble(accountScanner.nextLine()); 
			scalr = chosen.getBABalance() + scalr;
			
		}
	}
}
