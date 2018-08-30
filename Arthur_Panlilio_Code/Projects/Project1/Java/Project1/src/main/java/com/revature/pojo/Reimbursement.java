package com.revature.pojo;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Arrays;

public class Reimbursement {
	
	private int id;
	private double amount;
	private LocalDate submitted;
	private LocalDate resolved;
	private String description;
	private String response;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
	
	private User authorData;
	private User resolverData;
	private String status;
	private String type;
	
	

	public Reimbursement() {
		
	}



	public Reimbursement(int id, double amount, LocalDate submitted, String description, int author, int statusId,
			int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int id, double amount, LocalDate submitted, LocalDate resolved, String description, int author, int resolver, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
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
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
	public User getAuthorData() {
		return authorData;
	}



	public void setAuthorData(User authorData) {
		this.authorData = authorData;
	}



	public User getResolverData() {
		return resolverData;
	}



	public void setResolverData(User resolverData) {
		this.resolverData = resolverData;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", Description=" + description  + ", author=" + author
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}

	
	
}
