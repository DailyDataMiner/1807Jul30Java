package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.main.Driver;
import com.rev.pojo.Client;
import com.rev.util.ConnectionFactory;

public class ClientDao {

	public boolean verify(String usr, String pwd) {
		List<Client> cl = new ArrayList<Client>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Client where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setString(2, pwd);
		
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				
				Client temp = new Client();
				temp.setUserid(info.getInt(1));
				
				temp.setFirstname(info.getString(2));
				temp.setLastname(info.getString(3));
				temp.setUsername(info.getString(4));
				temp.setPassword(info.getString(5));
				cl.add(temp);
			}
			
			if (cl.isEmpty()) { return false;}
			if (cl.get(0).getUsername().equals(usr) && cl.get(0).getPassword().equals(pwd)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean verify(String usr) {
		List<Client> cl = new ArrayList<Client>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select username from Client ";

			Statement ps = conn.createStatement();
			ResultSet info = ps.executeQuery(sql);

			while (info.next()) {
				if (info.getString(1).equals(usr)) {
					return true;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public Client addClient(Client k) {
		

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "Insert into Client (firstname, lastname, username, password) values (?,?,?,?)";
			
			conn.setAutoCommit(false);
			// retrieve the auto-generated account_id key.
			String[] key = { "UserId" };
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, k.getFirstname());
			ps.setString(2, k.getLastname());
			ps.setString(3, k.getUsername());
			ps.setString(4, k.getPassword());
			
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				
				ResultSet pk = ps.getGeneratedKeys();
				
				while (pk.next()) {
					
					k.setUserid(pk.getInt(1));

				}
				
			}
			conn.commit();

		} catch (SQLException e) {
			System.out.println("Please try again");
			Driver.menu();
		}
		return k;
	}
	
	public Client checkAcc(String usr, String pwd) {
		Client temp = new Client();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Client where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setString(2, pwd);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				temp.setUserid(info.getInt(1));
				temp.setFirstname(info.getString(2));
				temp.setLastname(info.getString(3));
				temp.setUsername(info.getString(4));
				temp.setPassword(info.getString(5));
			}

			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}
	
	public void delete(int id){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "delete from Client where userid = ?";

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
		

			ps.executeUpdate();

			conn.commit();

			System.out.println("Account nuked!!!");


		}

		catch (SQLException e) {

			e.printStackTrace();


		}
	}

}