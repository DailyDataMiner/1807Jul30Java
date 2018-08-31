package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class UsersDao {

	// For login, need to verify that user exists
	public boolean verify(String usr, String pwd) {
		List<Users> cl = new ArrayList<Users>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from   where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setString(2, pwd);

			ResultSet info = ps.executeQuery();
			while (info.next()) {

				Users temp = new Users();
				temp.setId(info.getInt(1));
				temp.setFn(info.getString(2));
				temp.setLn(info.getString(3));
				temp.setUsername(info.getString(4));
				temp.setPassword(info.getString(5));
				cl.add(temp);
			}

			if (cl.isEmpty()) {
				return false;
			}
			if (cl.get(0).getUsername().equals(usr) && cl.get(0).getPassword().equals(pwd)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// Retrieve login object with info - returns object with stuff in it based on username 
	public Users checkAcc(String usr) {
		Users temp = new Users();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_Users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				temp.setId(info.getInt(1));
				temp.setUsername(info.getString(2));
				temp.setPassword(info.getString(3));
				temp.setFn(info.getString(4));
				temp.setLn(info.getString(5));
				temp.setEmail(info.getString(6));
				temp.setRoleid(info.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	
}
