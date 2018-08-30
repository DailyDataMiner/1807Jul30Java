package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Author;
import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class AuthorDAO implements Dao<Author, Integer> {
	
	@Override
	public List<Author> findAll(){
		List<Author> authors = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM author";
			
			// STATEMENT INTERFACE
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				//iterate through each row
				Author temp = new Author();
				temp.setId(rs.getInt(1));
				temp.setfName(rs.getString(2));
				temp.setlName(rs.getString(3));
				temp.setBio(rs.getString(4));
				authors.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}
	
	@Override
	public Author save(Author a) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO author (first_name,last_name,bio) VALUES (?,?,?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"author_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, a.getfName());
			ps.setString(2, a.getlName());
			ps.setString(3, a.getBio());
			
			//Updates return num rows added/updated/delted
			//Queries return result sets
			int numRowsAffect  = ps.executeUpdate();
			if(numRowsAffect > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
					a.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			
		}
		return a;
	}

	@Override
	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author update(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Author obj) {
		// TODO Auto-generated method stub
		
	}


}
