package com.revature.model;

public class RequestObject {

	private double Amount;
	private String Description;
	private String Resolver;
	private int Type;
	
	public RequestObject () {}
	
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getResolver() {
		return Resolver;
	}
	public void setResolver(String resolver) {
		Resolver = resolver;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public RequestObject(int amount, String description, String resolver, int type) {
		super();
		Amount = amount;
		Description = description;
		Resolver = resolver;
		Type = type;
	}
	@Override
	public String toString() {
		return "RequestObject [Amount=" + Amount + ", Description=" + Description + ", Resolver=" + Resolver + ", Type="
				+ Type + "]";
	}
	
}
