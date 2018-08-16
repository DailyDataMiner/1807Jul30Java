package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.Person;
import com.ex.pojos.accType;
import com.ex.util.ConnectionFactory;

public class AccTypeDao implements InterDao<accType,Integer>{

	@Override
	public accType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<accType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public accType save(accType obj) {
	     
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into accnttype(userID,accid, acctype) "+
			"values(user_seq.nextval-2,accnt_seq.nextval-1,?)";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"userID", "AccID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getType());
			
			int numRowsAffected = ps.executeUpdate();
			//System.out.println("NumAFFECTED: " + numRowsAffected);
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					//System.out.println(pk.toString());
					obj.setIdUser(pk.getInt(1));
					obj.setIdAcct(pk.getInt(2));
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
	public accType update(accType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(accType obj) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
