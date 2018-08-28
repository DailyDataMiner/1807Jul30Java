package com.ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyClass {

	public void doSomethingHere() {
		
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			Statement stmt = conn.createStatement();
			
			ResultSet results = stmt.executeQuery("select ticket_id, ticket_type, description, amount from v_tickets_reimbursements");
			
			if (results.next()) {
				System.out.println(results.getInt(1));
				System.out.println(results.getString(2));
				System.out.println(results.getString(3));
				System.out.println(results.getDouble(4));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		MyClass myobj = new MyClass();
		myobj.doSomethingHere();
	}
	
}
