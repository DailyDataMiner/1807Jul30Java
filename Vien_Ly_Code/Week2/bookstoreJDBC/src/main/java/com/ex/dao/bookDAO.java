package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Book;
import com.ex.util.ConnectionFactory;

public class bookDAO {
	
	public static void main(String[] args) {
		
		List<Book> books = findAllBooks();
		for(Book b : books) {
			System.out.println(b);
		}
	}
	
	public static List<Book> findAllBooks() {
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from book";
			
			//Statement interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				// iterate through the result set
				Book temp = new Book();
				temp.setId(rs.getInt(1));
				temp.setIsbn(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setPrice(rs.getDouble(4));
				books.add(temp);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
}
