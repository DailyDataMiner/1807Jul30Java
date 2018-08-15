package com.zero.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zero.pojos.Account;
import com.zero.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountDao implements Dao<Account, Integer> {

	@Override
	public List<Account> findAll() {
		return null;
	}

	@Override
	public Account findOne(Integer id) {
		Account a = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from Account where Account_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				a = new Account();
				a.setId(info.getInt(1));
				a.setType(info.getString(2));
				a.setBalance(info.getDouble(3));
				a.setUserid(info.getInt(4));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Account save(Account a) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			
			String sql = "insert into Account(type, balance, user_id) values(?, ?, ?)";
			
			String[] keys = {"Account_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, a.getType());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getUserid());
			
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					a.setId(pk.getInt(1));
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public Account update(Account a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update Account set type = ?, balance = ?, user_id = ? where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getType());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getUserid());
			ps.setInt(4, a.getId());
			int rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<Account> findSpecific(Integer id) {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()) {
			String sql = "{call findUsersAccounts(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				Account temp = new Account();
				temp.setId(rs.getInt("Account_ID"));
				temp.setType(rs.getString("Type"));
				temp.setBalance(rs.getDouble("Balance"));
				temp.setUserid(rs.getInt("User_ID"));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

}
