package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJOs.Genre;
import Util.ConnectionFactory;

public class GenreDAO implements Dao<Genre, Integer> {

	public static void main(String[] args) {
		//List<Genre> genres = findAll();
		//for (Genre g : genres) {
		//	System.out.println(g.toString());
		//}
	}
	
	public List<Genre> findAll(){
		List<Genre> genres = new ArrayList<Genre>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from Genre order by name asc";
			
			// Statement Interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Genre temp = new Genre(rs.getInt(1), rs.getString(2));
				//or rs.getString("Name"); Either col num or col name
				genres.add(temp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
	
	@Override
	public Genre findOne(Integer i){
		Genre oneGenre = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Genre where Genreid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
			oneGenre = new Genre(info.getInt(1), info.getString(2));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return oneGenre;
	}
	
	@Override
	public Genre save(Genre b) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "insert into Genre(Name) values(?)";
			//get auto generated key
			
			
			String[] keys = {"Genreid"};
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, b.getName());
			
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
	public Genre update(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Genre obj) {
		// TODO Auto-generated method stub
		
	}
	
}
