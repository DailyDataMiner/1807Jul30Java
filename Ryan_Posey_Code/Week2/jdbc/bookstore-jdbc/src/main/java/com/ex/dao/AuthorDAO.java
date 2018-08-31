package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Author;
import com.ex.util.ConnectionFactory;

public class AuthorDAO implements DAO<Author, Integer> {

	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<Author>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from Author order by name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
				Author temp = new Author();
				temp.setId(rs.getInt(1)); // can access cols of RS by either col name or id
				String firstname = rs.getString(2);
				temp.setFirstname(firstname);
				String lastname = rs.getString(3);
				temp.setLastname(lastname);
				String bio = rs.getString(4);
				temp.setBio(bio);
				authors.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	@Override
	public Author findOne(Integer id) {
		Author a = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from Author where Author_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				a = new Author();
				a.setId(info.getInt(1));
				a.setFirstname(info.getString(2));
				a.setLastname(info.getString(3));
				a.setBio(info.getString(4));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Author save(Author obj) {
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
