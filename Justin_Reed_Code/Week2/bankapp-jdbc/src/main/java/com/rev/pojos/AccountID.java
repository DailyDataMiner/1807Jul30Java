package com.rev.pojos;

public class AccountID {
	private int typeID;
	private String accName;
	private int accType;
	
	
	
	public AccountID(String accName,int accType) {
		super();
		this.accType = accType;
		this.accName = accName;
	}
	public AccountID(int typeID, String accName, int accType) {
		super();
		this.typeID = typeID;
		this.accName = accName;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getAccType() {
		return accType;
	}
	public void setAccType(int accType) {
		this.accType = accType;
	}
	@Override
	public String toString() {
		return "AccountID [typeID=" + typeID + ", accName=" + accName + "]";
	}
	
	

}
