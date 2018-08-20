package com.rev.pojos;

public class MoneyAccount {
	
	private int accountId;
	private String accountType;
	private double balance;
	
	
	public MoneyAccount() {}


	public MoneyAccount(int accountId, String accountType, double balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "MoneyAccount [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	
	
	
	
	/*private int id;
	private String firstName;
	private String lastName;
	private String bio;
	
	public Author() {}
	
	public Author(String firstName, String lastName, String bio) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
	}

	public Author(int id, String firstName, String lastName, String bio) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio + "]";
	}
	*/
	
}