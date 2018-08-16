package com.ex.pojos;

public class bank_account {
	
	private int id;
	//private String type;
	private double balance;
	private int userId;
	
	
	
	
	public bank_account() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	public bank_account(int id, double balance) {
		super();
		//this.type = type;
		this.id = id;
		this.balance = balance;
	}
	public bank_account(double balance, int personId) {
		super();
		//this.type = type;
		//this.id = id;
		this.balance = balance;
		this.userId = personId;
	}
    

	public bank_account(int id, double balance, int personId) {
		super();
		//this.type = type;
		this.id = id;
		this.balance = balance;
		this.userId = personId;
	}



//	@Override
//	public String toString() {
//		return "bank_account [accountID=" + id + ", type=" + type + ", balance=" + balance + ", personId="
//				+ personId + "]";
//	}


	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public int getId() {
		return id;
	}

   

	public int getUserId() {
		return userId;
	}



	public void setUserId(int personId) {
		this.userId = personId;
	}



	public void setId(int accountID) {
		this.id = accountID;
	}

	
	
	
}
