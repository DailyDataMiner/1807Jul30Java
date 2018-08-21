package com.Rev.assoc.Proj0.ZeroNationalBank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.Rev.assoc.Proj0.DAO.BankAccountDao;
import com.Rev.assoc.Proj0.DAO.UserDao;
import com.Rev.assoc.Proj0.service.AccountService;
import com.Rev.assoc.Proj0.service.UserService;
import com.Rev.assoc.Proj0.util.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void testConnection() {
        Connection connection = null;
        try{
            connection = ConnectionFactory.getInstance().getConnection();
            if(connection != null) {
                System.out.println("Connection established! :slightly_smiling_face: ");
            }
         }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
      } 
	
	public static Scanner ZNBScanner = new Scanner(System.in);
	static UserService uServe = new UserService();
	public static UserDao idea = new UserDao();
	static AccountService aServer = new AccountService(); 
	static BankAccountDao ideac = new BankAccountDao();
	public static void main( String[] args ){
		// 
		/*
		 *tables
		 *Is the couch going to sit there forever  
		 */  
		//
		Connection connection = null;
		 try{
	            connection = ConnectionFactory.getInstance().getConnection();
	            if(connection != null) {
	                System.out.println("Connection established! :slightly_smiling_face: ");
	                
	            }
	         }finally {
	            if(connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
		 //aServer.updateBalance();
		//System.out.println(aServer.updateBalance());
		System.out.println( "Hello! Welcome to ZNB!" );
        menu();
    }
    
    static void menu() {
    	System.out.println("Please select a option:\n"
    			+ "1. Create a new account.\n"
    			+ "2. Login to an existing account. ");
    	int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(ZNBScanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 2 :)");
			menu();
		}
		switch(option) {
		case 1:
			uServe.createAccount();
		case 2:
			//idea.qp();
			//ideac.cutie();
			uServe.login();	
			aServer.addAccount();
			break;
		default:
			System.out.println("You must enter either 1 or 2");
			menu();
		}
		
		
		
		
    }
    
    
   
}
