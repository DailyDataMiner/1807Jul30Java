package com.bank.pojos;

public class Transaction {

	private int transactionid;
	
//	DateTime that transaction occurred.
	private String datetime;
	
//	Type of transaction -> WITHDRAWAL, DEPOSIT, TRANSFER ( CHECKING -> SAVINGS; SAVIGS -> CHECKING ).
	private String type;
	
//	Amount of money used in transaction ( whether a withdrawal, deposit, transfer ).
	private double amount;
	
//	Account that did the transaction.
	private int account_accounttypeid;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String datetime, String type, double amount, int account_accounttypeid) {
		super();
		this.datetime = datetime;
		this.type = type;
		this.amount = amount;
		this.account_accounttypeid = account_accounttypeid;
	}

	public Transaction(int transactionid, String datetime, String type, double amount, int account_accounttypeid) {
		super();
		this.transactionid = transactionid;
		this.datetime = datetime;
		this.type = type;
		this.amount = amount;
		this.account_accounttypeid = account_accounttypeid;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccount_accounttypeid() {
		return account_accounttypeid;
	}

	public void setAccount_accounttypeid(int account_accounttypeid) {
		this.account_accounttypeid = account_accounttypeid;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", datetime=" + datetime + ", type=" + type + ", amount="
				+ amount + ", account_accounttypeid=" + account_accounttypeid + "]";
	}
	
}
