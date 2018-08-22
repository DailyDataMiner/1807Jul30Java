package com.ex.service;

import com.ex.dao.BookDao;
import com.ex.dao.Dao;
import com.ex.pojos.Book;

public class BookService {
	// CALL BOOK DAO METHODS HERE
	static Dao bDao = new BookDao();
	Book addBook(Book b){
		//ISBN VALIDATION
		return (Book) bDao.save(b);
	}
	


}
