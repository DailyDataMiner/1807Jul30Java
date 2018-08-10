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

public class GenreDAO {
	
	public static void main(String[] args) {
		//LETS SEE THIS WORK!
		List<Genre> genres = findAll();
		for(Genre g : genres) {
			System.out.println(g);
		}
		
//		System.out.println(findOne(1));
	}
	
	public static List<Genre> findAll(){
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
	
	
	
	public static Genre findOne(int id){
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
	
	
	
}