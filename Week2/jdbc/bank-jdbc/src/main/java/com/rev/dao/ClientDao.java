package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Client;
import com.rev.pojos.MoneyAccount;
import com.rev.pojos.UserClient;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ClientDao implements Dao<Client, Integer> {

	/*
	 * STATEMENT - takes an SQL statement as a string, executes it, and returns the
	 * result - allows SQL injection so is bad to use. if you MUST, only use it for
	 * queries with no variables
	 * 
	 */

	// Most sensitive part of the structure so NEVER INTERACT DIRECTLY BY USER

	// Retrieves all rows from Client
	public List<Client> findAll() {
		List<Client> Clients = new ArrayList<Client>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from Client order by name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Client temp = new Client();
				temp.setCustomerId(rs.getInt(1)); // can access cols of RS by either col name or id
				String name = rs.getString(2);
				temp.setFirstName(name);
				Clients.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Clients;
	}

	/*
	 * PREPARED STATEMENT - executes a pre-compiled SQL statement - efficient for
	 * statements that will execute multiple times
	 */
	public Client findOne(Integer id) {
		Client g = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Client where Client_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				g = new Client();
				g.setCustomerId(info.getInt(1));
				g.setFirstName(info.getString(2));
			}
			// more code
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public Client save(Client g) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			/*
			 * connections automatically commit after tx is complete/right before connection
			 * closes set to false to do some sort of validation before committing
			 */
			conn.setAutoCommit(false);
			String sql = "insert into Client(firstname, lastname, streetaddress, city, state, country, email) values(?,?,?,?,?,?,?)";

			// code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = { "customerId" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, g.getFirstName());
			ps.setString(2, g.getLastName());
			ps.setString(3, g.getStreetAddress());
			ps.setString(4, g.getCity());
			ps.setString(5, g.getState());
			ps.setString(6, g.getCountry());
			ps.setString(7, g.getEmail());

			int rows = ps.executeUpdate();

			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				
				while (pk.next()) {
					g.setCustomerId(pk.getInt(1));
				}

				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return g;
	}

	// find max
	public int getMax() {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "{call get_max_custid(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();

			int pr = cs.getInt(1);

			// ResultSet rs = (ResultSet) cs.getObject(1); // out cursor

			return pr;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Client update(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnique(String s) {
		UserClient g = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select count(*) from UserClient where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				g = new UserClient();
				g.setDoesExist(info.getInt(1));
			}
			if (g.isDoesExist() == 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}

}
