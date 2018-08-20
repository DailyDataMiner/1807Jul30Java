package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.MoneyAccount;
import com.rev.pojos.UserClient;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class UserClientDao implements Dao<UserClient, Integer>{

	/*
	 * STATEMENT
	 * - takes an SQL statement as a string, executes it, 
	 * and returns the result
	 * - allows SQL injection so is bad to use. if you 
	 * MUST, only use it for queries with no variables
	 * 
	 */
	
	
	//Most sensitive part of the structure so NEVER INTERACT DIRECTLY BY USER
	//Retrieves all rows from UserClient
	public List<UserClient> findAll(){
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
	
	public boolean belongs(String s) {
		UserClient g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select password from UserClient where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ResultSet info = ps.executeQuery();
			
				while (info.next()) {
				g = new UserClient();
				g.setPassword(info.getString(1));
				}
			if (g.getPassword() == s) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	public boolean isUnique(String s) {
		UserClient g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select count(*) from UserClient where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				g = new UserClient();
				g.setDoesExist(info.getInt(1));
				}
			if (g.isDoesExist() == 1) {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
		
	}
	/*
	 * PREPARED STATEMENT
	 * - executes a pre-compiled SQL statement 
	 * - efficient for statements that will execute multiple times
	 */
	
	
	
	public UserClient findOne(Integer id){
		UserClient g = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from UserClient where UserClient_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			g = new UserClient();
			g.setCustomerId(info.getInt(1));
			g.setUsername(info.getString(2));
			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public UserClient save(UserClient g) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			/*
			 * connections automatically commit after tx is 
			 * complete/right before connection closes
			 * set to false to do some sort of validation
			 * before committing
			 */
			conn.setAutoCommit(false);
			String sql = "insert into UserClient(username, password) values(?,?)";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"CustomerId"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,g.getUsername());
			ps.setString(2,g.getPassword());
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
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


	@Override
	public UserClient update(UserClient obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
