package com.bank.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.time.LocalTime;
//import java.util.Date;
import java.util.List;

import com.bank.pojos.Account;
import com.bank.pojos.Transaction;
import com.bank.pojos.TransactionType;
import com.bank.utils.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class TransactionDao implements Dao<Transaction, Integer> {

	public static Transaction deposit(Account obj, double p_transactionAmount) {
		
		final String 	transactionType;
		double 			amount;
		Transaction 	transactionObj = null;
		AccountDao 		accountDao = null;
		int 			accountAccountTypeId;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
		
/*	
			 Insert transaction data (using obj)
			 Type of transactions ->
				WITHDRAWAL, DEPOSIT, TRANSFER ( CHECKING -> SAVINGS; SAVIGS -> CHECKING )
			
			 Pass in parameters to procedure that inserts (creates) transaction -> 
				date, transactionType, p_transactionAmount,  obj.getAccount_accounttypeid()
*/
			
			
			//	Set vars
			long millis = System.currentTimeMillis();  
	        Date date = new java.sql.Date(millis); 

			transactionType = TransactionType.DEPOSIT.toString();
			amount = p_transactionAmount;
			accountAccountTypeId = obj.getAccount_accounttypeid();
			
			
			//	Start sql
			String call_procedure = "{ ? = call depositMoney(?, ?, ?, ?)}";
			
			CallableStatement cs = conn.prepareCall(call_procedure);
			
			cs.registerOutParameter(1, Types.VARCHAR);			
			cs.setDate(2, date);
			cs.setString(3,  transactionType);
			cs.setDouble(4,  amount);
			cs.setInt(5,  accountAccountTypeId);
			
			cs.execute();
			
			int transactionId = cs.getInt(1);
// https://stackoverflow.com/questions/27860245/how-to-call-a-sql-function-from-preparedstatement
			
			
			System.out.println("transaction id value -> " + transactionId);
			
			
//			Setting the transaction object
			transactionObj = new Transaction(transactionId, date.toString(), transactionType, amount, accountAccountTypeId);
			
						
//			Setting balance to account object
			obj.setBalance(amount);
			
			
//			Update account (obj) balance
			accountDao = new AccountDao();
			
			
//			Calling dao to update table to change account balance
			accountDao.update(obj);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionObj;
	}
	
	@Override
	public Transaction create(Transaction obj) {
		
		return null;
	}

	@Override
	public Transaction read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction update(Transaction obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Transaction obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
