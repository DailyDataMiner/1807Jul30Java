package com.ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import com.ex.helpers.HelperFunctions;
import com.ex.pojos.Book;
import com.ex.util.ConnectionFactory;

public class BookDao extends HelperFunctions implements Dao<Book, Integer> {

	@Override
	public List<Book> findAll() {
		
		List<Book> booksList = new ArrayList<Book>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String select_query = "select book_id, isbn, title, price, genre_id, author_id from book";
			
									//Statement Obj.  //ResultSet
			ResultSet selectRS = conn.createStatement().executeQuery(select_query);
			
			while (selectRS.next()) {
				
				Book book = new Book(selectRS.getInt(1), 
									 selectRS.getString(2),
									 selectRS.getString(3),
									 selectRS.getDouble(4),
									 selectRS.getInt(5),
									 selectRS.getInt(5)
									);
				booksList.add(book);
				
//				booksList.add(new Book(	selectRS.getInt(1), 
//										selectRS.getString(2),
//										selectRS.getString(3),
//										selectRS.getDouble(4),
//										selectRS.getInt(5),
//										selectRS.getInt(5)
//									));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return booksList;
	}

	@Override
	public Book findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book save(Book obj) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String query = "insert into book " +
							"(ISBN, TITLE, PRICE, GENRE_ID, AUTHOR_ID) " +
							"values " +
							"( ?, ?, ?, ?, ? )";
			
			String[] autogen_keys = {"book_id"};
			
			PreparedStatement ps = conn.prepareStatement(query, autogen_keys);

//			print(autogen_keys.toString());
			
			ps.setString(1, obj.getIsbn());
			ps.setString(2, obj.getTitle());
			ps.setDouble(3, obj.getPrice());	// watch it this one, number (6, 2) in db
			ps.setInt(4, obj.getGenre_id());
			ps.setInt(5, obj.getAuthor_id());
			
			int rowsInserted = ps.executeUpdate();
			
			if (rowsInserted > 0) {
				
				// Get id genereated from db and add it (set it) to object id.
				ResultSet rsGenKeys = ps.getGeneratedKeys();
				
				while (rsGenKeys.next()) {
					
					print(rsGenKeys.toString());
					obj.setBook_id(rsGenKeys.getInt(1));
					
				}
				
				conn.commit();
				
			}
			
		} catch (SQLSyntaxErrorException ssee) {
//			ssee.printStackTrace();
			print("\n--- Something occured -> ");
			
			if (ssee.getMessage().contains("Could not commit with auto-commit set on")) {
				print("\t" + ssee.getMessage() + "    Data was added, but there was a problem, though...");
			} else {
				print("\t" + ssee.getMessage() + "    DATA WAS NOT ADDED\n");
			}
		}
			catch (SQLException se) {
//			e.printStackTrace();ssee.printStackTrace();
			print("\n--- Something occured -> ");
			print("\t" + se.getMessage() + "    DATA WAS NOT ADDED\n");
		}
		
		return obj;
	}

	@Override
	public Book update(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Book obj) {
		// TODO Auto-generated method stub
		
	}

}
