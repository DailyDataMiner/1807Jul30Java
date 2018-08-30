package com.ex.pojos;

public class Author {
	
	private int id;
	private String fName;
	private String lName;
	private String bio;
	
	
	public Author() {
	}


	public Author(int id, String fName, String lName, String bio) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.bio = bio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + ", bio=" + bio + "]";
	}

}
