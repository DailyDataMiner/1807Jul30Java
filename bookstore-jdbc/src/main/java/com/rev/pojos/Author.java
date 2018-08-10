package com.rev.pojos;

public class Author {
	
	private int id;
	private String firstname;
	private String lastname;
	private String bio;
	
	public Author() {}
	
	public Author(int id, String name) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", bio=" + bio + "]";
	}
}
