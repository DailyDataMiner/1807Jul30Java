package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Genre;
import com.rev.util.ConnectionFactory;

//implements Dao<Genre, Integer>

public class GenreDAO {
	
	public static void main(String[] args) {
		//LETS SEE THIS WORK!
//		List<Genre> genres = findAll();
//		for(Genre g : genres) {
//			System.out.println(g);
//		}
		
//		System.out.println(findOne(3));
		
		save(null);
	}
	
	public List<Genre> findAll(){
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from genre";
			
			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row of result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1)); // can access cols of RS by either col name or id
				temp.setName(rs.getString("name")); //or rs.getString(2)  also works
				genres.add(temp);
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
	
	
	
	public Genre findOne(Integer id){
		Genre g = new Genre();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			g.setId(info.getInt(1));
			g.setName(info.getString(2));
			
			}			
		catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
//	public Genre save(Genre g) {
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			/*
//			 * connections automatically commit after tx is 
//			 * complete/right before connection closes
//			 * set to false to do some sort of validation
//			 * before committing
//			 */
//			conn.setAutoCommit(false);
//			String sql = "insert into genre(name) values(?)";
//			
//			//code to get back auto-generated PK (other columns can be auto generated too!)
//			String[] keys = {"Genre_ID"};
//			
//			PreparedStatement ps = conn.prepareStatement(sql, keys);
//			ps.setString(1, g.getName());
//			
//			//UPDATES return num rows added/updated/deleted
//			//QUERIES return result sets
//			int numRowsAffected = ps.executeUpdate();
//			if(numRowsAffected>0) {
//				ResultSet pk = ps.getGeneratedKeys();
//				while(pk.next()) {
//					System.out.println(pk.toString());
//					g.setId(pk.getInt(1));
//				}
//				
//				conn.commit();
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return g;
//	}
//
//
//	@Override
//	public Genre update(Genre obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void delete(Genre obj) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	public static Genre save(Genre obj) {
	Genre gen = new Genre();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String query = "insert into genre(name) " + "values(?)";
			
			String[] keys = new String[1];
			keys[0] = "genre_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
//			ps.setInt(1, obj.getId());
//			ps.setString(2, obj.getName());
			
			ps.setString(1, "qwerty7");
//			ps.setString(2, "qwerty2");
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					gen.setId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gen;
	}
	
}