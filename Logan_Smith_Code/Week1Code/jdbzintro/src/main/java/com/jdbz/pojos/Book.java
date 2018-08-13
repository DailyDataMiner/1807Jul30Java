package com.jdbz.pojos;

public class Book {
	
	private int id;
	private String title;
	private String ISBN;
	private double price;
	private int genreid;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getGenreid() {
		return genreid;
	}
	public void setGenreid(int genreid) {
		this.genreid = genreid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", price=" + price + ", genreid=" + genreid
				+ "]";
	}
	public Book() {};
	public Book(int id, String iSBN, String title, double price, int genreid) {
		super();
		this.id = id;
		this.title = title;
		ISBN = iSBN;
		this.price = price;
		this.genreid = genreid;
	}
	public Book(String iSBN, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		ISBN = iSBN;
		this.price = price;
		this.genreid = genreid;
	}
	
}