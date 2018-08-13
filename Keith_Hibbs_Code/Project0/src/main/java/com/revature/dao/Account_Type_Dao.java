package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojos.Account_Type;
import com.revature.util.ConnectionFactory;

public class Account_Type_Dao implements Dao<Account_Type, Integer>{


	@Override
	public List<Account_Type> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account_Type findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
}
	
	
	@Override
public Account_Type save(Account_Type obj) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	String sql = "insert into Account_type(account_type_id, name) values (?,?)";	
	String[] keys = {"account_type_id"};
	PreparedStatement ps = conn.prepareStatement(sql,keys);
	ps.setLong(1, obj.getAccountTypeId());
	ps.setString(2, obj.getName());
	ps.executeUpdate();
	ResultSet pk = ps.getGeneratedKeys();
	while(pk.next()) {
		obj.setId(pk.getInt(1));
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return obj;
}

	@Override
	public Account_Type update(Account_Type obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account_Type obj) {
		// TODO Auto-generated method stub
		
	}

	
		
		
	
}
