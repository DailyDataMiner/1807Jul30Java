package com.ex.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reimbursement {

	private int rbID;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;

	public Reimbursement() {

	}

	public Reimbursement(int rbID, double amount, Timestamp submitted, Timestamp resolved, String description,
			Blob receipt, int author, int resolver, int statusID, int typeID) {
		super();
		this.rbID = rbID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}

	@Override
	public String toString() {
		return "Reimbursement [rbID=" + rbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusID=" + statusID + ", typeID=" + typeID + "]";
	}

	public int getRbID() {
		return rbID;
	}

	public void setRbID(int rbID) {
		this.rbID = rbID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
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

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

}
