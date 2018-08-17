package com.rev.pojos;

public class Account {
	
	private int accountID;
	private int userID;
	private int typeID;
	private double balance;
	
	
	public Account(int userID, int typeID) {
		super();
		this.userID = userID;
		this.typeID = typeID;
	}

	public Account(int userID,int typeID, int accountID, double balance) {
		super();
		this.accountID = accountID;
		this.userID = userID;
		this.typeID = typeID;
		this.balance = balance;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountName=" + ", userID=" + userID + ", typeID="
				+ typeID + ", balance=" + balance + "]";
	}
	

	
	
	

}
