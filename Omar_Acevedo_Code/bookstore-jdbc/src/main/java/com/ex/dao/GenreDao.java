package com.ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.helpers.HelperFunctions;
import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class GenreDao extends HelperFunctions implements Dao<Genre, Integer> {
	
	@Override
	public List<Genre> findAll() {
		
		List<Genre> genreList = new ArrayList<Genre>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String query = "select genre_id, name from b_genre";
			
			//statement interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			print("this is working");
			
			while( rs.next() ) {
				
				Genre tempGenre = new Genre();
				
				tempGenre.setId(rs.getInt(1));
				tempGenre.setName(rs.getString(2));
				
				genreList.add(tempGenre);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return genreList;
	}

	@Override
	public Genre findOne(Integer id) {
		
		Genre g = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String query = "select * from b_genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				g = new Genre();
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return g;
	}

	@Override
	public Genre save(Genre obj) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String insert_query = "insert into "
					+ "b_genre (name) values (?)";
			
			String[] keys = {"genre_id"};
			
			PreparedStatement ps = conn.prepareStatement(insert_query, keys);
			
			// The 1 here represent the ? in the insert query.
			ps.setString(1,  obj.getName());
			
			// Updates return num rows added/updated/deleted
			// Queries return result sets
			int numRowsAffected = ps.executeUpdate();
			
			if ( numRowsAffected > 0 ) {
				ResultSet pk = ps.getGeneratedKeys();
				
				while ( pk.next() ) {
					
					print("inserted: " + pk.toString());
					obj.setId(pk.getInt(1));
					
				}
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
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
