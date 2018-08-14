package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rev.pojos.Account;
import com.rev.pojos.SavingsAccount;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class SavingsAccountDao {

	public static SavingsAccount save(SavingsAccount newSavingsAccount, User loggedInUser) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into savingsaccount(userid, amount) values (?, ?)";
			String[] keys = { "userid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setInt(1, loggedInUser.getUserid());
			ps.setInt(2, newSavingsAccount.getAmount());
			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();

//			while (pk.next()) {
//				obj.setAccountid(pk.getInt(1));
//			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return newSavingsAccount;
	}
	
}
