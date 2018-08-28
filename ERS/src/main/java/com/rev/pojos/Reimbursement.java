package com.rev.pojos;

public class Reimbursement {

	private int reimbId;
	private double reimbAmount;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private String reimbAuthor;
	private String reimbResolver;
	private String reimbStatusId;
	private String reimbTypeId;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbId, double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, String reimbAuthor, String reimbResolver, String reimbStatusId,
			String reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(String reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public String getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public String getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(String reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public String getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(String reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatusId="
				+ reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}
	
	
	
}
