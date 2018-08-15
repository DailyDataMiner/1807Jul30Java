package com.rev.pojos;

public class Account {

	private int AccountID;
	private double balance;
	private int AccountTypeID;
	private String Type;

	public Account() {
	}

	public Account(int id, double bal, int accTID) {
		this.AccountID = id;
		this.balance = bal;
		this.AccountTypeID = accTID;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountTypeID() {
		return AccountTypeID;
	}

	public void setAccountTypeID(int accountTypeID) {
		AccountTypeID = accountTypeID;
	}

	@Override
	public String toString() {
		return "ID= " + AccountID + ", Balance= $" + balance;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}
