package com.Rev.assoc.Proj0.pojos;

public class UserAcc {
	private int UID;
	private String UUsername;  
	private String UPass;
	private String UFirstName;
	private	String ULastName;
	private String UEmail;
	public UserAcc() {}
	public UserAcc(int uID, String uUsername, String uPass, String uFirstName, String uLastName, String uEmail) {
		super();
		UID = uID;
		UUsername = uUsername;
		UPass = uPass;
		UFirstName = uFirstName;
		ULastName = uLastName;
		UEmail = uEmail;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getUUsername() {
		return UUsername;
	}
	public void setUUsername(String uUsername) {
		UUsername = uUsername;
	}
	public String getUPass() {
		return UPass;
	}
	public void setUPass(String uPass) {
		UPass = uPass;
	}
	public String getUFirstName() {
		return UFirstName;
	}
	public void setUFirstName(String uFirstName) {
		UFirstName = uFirstName;
	}
	public String getULastName() {
		return ULastName;
	}
	public void setULastName(String uLastName) {
		ULastName = uLastName;
	}
	public String getUEmail() {
		return UEmail;
	}
	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}
	@Override
	public String toString() {
		return "UserAcc [UID=" + UID + ", UUsername=" + UUsername + ", UPass=" + UPass + ", UFirstName=" + UFirstName
				+ ", ULastName=" + ULastName + ", UEmail=" + UEmail + "]";
	}
	
}
	