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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}
}
