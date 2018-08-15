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


	public static Transaction withdraw(Account accountObj, double p_transactionAmount) {
	
/*------------------------------------------------------------------------------------------*/
//		Insert transaction data using accountObj.
//		Type of transaction	=>	WITHDRAWAL
//		
//		We're going to pass in parameters to doTransaction function and receive a number.
//		:	date, transactionType, p_transactionAmount, accountObj.getAccount_accounttypeid()
/*------------------------------------------------------------------------------------------*/
		
		final String transactionType = TransactionType.WITHDRAWAL.toString();
		
		return doTransaction(accountObj, transactionType, p_transactionAmount);
		
	}
	
	
	public static Transaction deposit(Account accountObj, double p_transactionAmount) {

/*------------------------------------------------------------------------------------------*/
//		Insert transaction data using accountObj.
//		Type of transaction	=>	DEPOSIT
//		
//		We're going to pass in parameters to doTransaction function and receive a number.
//		:	date, transactionType, p_transactionAmount, accountObj.getAccount_accounttypeid()
/*------------------------------------------------------------------------------------------*/
		final String transactionType = TransactionType.DEPOSIT.toString();
		
		return doTransaction(accountObj, transactionType, p_transactionAmount);
		
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
	
	
	
	private static Transaction doTransaction(Account accountObj, String p_transactionType, double p_transactionAmount) {
		
		Transaction 		transactionObj = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			final String 	transactionType;
			double 			amount;
			double			newBalance;
			AccountDao 		accountDao = null;
			AccountAccountTypeDao	accountAccountTypeDao = null;
			int 			accountAccountTypeId;
			long 			millis;
			Date			date;
			
//			Set date
			millis = System.currentTimeMillis();  
	        date = new Date(millis);
	        
//			Transaction Type
//			transactionType = TransactionType.WITHDRAWAL.toString();
	        transactionType = p_transactionType;
	        
	        
//			Amount to WITHDRAW or DEPOSIT
			amount = p_transactionAmount;
			
			
//			Get id of the object/table that has the balance of the account
			accountAccountTypeId = accountObj.getAccount_accounttypeid();
			
//			Start sql
			String call_function = "{ ? = call doTransaction(?, ?, ?, ?)}";
			
			CallableStatement cs = conn.prepareCall(call_function);
			
			cs.registerOutParameter(1, Types.VARCHAR);			
			cs.setDate(2,	date);
			cs.setString(3,	transactionType);
			cs.setDouble(4,	amount);
			cs.setInt(5,  	accountAccountTypeId);
			
			cs.execute();
			
			int transactionId = cs.getInt(1);

			System.out.println("transaction id value -> " + transactionId);
			
//			Setting the transaction object
			transactionObj = new Transaction(transactionId, date.toString(), transactionType, amount, accountAccountTypeId);
			
			
//			Setting balance to account object
			accountObj.setBalance(amount);
			
			
//			Update account (obj) balance
			accountDao = new AccountDao();
			
			
//			Calling dao to update table to change account balance
			accountDao.updateBalance(accountObj, transactionType);
			
			accountAccountTypeDao = new AccountAccountTypeDao();
			newBalance = accountAccountTypeDao.getNewBalance(accountAccountTypeId);
			
			System.out.println("This is your new balance: $" + newBalance);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionObj;
		
	}

}
