package com.rev.pojos;

public class Account {

	private int accountid;
	private int userid;
	private String accounttype;
	private double amount;

	public Account() {}

	public Account(int accountid, int userid, String accounttype, double amount) {
		super();
		this.accountid = accountid;
		this.userid = userid;
		this.accounttype = accounttype;
		this.amount = amount;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", userid=" + userid + ", accounttype=" + accounttype + ", amount="
				+ amount + "]";
	}
	
}
