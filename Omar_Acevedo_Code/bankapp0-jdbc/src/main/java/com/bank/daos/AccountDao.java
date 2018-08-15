package com.bank.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bank.pojos.Account;
import com.bank.utils.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;


public class AccountDao implements Dao<Account, Integer> {

	
	@Override
	public Account create(Account accountObj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			// 	Set autocommit to false
			conn.setAutoCommit(false);
			
			
			// 	Insert query
			String insert_statement = "insert into P0_ACCOUNTS " +
										"(ACCOUNT_NUMBER, USERID, STATUS) " +
										"values " +
										"( ?, ?, ? )";
			
			// 	Autogenerated keys to represent from db insert
			String[] autogen_keys = {"ACCOUNTID"};
			
			
			// 	Prepare insert statement
			PreparedStatement ps = conn.prepareStatement(insert_statement, autogen_keys);
			
			
			// 	Prepare insert statement with getter values from Account object, 
			//	as prepared statement parameters
			ps.setString(1, accountObj.getAccount_number());
			ps.setInt(2, accountObj.getUserid());
			ps.setString(3, accountObj.getStatus());
			
			
			//	Execute insert statement and return number of rows added.
			int rowsInserted = ps.executeUpdate();
			
			if (rowsInserted > 0) {
				
				//	Get the results (such as ACCOUNTID pk) from database after insert statement was executed.
				ResultSet rs = ps.getGeneratedKeys();
				
				//	Loop over result(s) from insert.
				while ( rs.next() ) {
					
					//	Set id attribute of Person object
					accountObj.setAccountid(rs.getInt(1));
					
				}
				
				conn.commit();
				
			} // end if
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountObj;
		
	}

	@Override
	public Account read(Integer id) {
		
		Account accountObj = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String call_procedure = "{call accountinfo(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(call_procedure);
			
//			cs.registerOutParameter(1, id);	// throws error... nonono is an out param, and prc do not use out as first param.
			cs.setInt(1,  id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			
			
			// out cursor ?
			ResultSet rs = (ResultSet)cs.getObject(2); // out cursor ?
			
			while ( rs.next() ) {
				
				accountObj = new Account(rs.getInt("ACCOUNTID"), 
										 rs.getString("ACCOUNT_NUMBER"), 
										 rs.getInt("USERID"), 
										 rs.getString("STATUS"),
										 rs.getInt("ACCOUNT_ACCOUNTTYPEID"),// Needed for transactions (transactions table uses this as id as fk)
										 rs.getInt("ACCOUNTTYPESID"),		// id of account type
										 rs.getDouble("BALANCE"),
										 rs.getString("ACCOUNTTYPE"));
			
//				rs.getString("ACCOUNTTYPE") // name of account type
//				rs.getInt("ACCOUNT_ACCOUNTTYPEID")	// Do I need this?
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return accountObj;
	}

	@Override
	public Account update(Account obj) {
		
		int accountId = obj.getAccountid();
		int accountTypeId = obj.getAccounttypesid();
		double newBalance = obj.getBalance();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			
			String call_procedure = "{call updateAccountBlance(?, ?, ?)}";
			
			
			CallableStatement cs = conn.prepareCall(call_procedure);
			
			
			cs.setInt(1, accountId);
			cs.setInt(2,  accountTypeId);
			cs.setDouble(3,  newBalance);
			
			
			cs.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
