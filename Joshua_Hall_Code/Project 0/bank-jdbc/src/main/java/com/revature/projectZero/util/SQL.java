package com.revature.projectZero.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {

	public static ResultSet queryDatabase(Connection conn, String query, Object... args) throws SQLException {
		CallableStatement cs = conn.prepareCall(query);
		final int numArgs = args.length;
		for (int i = 0; i < numArgs; i++) {
			switch (args[i].getClass().toString()) {
			case "class java.lang.String":
				cs.setString(i + 1, (String) args[i]);
				break;
			case "class java.lang.Integer":
				cs.setInt(i + 1, (int) args[i]);
				break;
			case "class java.lang.Double":
				cs.setDouble(i + 1, (double) args[i]);
				break;
			case "class java.lang.Boolean":
				cs.setBoolean(i + 1, (boolean) args[i]);
				break;
			default:
				throw new SQLException("Unsupported Argument (args[" + i + "]) in queryDatabase()");
			}
		}
		return cs.executeQuery();
	}

}
