package com.rev.pojos;

public class Deposit {
	
	private int accountid;
	private double amountToDeposit;
	
	public Deposit() {}
	
	public Deposit(int accountid, double amountToDeposit) {
		super();
		this.accountid = accountid;
		this.amountToDeposit = amountToDeposit;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public double getAmountToDeposit() {
		return amountToDeposit;
	}

	public void setAmountToDeposit(double amountToDeposit) {
		this.amountToDeposit = amountToDeposit;
	}

	@Override
	public String toString() {
		return "Deposit [accountid=" + accountid + ", amountToDeposit=" + amountToDeposit + "]";
	}
	
}
