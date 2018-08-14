package com.bank.pojos;

public class Account extends AccountAccountType  {

	private int accountid;
	private String account_number;
	private int userid;
	private String status;
	
	public Account() {
		super();
	}
	
	public Account(String account_number, int userid, String status) {
		super();
		this.account_number = account_number;
		this.userid = userid;
		this.status = status;
	}

	public Account(int accountid, String account_number, int userid, String status) {
		super();
		this.accountid = accountid;
		this.account_number = account_number;
		this.userid = userid;
		this.status = status;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", account_number=" + account_number + ", userid=" + userid
				+ ", status=" + status + "]";
	}
	
}
