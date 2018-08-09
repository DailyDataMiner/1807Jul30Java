package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.Author;
import com.ex.util.ConnectionFactory;

public class authorDAO implements DAO<Author, Integer>{

	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections auto commit after tx is complete
			// set false to do validations
			conn.setAutoCommit(false);
			String sql = "insert into book(first_name, last_name, bio) values(?, ?, ?)";
			// code go get back auto generated PK
			// can also retrieve other auto generated keys(date stamps etc)
			String[] keys = {"Author_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,  a.getFirstName());
			ps.setString(2, a.getLastName());
			ps.setString(3, a.getBio());
			// update returns number of rows updated
			// queries return result sets
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
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
