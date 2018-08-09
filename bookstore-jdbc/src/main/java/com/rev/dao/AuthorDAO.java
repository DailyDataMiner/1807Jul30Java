package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Author;
import com.rev.util.ConnectionFactory;

public class AuthorDAO {
	
	public static List<Author> findAll(){
		List<Author> authors = new ArrayList<Author>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from author";
			
			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row of result set
				Author temp = new Author();
				temp.setId(rs.getInt(1)); // can access cols of RS by either col name or id
				temp.setName(rs.getString("Name")); //or rs.getString(2)  also works
				authors.add(temp);
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}
}