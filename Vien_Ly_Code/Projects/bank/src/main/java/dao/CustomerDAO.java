package dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import beans.Customer;
import utils.ConnectionFactory;

public class CustomerDAO implements DAO<Customer, Integer> {

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Customer findOne(String username) {
		Customer c = new Customer();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Customer WHERE UserName = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet data = ps.executeQuery();
			while(data.next()) {
				c.setId(data.getInt(1));
				c.setFirstName(data.getString(2));
				c.setLastName(data.getString(3));
				c.setUsername(data.getString(4));
				c.setPasswordHash(data.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer save(Customer usr) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections auto commit after tx is complete
			// set false to do validations
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Customer(FirstName, LastName, UserName, PwdHash) VALUES(?, ?, ?, ?)";
			// code go get back auto generated PK
			// can also retrieve other auto generated keys(date stamps etc)
			String[] keys = {"CustomerId"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, usr.getFirstName());
			ps.setString(2, usr.getLastName());
			ps.setString(3, usr.getUsername());
			ps.setString(4, usr.getPasswordHash());
			// update returns number of rows updated
			// queries return result sets
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					usr.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usr;
	}

	@Override
	public Customer update(Customer usr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer usr) {
		// TODO Auto-generated method stub
		
	}

}
