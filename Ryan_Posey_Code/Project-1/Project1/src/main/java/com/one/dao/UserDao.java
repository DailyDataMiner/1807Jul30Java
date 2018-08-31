package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.one.pojos.User;
import com.one.util.ConnectionFactory;

public class UserDao implements Dao<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from ers_users";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstname(rs.getString(4));
				temp.setLastname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRole_id(rs.getInt(7));
				users.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findOne(String username) {
		User temp = null;
        try(Connection conn = ConnectionFactory
                .getInstance().getConnection()){
            String sql = "select * from ers_users where ers_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery( );
            
        while(rs.next()) {
                temp = new User();
                temp.setId(rs.getInt(1));
                temp.setUsername(rs.getString(2));
                temp.setPassword(rs.getString(3));
                temp.setFirstname(rs.getString(4));
                temp.setLastname(rs.getString(5));
                temp.setEmail(rs.getString(6));
                temp.setRole_id(rs.getInt(7));
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

	@Override
	public User save(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}

}
