package com.rev.pojos;

public class ReimbursementStatus {
	
	private int reimbStatusID;
	private String reimbStatus;
	public ReimbursementStatus() {
		super();
	}
	public ReimbursementStatus(int reimbStatusID, String reimbStatus) {
		super();
		this.reimbStatusID = reimbStatusID;
		this.reimbStatus = reimbStatus;
	}
	public int getReimbStatusID() {
		return reimbStatusID;
	}
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatusID=" + reimbStatusID + ", reimbStatus=" + reimbStatus + "]";
	}
	
	

}
