package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJOs.Book;
import Util.ConnectionFactory;
import oracle.jdbc.OracleTypes;

public class BookDAO implements Dao<Book, Integer> {
	public static void main(String[] args) {
		//Book book = findOne(1);
		//System.out.println(book);
		//Book tempt = new Book("G5", "Wumba", 7.54);
		//save(tempt);
	}
	
	/*
	 * Statement
	 * -takes an sql statement as a string, executes it, and returns the result
	 * -Allows sql injection so is bad to use
	 * 
	 * 
	 */
	
	public List<Book> findAll(){
		List<Book> Books = new ArrayList<Book>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String query = "{call getAllBooks(?)}";
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while (rs.next()) {
				Book temp = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
				//or rs.getString("Name"); Either col num or col name
				Books.add(temp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return Books;
	}
	
	// PREPARED STATEMENT
	/*
	 * -Executes a precompiled sql statement
	 * -Effecient for statements that will execute multiple times
	 */
	@Override
	public Book findOne(Integer i){
		Book oneBook = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from book where bookid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
			oneBook = new Book(info.getInt(1), info.getString(2), info.getString(3), info.getDouble(4), info.getInt(5));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return oneBook;
	}
	
	@Override
	public Book save(Book b) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "insert into Book(TITLE, ISBN, PRICE) values(?, ?, ?)";
			//get auto generated key
			
			
			String[] keys = {"Bookid"};
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getISBN());
			ps.setDouble(3, b.getPrice());
			
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
	public Book update(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Book obj) {
		// TODO Auto-generated method stub
		
	}
}
