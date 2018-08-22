package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJOs.Author;
import Util.ConnectionFactory;

public class AuthorDAO implements Dao<Author, Integer> {

	public static void main(String[] args) {
		//Author tempter = new Author("Sarah", "Maas", "Why do I write?");
		//save(tempter);
		AuthorDAO ad = new AuthorDAO();
		
		System.out.println(ad.findOne(1));
	}
	
	@Override
	public List<Author> findAll(){
		List<Author> Authors = new ArrayList<Author>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from Author";
			
			// Statement Interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Author temp = new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				//or rs.getString("Name"); Either col num or col name
				Authors.add(temp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return Authors;
	}
	
	@Override
	public Author findOne(Integer i){
		Author oneAuthor = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Author where Authorid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
			oneAuthor = new Author(info.getInt(1), info.getString(2), info.getString(3), info.getString(4));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return oneAuthor;
	}
	
	@Override
	public Author save(Author b) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "insert into Author(FirstName, LastName, Bio) values(?, ?, ?)";
			//get auto generated key
			
			
			String[] keys = {"Authorid"};
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, b.getFirstName());
			ps.setString(2, b.getLastName());
			ps.setString(3, b.getBio());
			
			//update returns numrows affected
			int numrows = ps.executeUpdate();
			if (numrows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					System.out.println(pk.toString());
					b.setId(pk.getInt(1));
				}
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
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