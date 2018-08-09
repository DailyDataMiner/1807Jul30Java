package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class genreDAO implements DAO<Genre, Integer> {
	
//	public static void main(String[] args) {
////		System.out.println(findOne(1));
//		Genre temp = new Genre();
//		temp.setName("Culinary");
//		save(temp);
//		
////		List<Genre> genres = findAllGenres();
////		for(Genre b : genres) {
////			System.out.println(b);
////		}
//	}
	
	
	/*
	 * Statement
	 * - takes SQL statement as a string, executes, returns result
	 * - allows SQL injection so is bad to use
	 * - only use without variables in SQL statement
	 */
	
	public List<Genre> getAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from genre order by genre_id asc";
			
			//Statement interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				// iterate through the result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				genres.add(temp);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}
	
	/*
	 * Prepared statement
	 * - executes pre-compiled SQL statement
	 * - efficient for statements that will execute multiple times
	 */
	public Genre findOne(int id) {
		Genre g = new Genre();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			g.setId(info.getInt(1));
			g.setName(info.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}
	
	/*
	 * retrieve the Genre on POST to mainly check ID from sequencing
	 */
	public Genre save(Genre g) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections auto commit after tx is complete
			// set false to do validations
			conn.setAutoCommit(false);
			String sql = "insert into genre(name) values(?)";
			// code go get back auto generated PK
			// can also retrieve other auto generated keys(date stamps etc)
			String[] keys = {"Genre_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,  g.getName());
			// update returns number of rows updated
			// queries return result sets
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.getInt(1));
					g.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return g;
	}
	
	@Override
	public Genre findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre update(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Genre obj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
