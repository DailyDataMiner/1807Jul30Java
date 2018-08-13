package com.revature.project0.projectobjects;

public class AccountType {

	private int accountTypeID;
	private String name;
	private int minimumMoney;
	
	public int getMinimumMoney() {
		return minimumMoney;
	}
	public void setMinimumMoney(int minimumMoney) {
		this.minimumMoney = minimumMoney;
	}
	public int getAccountTypeID() {
		return accountTypeID;
	}
	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AccountType(int accountTypeID)
	{
		this.accountTypeID = accountTypeID;
		this.setAccountType();
	}
	private void setAccountType() {
		switch (accountTypeID) {
		case 1:
			this.name = "Checking";
			this.minimumMoney = 0;
			break;
		case 2:
			this.name = "Savings";
			this.minimumMoney = 0;
			break;
		default:
			System.out.println("Unfound account type");
		}
	}
	
}
