package com.revature.projectZero.POJO;

import com.revature.projectZero.Exceptions.InsufficientFundsException;

public class Account {
	private int accountId;
	private int userId;
	private int accountTypeId;
	private String accountName;
	private double balance;

	public Account(int userId, int accountTypeId, String accountName) {
		this.accountId = -1;
		this.userId = userId;
		this.accountTypeId = accountTypeId;
		this.accountName = accountName;
		this.balance = 0.0;
	}
	
	public Account(int accountId, int userId, int accountTypeId, String accountName, double balance) {
		this.accountId = accountId;
		this.userId = userId;
		this.accountTypeId = accountTypeId;
		this.accountName = accountName;
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount <= balance) {
			balance -= amount;
		} else {
			throw new InsufficientFundsException("Insufficient Funds");
		}
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", accountTypeId=" + accountTypeId
				+ ", accountName=" + accountName + ", balance=" + balance + "]";
	}

}
