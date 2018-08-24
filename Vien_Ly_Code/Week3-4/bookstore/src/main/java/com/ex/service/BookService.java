package com.ex.service;

import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.bookDAO;
import com.ex.pojos.Book;

public class BookService {
	static DAO<Book, Integer> bDAO = new bookDAO();
	
	public List<Book> getAll() {
		return bDAO.getAll();
	}
	
	public Book save(Book b) {
		return bDAO.save(b);
	}
 }