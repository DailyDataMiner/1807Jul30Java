package com.revature.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reimbursement {

	private int reimbbId;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;

	public Reimbursement(int reimbbId, double amount, String submitted, String resolved, String description, int author,
			int resolver, int statusID, int typeID) {
		super();
		this.reimbbId = reimbbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}

	public int getReimbbId() {
		return reimbbId;
	}

	public void setReimbbId(int reimbbId) {
		this.reimbbId = reimbbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Reimbursement() {}

}