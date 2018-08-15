package com.rev.pojos;

public class CustomerAccount {
	
	private int CustomerID;
	private int AccountID;
	
	public CustomerAccount() {
	}

	public CustomerAccount(int customerid, int accountID) {
		this.CustomerID = customerid;
		this.AccountID = accountID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	@Override
	public String toString() {
		return "CustomerAccount [CustomerID=" + CustomerID + ", AccountID=" + AccountID + "]";
	}
	
	
	
	
	

}
