package com.revature.project0.projectobjects;

import com.revature.project0.myexceptions.NotEnoughMoneyException;

public class Account {

	private int accountID;
	private AccountType accountType;
	private double balance;
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account() {};	
	public Account(int accountID, int accountTypeID, double balance) {
		this.accountID = accountID;
		this.balance = balance;
		accountType = new AccountType(accountTypeID);
	}
	public Account(int accountTypeID, double balance) {
		this.accountID = accountID;
		this.balance = balance;
		accountType = new AccountType(accountTypeID);
	}
	@Override
	public String toString() {
		return accountType.getName() + " account. Balance=" + balance + ". ID: " + accountID + ".";
	}
	
	public void withdraw(double withdrawAmount) throws NotEnoughMoneyException {
		if (balance - withdrawAmount < accountType.getMinimumMoney()) {
			throw new NotEnoughMoneyException();
		}
		else {
		balance = (double) Math.round((balance-withdrawAmount) * 100) / 100;
		}
	}
	public void deposit(double depositAmount) {
		balance = (double) Math.round((balance+depositAmount) * 100) / 100;
	}
}
