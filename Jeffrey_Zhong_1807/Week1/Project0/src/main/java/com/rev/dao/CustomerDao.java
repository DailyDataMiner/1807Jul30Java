package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.main.Driver;
import com.rev.pojos.Customer;
import com.rev.util.ConnectionFactory;

public class CustomerDao implements Dao<Customer, Integer> {

	public static boolean loginConfirm(String username, String password) {
		List<Customer> customers = new ArrayList<Customer>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from customer";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Customer temp = new Customer();
				temp.setCustomerID(rs.getInt(1)); // can access cols of RS by either col name or id
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassword(rs.getString(5));
				customers.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
		for (Customer c : customers) {
			if (c.getUserName().equals(username) && c.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public static int getCustID(String username, String password) {
		List<Customer> customers = new ArrayList<Customer>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from customer";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Customer temp = new Customer();
				temp.setCustomerID(rs.getInt(1)); // can access cols of RS by either col name or id
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassword(rs.getString(5));
				customers.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
		for (Customer c : customers) {
			if (c.getUserName().equals(username) && c.getPassword().equals(password)) {
				return c.getCustomerID();
			}
		}
		return 5;
	}

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
	public Customer save(Customer obj) {
		Customer customer = new Customer();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String query = "Insert into Customer (First_name, Last_Name, User_name, Password) VALUES (?,?,?,?)";

			String[] keys = new String[1];
			keys[0] = "CustomerID";

			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getUserName());
			ps.setString(4, obj.getPassword());

			int rows = ps.executeUpdate();

			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					customer.setCustomerID(pk.getInt(1));
				}

				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("Values cannot be null. Please try again");
			Driver.loginMenu();
			e.printStackTrace();
		}
		System.out.println("Customer account created!");
		return customer;
	}

	@Override
	public Customer update(Customer obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer obj) {
		// TODO Auto-generated method stub

	}

}
