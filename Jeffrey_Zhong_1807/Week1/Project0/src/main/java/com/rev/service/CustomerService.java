package com.rev.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rev.dao.CustomerDao;
import com.rev.main.Driver;
import com.rev.pojos.Customer;
import com.rev.util.ConnectionFactory;

public class CustomerService {
	static Scanner newCustFn = new Scanner(System.in);
	static Scanner newCustLn = new Scanner(System.in);
	static Scanner newCustUn = new Scanner(System.in);
	static Scanner newCustPw = new Scanner(System.in);
	
//	
//	public static boolean confirmLog(String username, String password) {
//
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String query = "Select user_name, password from customer where user_name = '"+ username + "' AND password = '"+ password +"'";
//
//			// STATEMENT INTERFACE
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(query);
//
//			while (rs.next()) {
//
//				if (username == rs.getString(1) && password == rs.getString(2)) {
//					return true;
//				}
//			}
//			return false;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	
//	getCustID()
	
	
	
	public static void makeNewCustomer() {
		CustomerDao CD = new CustomerDao();
		
		String password;
		String firstname;
		String lastname;
		
		System.out.println("--------Create User---------");
		System.out.println("Enter Username: ");
		String username = newCustUn.nextLine();
		if (checkDupUsername(username) == true) {
			
			System.out.println("Username already exists! Please choose new username");

			makeNewCustomer();
			
		}
		else {
		
		System.out.println("Enter Password: ");
		password = newCustPw.nextLine();
	
		
		
		
		System.out.println("Enter Firstname: ");
		firstname = newCustFn.nextLine();
		System.out.println("Enter Lastname ");
		lastname = newCustLn.nextLine();
		
		
		if (lastname == null || firstname==null ||  password==null ||  username==null) {
			System.out.println("Values cannot be empty. Try again");
			Driver.loginMenu();
		}
		else {
			
		
		
		Customer temp = new Customer();
		temp.setUserName(username);
		temp.setPassword(password);
		temp.setFirstName(firstname);
		temp.setLastName(lastname);
		
	
		CD.save(temp);
		}
		}
		
	}
	
	public static boolean checkDupUsername(String username) {
		List<Customer> customers = new ArrayList<Customer>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from customer";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Customer temp = new Customer();
				temp.setCustomerID(rs.getInt(1)); // can access cols of RS by either col name or id
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassword(rs.getString(5));
				customers.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Customer c : customers) {
			if (c.getUserName().equals(username)){
				return true;
			}
		}
		return false;
	}
		
	

}
