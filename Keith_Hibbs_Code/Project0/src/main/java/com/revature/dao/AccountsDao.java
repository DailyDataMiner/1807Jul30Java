package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojos.Accounts;
import com.revature.util.ConnectionFactory;

public class AccountsDao implements Dao<Accounts, Integer>{
	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Accounts findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
}
@Override
public Accounts save(Accounts obj) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		conn.setAutoCommit(false);
		String sql = "insert into Accounts(routing_numb, bal, account_type) values (?.?.?)";
		String[] keys = {"account_numb"};
		PreparedStatement ps = conn.prepareStatement(sql, keys);
		ps.setInt(1,  obj.getRouting_numb);
		ps.setString(2, obj.getBal);
		ps.setString(3,  obj.getAccount_Type);
		ps.executeUpdate();
		ResultSet pk =  ps.getGeneratedKeys();
		while (pk.next()) {
			obj.setAccount_numb(pk.getInt(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return obj;
		}

@Override
public Accounts update(Accounts obj) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete(Accounts obj) {
	// TODO Auto-generated method stub
	
}
	}


