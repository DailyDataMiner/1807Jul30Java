package com.revature.project0.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.AccountType;
import com.revature.project0.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountTypeDAO {
	public List<AccountType> findAll() {
		List<AccountType> AccountTypes = new ArrayList<AccountType>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAllAccountTypes(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				AccountType temp = new AccountType(rs.getInt(1));
				// or rs.getString("Name"); Either col num or col name
				AccountTypes.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AccountTypes;
	}
}
