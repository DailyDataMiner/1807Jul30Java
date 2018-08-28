package com.ers.pojos;

public class Reimbursement {

	private int ticket_id;
	private String ticket_status;
	private String created_on;	// date
	private String created_by;	// date
	private String name;
	private String description;	
	private double amount;
	private String resolver;
	private String resolved_on;	// date
	private String reimb_type;
	private String reimb_status;
	private String receipt;		// blob?
	private int reimbursement_id;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int ticket_id, String ticket_status, String created_on, String description, String reimb_type,
			double amount, String reimb_status, String resolver, String receipt) {
		super();
		this.ticket_id = ticket_id;
		this.ticket_status = ticket_status;
		this.created_on = created_on;
		this.description = description;
		this.reimb_type = reimb_type;
		this.amount = amount;
		this.resolver = resolver;
		this.reimb_status = reimb_status;
		this.receipt = receipt;
	}

	public Reimbursement(int ticket_id, String ticket_status, String created_on, String created_by, String name,
			String description, double amount, String resolver, String resolved_on, String reimb_type,
			String reimb_status, String receipt, int reimbursement_id) {
		super();
		this.ticket_id = ticket_id;
		this.ticket_status = ticket_status;
		this.created_on = created_on;
		this.created_by = created_by;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.resolver = resolver;
		this.resolved_on = resolved_on;
		this.reimb_type = reimb_type;
		this.reimb_status = reimb_status;
		this.receipt = receipt;
		this.reimbursement_id = reimbursement_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getResolved_on() {
		return resolved_on;
	}

	public void setResolved_on(String resolved_on) {
		this.resolved_on = resolved_on;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	@Override
	public String toString() {
		return "Reimbursement [ticket_id=" + ticket_id + ", ticket_status=" + ticket_status + ", created_on="
				+ created_on + ", created_by=" + created_by + ", name=" + name + ", description=" + description
				+ ", amount=" + amount + ", resolver=" + resolver + ", resolved_on=" + resolved_on + ", reimb_type="
				+ reimb_type + ", reimb_status=" + reimb_status + ", receipt=" + receipt + ", reimbursement_id="
				+ reimbursement_id + "]";
	}
	
}
