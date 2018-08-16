package com.ex.pojos;

public class accType {
	private int idUser;
	private int idAcct;
	private String type;
    
	
	public accType() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public accType( String type) {
		super();
		//this.id = id;
		this.type = type;
	}

	public String getType() {
		return type;  
	}

	public void setType(String type) {
		this.type = type;
	}

	public accType(int idUser, int idAcct, String type) {
		super();
		this.idUser = idUser;
		this.idAcct = idAcct;
		this.type = type;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdAcct() {
		return idAcct;
	}

	public void setIdAcct(int idAcct) {
		this.idAcct = idAcct;
	}
	
	
}
