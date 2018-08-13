package com.revature.project0.projectobjects;

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
		return "Account [accountID=" + accountID + ", accountType=" + accountType.getName() + ", balance=" + balance + "]";
	}
	
	public void withdraw(double withdrawAmount) {
		balance = balance-withdrawAmount;
	}
	public void deposit(double depositAmount) {
		balance = balance+depositAmount;
	}
}
