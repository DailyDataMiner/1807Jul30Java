package com.revature.pojo;

import java.sql.Date;

import com.revature.util.AccountType;

/**
 * The account pojo holds information
 * 
 * @author Arthur Panlilio
 *
 */
public class Account {
	
	private int accountId;
	private int userId;
	private double balance;
	private int accountTypeId;
	private Date lastUpdate;
	private AccountType myAccountType = null;
	
	


	public Account() {
		
	}


	public Account(int accountId, int userId, double balance, int accountTypeId, Date lastUpdate) {
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
		this.accountTypeId = accountTypeId;
		this.lastUpdate = lastUpdate;
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


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getAccountTypeId() {
		return accountTypeId;
	}


	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}


	public Date getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public AccountType getMyAccountType() {
		return myAccountType;
	}


	public void setMyAccountType(AccountType myAccountType) {
		this.myAccountType = myAccountType;
	}

	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + ", accountTypeId="
				+ accountTypeId + ", lastUpdate=" + lastUpdate + "]";
	}
	

}
