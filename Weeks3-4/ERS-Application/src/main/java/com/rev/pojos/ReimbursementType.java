package com.rev.pojos;

public class ReimbursementType {
	
	private int reimbTypeID;
	private String reimbType;
	
	
	
	public ReimbursementType() {
		super();
	}



	public ReimbursementType(int reimbTypeID, String reimbType) {
		super();
		this.reimbTypeID = reimbTypeID;
		this.reimbType = reimbType;
	}



	public int getReimbTypeID() {
		return reimbTypeID;
	}



	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}



	public String getReimbType() {
		return reimbType;
	}



	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}



	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeID=" + reimbTypeID + ", reimbType=" + reimbType + "]";
	}
	
	
	

}
