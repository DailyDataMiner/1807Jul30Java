package com.revature.model;

import java.sql.Timestamp;

public class RequestObj {
	
	private double amount;
	private String description;
	private String resolver;
	private String status;
	private String type;

	public RequestObj () {}
	
	public RequestObj(double amount, String description, String resolver, String status, String type) {
		super();
		this.amount = amount;
		this.description = description;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Request [amount=" + amount + ", description=" + description + ", resolver=" + resolver + ", status="
				+ status + ", type=" + type + "]";
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
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
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
}
