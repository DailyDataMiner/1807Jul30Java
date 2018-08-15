package com.zero.pojos;

public class Account {
	private int id;
	private String type;
	private double balance;
	private int userid;
	
	public Account() {}

	public Account(String type, double balance, int userid) {
		super();
		this.type = type;
		this.balance = balance;
		this.userid = userid;
	}

	public Account(int id, String type, double balance, int userid) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance +", userid=" + userid + "]";
	}
	
	
}
