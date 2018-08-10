package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Account;
import oracle.jdbc.internal.OracleTypes;
import utils.ConnectionFactory;

public class AccountDAO implements DAO<Account, Integer> {
	
	public List<Account> findAllByCustomerId(int customerId) {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL Get_All_Customer_Account(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, customerId);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Account temp = new Account(rs.getInt(1), 
											rs.getDouble(2), 
											rs.getInt(3));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account save(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections auto commit after tx is complete
			// set false to do validations
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Account(Balance, CustomerId) VALUES(?, ?)";
			// code go get back auto generated PK
			// can also retrieve other auto generated keys(date stamps etc)
			String[] keys = {"AccountId"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, acc.getBalance());
			ps.setInt(2, acc.getCustomerId());
			// update returns number of rows updated
			// queries return result sets
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					acc.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findOne(Integer id) {
		Account acc = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Account WHERE AccountId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				acc.setId(data.getInt(1));
				acc.setBalance(data.getDouble(2));
				acc.setCustomerId(data.getInt(3));
			} else {
				System.out.println("account id does not match any in the DB");
				return null;
			}
		}   catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public Account update(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE Account SET Balance = ?, CustomerId = ? WHERE AccountId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, acc.getBalance());
			ps.setInt(2, acc.getCustomerId());
			ps.setInt(3, acc.getId());
			ps.executeUpdate();
		}   catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}

}
