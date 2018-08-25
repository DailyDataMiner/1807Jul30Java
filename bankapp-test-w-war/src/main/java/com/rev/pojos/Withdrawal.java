package com.rev.pojos;

public class Withdrawal {
	
	private int accountid;
	private double amountToWithdraw;
	
	public Withdrawal() {}

	public Withdrawal(int accountid, double amountToWithdraw) {
		super();
		this.accountid = accountid;
		this.amountToWithdraw = amountToWithdraw;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public double getAmountToWithdraw() {
		return amountToWithdraw;
	}

	public void setAmountToWithdraw(double amountToWithdraw) {
		this.amountToWithdraw = amountToWithdraw;
	}

	@Override
	public String toString() {
		return "Withdrawal [accountid=" + accountid + ", amountToWithdraw=" + amountToWithdraw + "]";
	}
	
}
