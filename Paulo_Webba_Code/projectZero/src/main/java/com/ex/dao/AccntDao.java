package com.ex.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.bank_account;

import com.ex.util.ConnectionFactory;

public class AccntDao implements InterDao<bank_account, Integer>{
	//static personService  pservice = new personService();
	
	public AccntDao(){};
	
	@Override
	public bank_account findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<bank_account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bank_account save(bank_account obj) {
		
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into Accnt(AccID,balance,personid) "+
			"values(accnt_seq.nextval,?,(user_seq.nextval-1))";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"AccID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, obj.getBalance());
			
			int numRowsAffected = ps.executeUpdate();
			//System.out.println("NumAFFECTED: " + numRowsAffected);
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					//System.out.println(pk.toString());
					obj.setId(pk.getInt(1));
				}
				conn.commit();
			}
			
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public bank_account update(bank_account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(bank_account obj) {
		// TODO Auto-generated method stub
		
	}


}
