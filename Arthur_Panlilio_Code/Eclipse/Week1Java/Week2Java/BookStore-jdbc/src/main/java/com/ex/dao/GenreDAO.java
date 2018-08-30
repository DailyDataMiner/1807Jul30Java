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

public class GenreDAO implements Dao<Genre, Integer> {
	

	/*
	 * Statement
	 * -takes an sql statement as a string, executes it, and returns the result
	 * -allows SQL injection is is bad to use. if you MUST, 
	 *  only use it with queries with no variables
	 */
	@Override
	public List<Genre> findAll(){
		List<Genre> genres = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Genre ORDER BY name asc";
			//Only use statements for get all.
			// STATEMENT INTERFACE NOT OBJECTS
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString("Name"));
				genres.add(temp);
			}
			
		} catch (SQLException e) {
			System.out.println("Doesn't exist lol");
		}
		return genres;
	}
	
	/*
	 * PREPARED STATEMENT
	 *  executes a recompiled SQL statement
	 *  efficient for statements that will execute multiple times
	 */
	@Override
	public Genre findOne(Integer id){
		Genre g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM genre WHERE genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				g = new Genre();
				g.setId(info.getInt(1));
				g.setName(info.getString(2));
			}
			
		} catch (SQLException e) {
			System.out.println("Doesn't exist lol");
		}
		return g;
	}
	
	@Override
	public Genre save(Genre g) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO genre (name) VALUES (?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"Genre_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, g.getName());
			
			//Updates return num rows added/updated/delted
			//Queries return result sets
			int numRowsAffect  = ps.executeUpdate();
			if(numRowsAffect > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
					g.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			
		}
		return g;
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
