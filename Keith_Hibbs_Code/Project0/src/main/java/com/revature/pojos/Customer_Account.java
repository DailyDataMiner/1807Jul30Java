package com.revature.pojos;

public class Customer_Account {

	private int customer_id;
	private int account_id;
	
	public Customer_Account() {};
	
	public Customer_Account(int customer_id, int account_id) {
		super();
		this.customer_id = customer_id;
		this.account_id = account_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	
}
