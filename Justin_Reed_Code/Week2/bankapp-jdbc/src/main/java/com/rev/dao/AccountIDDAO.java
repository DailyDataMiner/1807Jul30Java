package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.rev.pojos.AccountID;
import com.rev.util.ConnectionFactory;

public class AccountIDDAO implements Dao<AccountID ,Integer>{

	@Override
	public List<AccountID> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountID findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountID save(AccountID obj) {
		
		int x;
		
		
		
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			

			x = obj.getAccType();
			String sql = "Insert Into AccountType(acc_name, acc_Type) values(?,?)"; 
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, obj.getAccName());
			
			ps.setInt(2, obj.getAccType() );
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
				
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		

	}

	@Override
	public AccountID update(AccountID obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountID obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountID insert(AccountID obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountID findOneID(AccountID obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
