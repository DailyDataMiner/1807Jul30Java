package com.revature.pojos;

public class Account {
	private int accountid;
	private double balance;
	private String accountType;

	
	public Account() {
	}
	public Account(int accountid, double balance) {
		super();
		 
		this.accountid = accountid;
		this.balance = balance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccounType(String accounType) {
		this.accountType = accounType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return accountType + " Account # " + accountid  + ": $ " + balance;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

}