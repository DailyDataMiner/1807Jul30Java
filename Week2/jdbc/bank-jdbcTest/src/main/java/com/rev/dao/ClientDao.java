package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Client;
import com.rev.util.ConnectionFactory;

public class ClientDao implements Dao<Client, Integer>{

	/*
	 * STATEMENT
	 * - takes an SQL statement as a string, executes it, 
	 * and returns the result
	 * - allows SQL injection so is bad to use. if you 
	 * MUST, only use it for queries with no variables
	 * 
	 */
	
	
	//Most sensitive part of the structure so NEVER INTERACT DIRECTLY BY USER
	
	
	//Retrieves all rows from Client
	public List<Client> findAll(){
		List<Client> Clients = new ArrayList<Client>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from Client order by name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
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
	 * PREPARED STATEMENT
	 * - executes a pre-compiled SQL statement 
	 * - efficient for statements that will execute multiple times
	 */
	public Client findOne(Integer id){
		Client g = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from Client where Client_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			g = new Client();
			g.setCustomerId(info.getInt(1));
			g.setFirstName(info.getString(2));
			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public Client save(Client g) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			/*
			 * connections automatically commit after tx is 
			 * complete/right before connection closes
			 * set to false to do some sort of validation
			 * before committing
			 */
			conn.setAutoCommit(false);
			String sql = "insert into Client(name) values(?)";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"Client_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,g.getFirstName() + " " + g.getLastName());
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
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
	public Client update(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub
		
	}

}
