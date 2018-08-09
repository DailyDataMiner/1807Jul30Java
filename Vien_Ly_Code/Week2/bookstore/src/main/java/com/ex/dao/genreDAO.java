package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class genreDAO {
	
	public static void main(String[] args) {
		
		List<Genre> genres = findAllGenres();
		for(Genre b : genres) {
			System.out.println(b);
		}
	}
	
	public static List<Genre> findAllGenres() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from genre";
			
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
}
