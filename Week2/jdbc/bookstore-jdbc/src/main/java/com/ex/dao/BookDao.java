package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Book;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class BookDao implements Dao<Book, Integer>{

	@Override
	public List<Book> findAll() {
		/*
		 *  CALLABLE STATEMENT
		 *  - extends PreparedStatement
		 *  - allows us to execute stored procedures
		 *  - must REGISTER our IN and OUT parameter
		 *  values and types
		 *  - IN params will be set using setter methods
		 *  inherited from PreparedStatement
		 *  can return 1 or many ResultSet objects
		 *  
		 *  
		 *  ResultSet
		 *   - Table of data representing a DB resultset
		 *   generated by executing a SQL stmt
		 *   Maintains a cursor pointing to the current 
		 *   row (however, it is initially positioned
		 *   before the first row). The RS.next() method
		 *   moves that cursor to each subsequent row until
		 *   there are no more rows (returns false)		 */
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call get_all_books(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Book temp = new Book();
				temp.setId(rs.getInt("Book_Id"));
				temp.setIsbn(rs.getString("ISBN"));
				temp.setPrice(rs.getDouble("price"));
				temp.setTitle(rs.getString("Title"));
				temp.setGenreId(rs.getInt("Genre_Id"));
				books.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return books;
	}

	@Override
	public Book findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	// Book(id, isbn, title, price, g.getId());
	@Override
	public Book save(Book obj) {
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into book(isbn, title, price, genre_id) "
					+ "values(?,?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "book_id";
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getIsbn());
			ps.setString(2, obj.getTitle());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getGenreId());
			int rows = ps.executeUpdate();
			System.out.println(rows + " BOOKS ADDED");
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					int id = pk.getInt(1);
					obj.setId(id);
					System.out.println("BOOK ID IS " + id);
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Book update(Book obj) {
		try(Connection conn = ConnectionFactory.
				getInstance().getConnection()){
			String sql = "update book" + 
					"set title = ?, genre_id = ? " + 
					"where book_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  obj.getTitle());
			ps.setInt(2, obj.getGenreId());
			ps.setInt(3, obj.getGenreId());
			int rows = ps.executeUpdate();
			System.out.println(rows + " BOOKS UPDATED");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Book obj) {
		// TODO Auto-generated method stub
		
	}

}
