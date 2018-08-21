package com.Rev.assoc.Proj0.pojos;

public class BankAccount {
	private int BAID;
	private String BAAccNAme;
	private String BAType;
	private double BABalance;
	private int BAUserID;

	public BankAccount() {}
	public BankAccount
	(int bAID, 
			double bABalance, 
			String bAAccNAme, 
			String bAType,
			int bAUserID) {
		super();
		BAID = bAID;
		BABalance = bABalance;
		BAAccNAme = bAAccNAme;
		BAType = bAType;
		BAUserID = bAUserID;
	}
	public int getBAID() {
		return BAID;
	}
	public void setBAID(int bAID) {
		BAID = bAID;
	}
	public double getBABalance() {
		return BABalance;
	}
	public void setBABalance(double bABalance) {
		BABalance = bABalance;
	}
	public String getBAAccNAme() {
		return BAAccNAme;
	}
	public void setBAAccNAme(String bAAccNAme) {
		BAAccNAme = bAAccNAme;
	}
	public String getBAType() {
		return BAType;
	}
	public void setBAType(String bAType) {
		BAType = bAType;
	}
	public int getBAUserID() {
		return BAUserID;
	}
	public void setBAUserID(int bAUserID) {
		BAUserID = bAUserID;
	}
	@Override
	public String toString() {
		return "BankAccount [BAID=" + BAID + ", BAAccNAme=" + BAAccNAme + ", BAType=" + BAType + ", BABalance="
				+ BABalance + ", BAUserID=" + BAUserID + "]";
	}
	
}
