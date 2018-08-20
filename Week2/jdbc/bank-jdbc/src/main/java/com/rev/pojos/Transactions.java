package com.rev.pojos;

public class Transactions {

	private int txId;
	private int accountId;
	private String timestamp;
	private double amount;
	private String description;
	
	public Transactions(int accountId, String timestamp, double amount, String description) {
		super();
		this.accountId = accountId;
		this.timestamp = timestamp;
		this.amount = amount;
		this.description = description;
	}

	
	public Transactions(int txId, int accountId, String timestamp, double amount, String description) {
		super();
		this.txId = txId;
		this.accountId = accountId;
		this.timestamp = timestamp;
		this.amount = amount;
		this.description = description;
	}


	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Transactions [txId=" + txId + ", accountId=" + accountId + ", timestamp=" + timestamp + ", amount="
				+ amount + ", description=" + description + "]";
	}

	
	
	
}
