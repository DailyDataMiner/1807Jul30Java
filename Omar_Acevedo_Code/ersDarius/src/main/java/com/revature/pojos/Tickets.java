package com.revature.pojos;

public class Tickets {
	private String firstName;
	private String lastName;
	private double cash;
	private String submit;
	private String resolved;
	private String description;
	private String status;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Tickets(String firstName, String lastName, double cash, String submit, String resolved, String description,
			String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cash = cash;
		this.submit = submit;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
	}
	
	public Tickets() {}
	@Override
	public String toString() {
		return "tickets [firstName=" + firstName + ", lastName=" + lastName + ", cash=" + cash + ", submit=" + submit
				+ ", resolved=" + resolved + ", description=" + description + ", status=" + status + "]";
	}
	
	
	
}
