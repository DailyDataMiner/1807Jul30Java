package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.MoneyAccount;
import com.rev.pojos.UserClient;
import com.rev.util.ConnectionFactory;

public class Customer_Account_RefDao implements Dao<UserClient, Integer> {

	@Override
	public List<UserClient> findAll() {
		List<UserClient> UserClients = new ArrayList<UserClient>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from UserClient order by name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
				UserClient temp = new UserClient();
				temp.setCustomerId(rs.getInt(1)); // can access cols of RS by either col name or id
				String name = rs.getString(2);
				temp.setUsername(name);
				UserClients.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UserClients;
	}

	@Override
	public UserClient findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserClient save(UserClient obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserClient update(UserClient obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public MoneyAccount getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
