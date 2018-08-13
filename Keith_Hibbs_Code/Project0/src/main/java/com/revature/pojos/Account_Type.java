package com.revature.pojos;

public class Account_Type {

	private static int account_type_id;
	private String name;
	
	public Account_Type() {};
	public Account_Type(String name) {
		super();
		this.name = name;
	}
	public Account_Type(int account_type_id, String name) {
		super();
		this.account_type_id = account_type_id;
		this.name = name;
	}
	public static int getAccountTypeId() {
		return account_type_id;
	}
	public void setAccount_type_id(int account_type_id) {
		this.account_type_id = account_type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}
	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	public static Object get(int accountTypeIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}