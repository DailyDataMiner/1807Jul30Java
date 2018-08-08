package com.ex.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.pojos.Genre;

public class GenreDAO {
	
	public static void main(String[] args) {
		List<Genre> genres = findAll();
		for (Genre g : genres) {
			System.out.println(g);
		}
	}
	
	public static List<Genre> findAll() {
		List<Genre> genres = new ArrayList<Genre>();
		
		try (Connection conn = 
				ConnectionFactory.getInstance().getConnection()) {
			
			String query = "select * frmo genre";
			// STATEMENT INTERFACE
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				// iterate through each row of result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));	// 1 is the first column, 2 is the second, ... and so on...
				temp.setName(rs.getString(2));
//				temp.setName(rs.getString("Name")); // "Name" gets the column name "Name" 
				genres.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
