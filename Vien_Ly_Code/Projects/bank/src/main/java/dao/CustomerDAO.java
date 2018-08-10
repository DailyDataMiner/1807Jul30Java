package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Account;
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

	@Override
	public Customer save(Customer usr) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections auto commit after tx is complete
			// set false to do validations
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Customer(FirstName, LastName, UserName, PwdHash) values(?, ?, ?, ?)";
			// code go get back auto generated PK
			// can also retrieve other auto generated keys(date stamps etc)
			String[] keys = {"CustomerId"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, usr.getFirstName());
			System.out.println(usr.getFirstName());
			
			ps.setString(2, usr.getLastName());
			System.out.println(usr.getLastName());

			ps.setString(3, usr.getUsername());
			System.out.println(usr.getUsername());

			ps.setString(4, usr.getPasswordHash());
			System.out.println(usr.getPasswordHash());

			;
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
