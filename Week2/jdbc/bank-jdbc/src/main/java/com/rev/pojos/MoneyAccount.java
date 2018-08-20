package com.rev.pojos;

public class MoneyAccount {
	
	private int customerId;
	private double savingsbalance;
	private double checkingbalance;
	
	public MoneyAccount(double savingsbalance, double checkingbalance) {
		super();
		this.savingsbalance = savingsbalance;
		this.checkingbalance = checkingbalance;
	}
	
	public MoneyAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoneyAccount(int customerId, double savingsbalance, double checkingbalance) {
		super();
		this.customerId = customerId;
		this.savingsbalance = savingsbalance;
		this.checkingbalance = checkingbalance;
	}

	public int getcustomerId() {
		return customerId;
	}

	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getSavingsbalance() {
		return savingsbalance;
	}

	public void setSavingsbalance(double savingsbalance) {
		this.savingsbalance = savingsbalance;
	}

	public double getCheckingbalance() {
		return checkingbalance;
	}

	public void setCheckingbalance(double checkingbalance) {
		this.checkingbalance = checkingbalance;
	}

	@Override
	public String toString() {
		return "MoneyAccount [customerId=" + customerId + ", savingsbalance=" + savingsbalance + ", checkingbalance="
				+ checkingbalance + "]";
	}
	
	
	
	
	
	
	
	
	
}