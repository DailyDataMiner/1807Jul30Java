package com.revature.pojo;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Arrays;

public class Reimbursement {
	
	int id;
	double amount;
	LocalDate submitted;
	LocalDate resolved;
	String Description;
	Blob receipt;
	int author;
	int resolver;
	int statusId;
	int typeId;
	
	public Reimbursement() {
		
	}

	public Reimbursement(int id, double amount, LocalDate submitted, LocalDate resolved, String description,
			Blob receipt, int author, int resolver, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		Description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getSubmitted() {
		return submitted;
	}

	public void setSubmitted(LocalDate submitted) {
		this.submitted = submitted;
	}

	public LocalDate getResolved() {
		return resolved;
	}

	public void setResolved(LocalDate resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", Description=" + Description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}

	
	
}
