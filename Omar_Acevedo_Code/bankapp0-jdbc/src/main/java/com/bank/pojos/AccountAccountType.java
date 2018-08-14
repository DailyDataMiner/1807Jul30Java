package com.bank.pojos;

public class AccountAccountType {
	
	private int account_accounttypeid;
	private int accountid;
	private int accounttypesid;
	private double balance;
	
	public AccountAccountType() {
		super();
	}
	
	public AccountAccountType(int accountid, int accounttypesid, double balance) {
		super();
		this.accountid = accountid;
		this.accounttypesid = accounttypesid;
		this.balance = balance;
	}
	
	public AccountAccountType(int account_accounttypeid, int accountid, int accounttypesid, double balance) {
		super();
		this.account_accounttypeid = account_accounttypeid;
		this.accountid = accountid;
		this.accounttypesid = accounttypesid;
		this.balance = balance;
	}

	public int getAccount_accounttypeid() {
		return account_accounttypeid;
	}

	public void setAccount_accounttypeid(int account_accounttypeid) {
		this.account_accounttypeid = account_accounttypeid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getAccounttypesid() {
		return accounttypesid;
	}

	public void setAccounttypesid(int accounttypesid) {
		this.accounttypesid = accounttypesid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountAccountType [account_accounttypeid=" + account_accounttypeid + ", accountid=" + accountid
				+ ", accounttypesid=" + accounttypesid + ", balance=" + balance + "]";
	}
	
}
