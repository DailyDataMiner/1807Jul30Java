package com.rev.pojo;

public class Account {

	private int  userid;
	private String accname;
	private String acctype;
	private double balance;
	
	
	public Account() {}

	public Account(int userid, String accname, String acctype) {
		super();
		this.userid = userid;
		this.accname = accname;
		this.acctype = acctype;
	}

	public Account(int userid, String accname, String acctype, double balance) {
		super();
		this.userid = userid;
		this.accname = accname;
		this.acctype = acctype;
		this.balance = balance;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getAccname() {
		return accname;
	}


	public void setAccname(String accname) {
		this.accname = accname;
	}


	public String getAcctype() {
		return acctype;
	}


	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "[Account Name = " + accname + ", Type = " + acctype + ", Balance = $" + balance
				+ "]";
	}
	
	
	
}
