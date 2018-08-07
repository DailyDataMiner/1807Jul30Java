package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
	static AtomicInteger idGenerator = new AtomicInteger();
	private User owner;
	private int accountNo;
	private double balance;
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(User owner, double balance) {
		this.owner = owner;
		this.accountNo = idGenerator.incrementAndGet();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [owner=" + owner + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}
}
