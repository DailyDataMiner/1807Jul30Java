package com.ex.pojos;

public class Book {

	private int book_id;  
	private String isbn;
	private String title;
	private double price;   
	private int genre_id;
	private int author_id;
	
	public Book() {}
	
	public Book(int book_id, String isbn, String title, double price, int genre_id, int author_id) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genre_id = genre_id;
		this.author_id = author_id;
	}
	
	public Book(String isbn, String title, double price, int genre_id, int author_id) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genre_id = genre_id;
		this.author_id = author_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", genre_id="
				+ genre_id + ", author_id=" + author_id + "]";
	}

}
