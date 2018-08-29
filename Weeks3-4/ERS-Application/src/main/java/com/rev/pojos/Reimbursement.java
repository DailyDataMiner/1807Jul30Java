package com.rev.pojos;

import java.sql.Date;

public class Reimbursement {
	
	private int reimbID;
	private double amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private String receipt;
	private int author;
	private int resolver;
	private int reimbStatusID;
	private int reimbTypeID;
	
	public Reimbursement() {
		super();
	}
	public Reimbursement(int reimbID, double amount, Date submitted, Date resolved, String description, String receipt,
			int author, int resolver, int reimbStatusID, int reimbTypeID) {
		super();
		this.reimbID = reimbID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeID = reimbTypeID;
	}
	public int getReimbID() {
		return reimbID;
	}
	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getReimbStatusID() {
		return reimbStatusID;
	}
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	public int getReimbTypeID() {
		return reimbTypeID;
	}
	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", reimbStatusID=" + reimbStatusID + ", reimbTypeID=" + reimbTypeID + "]";
	}
	
	
	

}
