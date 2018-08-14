package com.rev.pojos;

public class SavingsAccount {

	private int accountid;
	private int userid;
	private int amount;
	
	public SavingsAccount() {}

	public SavingsAccount(int accountid, int userid, int amount) {
		super();
		this.accountid = accountid;
		this.userid = userid;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SavingsAccount [accountid=" + accountid + ", userid=" + userid + ", amount=" + amount + "]";
	}

}