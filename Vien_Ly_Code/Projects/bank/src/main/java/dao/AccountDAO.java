package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Account;
import utils.ConnectionFactory;

public class AccountDAO implements DAO<Account, Integer> {

	@Override
	public Account save(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections auto commit after tx is complete
			// set false to do validations
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Account(Balance) values(?)";
			// code go get back auto generated PK
			// can also retrieve other auto generated keys(date stamps etc)
			String[] keys = {"AccountId"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(4, acc.getBalance());
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
		// TODO Auto-generated method stub
		return null;
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
