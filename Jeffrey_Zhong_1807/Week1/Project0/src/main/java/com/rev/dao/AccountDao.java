package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.rev.main.Driver;
import com.rev.pojos.Account;
import com.rev.service.AccountService;
import com.rev.util.ConnectionFactory;

public class AccountDao implements Dao<Account, Integer> {

	public static void depositFunds(int id, double funds) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call depositFunds(?,?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setDouble(2, funds);
			cs.executeUpdate();
			System.out.println("Succesfully Deposited!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void withdrawFunds(int id, double funds) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call withDrawFunds(?,?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setDouble(2, funds);
			cs.executeUpdate();
			System.out.println("Succesfully Withdrawed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void getCustAccount(int a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select AccountType.type, Account.AccountID, AccountType.type , Account.Balance From Customer Inner join CustomerAccount on Customer.CustomerID = CustomerAccount.CustomerID\r\n"
					+ "Inner Join Account ON CustomerAccount.AccountID = Account.AccountID Inner join AccountType ON Account.AccountTypeID = AccountType.AccounTypeID\r\n"
					+ "Where Customer.CustomerID = " + a + "";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				int ID = rs.getInt("AccountID");
				String Type = rs.getString("TYPE");
				Double Balance = rs.getDouble(3);
				System.out.println("AccountID: " + ID + "  " + Type + " Balance: " + Balance);

			}
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
	}

	public static void depositselectedaccount(int custID, int accountRow, double funds) {
		List<Account> accounts = new LinkedList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select AccountType.type, Account.AccountID, Account.Balance, Account.AccountTypeID From Customer Inner join CustomerAccount on Customer.CustomerID = CustomerAccount.CustomerID\r\n"
					+ "Inner Join Account ON CustomerAccount.AccountID = Account.AccountID Inner join AccountType ON Account.AccountTypeID = AccountType.AccounTypeID\r\n"
					+ "Where Customer.CustomerID = " + custID;

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Account temp = new Account();
				temp.setAccountID(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				temp.setAccountTypeID(rs.getInt(4));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
		int accID = 0;
		try {
		accID = (accounts.get(accountRow - 1)).getAccountID();
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Invalid input, Select a valid account");
			Driver.depositFundsAccountMenu();
		}
		depositFunds(accID, funds);
	}

	public static void withdrawselectedaccount(int custID, int accountRow, double funds) {
		List<Account> accounts = new LinkedList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select AccountType.type, Account.AccountID, Account.Balance, Account.AccountTypeID From Customer Inner join CustomerAccount on Customer.CustomerID = CustomerAccount.CustomerID\r\n"
					+ "Inner Join Account ON CustomerAccount.AccountID = Account.AccountID Inner join AccountType ON Account.AccountTypeID = AccountType.AccounTypeID\r\n"
					+ "Where Customer.CustomerID = " + custID;

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Account temp = new Account();
				temp.setAccountID(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				temp.setAccountTypeID(rs.getInt(4));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
		int accID= 0;
		double bal= 0.0;
		try {
		 accID = (accounts.get(accountRow - 1)).getAccountID();
		  bal = accounts.get(accountRow - 1).getBalance();
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Invalid input, Select a valid account");
			Driver.withdrawFundsAccountMenu();
			
		}
		if(funds > bal ){
			System.out.println("Not enough funds! Returning to main menu. \n");
			Driver.Menu();
		}
		withdrawFunds(accID, funds);
	}

	public static void transactionFindAll(int a) {

		List<Account> accounts = new LinkedList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select AccountType.type , Account.AccountID, Account.Balance, Account.AccountTypeID From Customer Inner join CustomerAccount on Customer.CustomerID = CustomerAccount.CustomerID\r\n"
					+ "Inner Join Account ON CustomerAccount.AccountID = Account.AccountID Inner join AccountType ON Account.AccountTypeID = AccountType.AccounTypeID\r\n"
					+ "Where Customer.CustomerID = " + a;

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 1;
			while (rs.next()) {
				// iterate through each row of result set
				Account temp = new Account();
				temp.setAccountID(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				temp.setAccountTypeID(rs.getInt(4));
				accounts.add(temp);
				
			}
			for(Account ac : accounts) {
				System.out.println(i + ". " + AccountService.convertTypeID(ac.getAccountTypeID())  + ac);
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
		

		}
//		for (int i = 0; i < accounts.size(); i ++) {
//			System.out.println(i+1 +"." +  +accounts.get(i));
	


	public List<Account> findAll() {
		return null;
	}

	@Override
	public Account findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account save(Account obj) {
		Account account = new Account();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String query = "Insert into Account (Balance, AccounttypeID) VALUES (?,?)";

			String[] keys = new String[1];
			keys[0] = "AccountID";

			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccountTypeID());

			int rows = ps.executeUpdate();

			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					account.setAccountID(pk.getInt(1));
				}

				conn.commit();
			}

			int customerID = com.rev.main.Driver.CustID;
			int accountID = account.getAccountID();

			String query2 = "Insert into CustomerAccount (CustomerID, AccountID) VALUES (" + customerID + ","
					+ accountID + ")";

			Statement statement = conn.createStatement();
			statement.executeQuery(query2);

			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					account.setAccountID(pk.getInt(1));
				}

				conn.commit();
			}
			conn.commit();


		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			Driver.loginMenu();
			e.printStackTrace();
		}
		System.out.println("Account Successfully Created!");
		return account;
	}

	@Override
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub

	}

}