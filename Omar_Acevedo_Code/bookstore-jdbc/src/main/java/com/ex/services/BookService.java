package com.ex.services;

import java.util.List;

import com.ex.dao.BookDao;
import com.ex.pojos.Book;

public class BookService extends BookDao {
	
	public List<Book> getAllBooks() {
		return findAll();
	}
	
	public void addBook(Book b) {
		save(b);
	}
}
