package com.ex.service;

import java.util.List;

import com.ex.dao.BookDAO;
import com.ex.dao.Dao;
import com.ex.pojos.Book;

public class BookService {
	/*
	 * Service layer is business logic
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of  manipulation of data either pre or post dao method call should go here
	 */
	
	static Dao<Book, Integer> bDao = new BookDAO();
	
	public List<Book> getAll(){
		return bDao.findAll();
	}
	
	public Book save(Book b) {
		return bDao.save(b);
	}

}
