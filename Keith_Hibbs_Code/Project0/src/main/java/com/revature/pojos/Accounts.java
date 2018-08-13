package com.revature.pojos;

public class Accounts {

	private int account_numb;
	private int routing_numb;
	private double bal;
	private int account_type_id;
	public String getBal;
	public int getRouting_numb;
	public String getAccount_Type;
	
	public Accounts() {};
	
	public Accounts(int routing_numb, double bal, int account_type_id) {
		super();
		this.routing_numb = routing_numb;
		this.bal = bal;
		this.account_type_id = account_type_id;
		
	}
	public Accounts(int account_numb, int routing_numb, double bal, int account_type_id) {
		super();
		this.account_numb = account_numb;
		this.routing_numb = routing_numb;
		this.bal = bal;
		this.account_type_id = account_type_id;
		
	}

	public int getAccount_numb() {
		return account_numb;
	}

	public void setAccount_numb(int account_numb) {
		this.account_numb = account_numb;
	}

	public int getRouting_numb() {
		return routing_numb;
	}

	public void setRouting_numb(int routing_numb) {
		this.routing_numb = routing_numb;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public int getAccount_type_id() {
		return account_type_id;
	}

	public void setAccount_type_id(int account_type_id) {
		this.account_type_id = account_type_id;
	}
	
	
}
