package com.ex.main;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.ex.dao.AccTypeDao;
import com.ex.dao.AccntDao;
import com.ex.dao.userDao;
import com.ex.pojos.User;
import com.ex.pojos.accType;
import com.ex.pojos.bank_account;
import com.ex.util.ConnectionFactory;


public class banking_App {
	

	static boolean logged = false;
	static Scanner cin = new Scanner(System.in);
	public static boolean u_added =false;
    public static boolean a_added =false;
    public static boolean atype_added =false;
	
	public static void main(String[] args) throws Menuheading {
			
System.out.println("██████╗ ██╗ ██████╗██╗  ██╗██████╗  █████╗ ███╗   ██╗ ██████╗ ██████╗ ");
System.out.println("██╔══██╗██║██╔════╝██║ ██╔╝██╔══██╗██╔══██╗████╗  ██║██╔════╝██╔═══██╗");
System.out.println("██████╔╝██║██║     █████╔╝ ██████╔╝███████║██╔██╗ ██║██║     ██║   ██║");
System.out.println("██╔═══╝ ██║██║     ██╔═██╗ ██╔══██╗██╔══██║██║╚██╗██║██║     ██║   ██║");
System.out.println("██║     ██║╚██████╗██║  ██╗██████╔╝██║  ██║██║ ╚████║╚██████╗╚██████╔╝");
System.out.println("╚═╝     ╚═╝ ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═════╝ ");
System.out.println("                 The Right Place for your Mazuma!");
                                                menuHeading();
												beginning();
}
	
	
	static void beginning() {
	System.out.println("_____________________________\n");
	System.out.println(" New customer press [1]|");
	System.out.println("");
	System.out.println(" Returning customer press [2]|");
	System.out.println("");
	System.out.println(" Press 9 to log out   ________\n");
	System.out.println("____________________________\n");
	
	int option = 0;
	 try {
		option = Integer.parseInt(cin.nextLine());
	 }catch(NumberFormatException e) {
		if(option != 1 || option !=2)
		System.out.println("Sorry you must enter either number 1 or 2, or 9 to exit");
		beginning();
	    } 
	   switch(option) {
	    case 1:
	    	register();
	    	break;
	    case 2:
	    	logged = true;
	    	returning();
	    	break;
	    case 9:
	    	System.exit(0);
	    default:
	          
	    }
	}
	static void register() {
		   User u = null;
		   bank_account ba = null;
		   accType  atype = null;
	 	   System.out.println("Register here:");
		   //while(cin.hasNextLine()) {
		   System.out.println("");
		   System.out.println("Enter Firstname");
		   String first = cin.nextLine();
		   System.out.println("Enter Lastname:");
		   String last = cin.nextLine();
	       System.out.println ("Enter email:");
	       String email= cin.nextLine();
	       System.out.println ("Enter new Username:");
	       String newUsername= cin.nextLine();
	       System.out.println ("Enter new Password:");
	       String newPass= cin.nextLine();
	       System.out.println("Confirm Password:");
		   String password2 = cin.nextLine();
		   boolean checkpass = (newPass.equals(password2));
		   System.out.println("");
		   if(checkpass) {
			   u = new User(first,last,email,newUsername, newPass);
		       u_added = true;
		       } else { 
		    	             System.out.println("Passwords have to match. Reenter: ");                              
		           	          password2 = cin.nextLine();
		           	         
		                      if(newPass.equals(password2))
		                      { 
		                    	  u = new User(first,last,email,newUsername, newPass);
		           		           u_added = true;
		                    	 
		                      }
		                      else {
		                    	  System.out.println("Passwords do not match"); 
		                    	   register();
		                      }
		                      
		         }
		   
	     
	       // done with creating new person
	       //
	       System.out.println (" [[[[___ ]]]]]_[[[[ _]]]]] __[[[[[[ __ ]]]]]_ _ [[[[[[[_ _]]]]]] ____][[]_");
	       System.out.println("  ______________________ ENTER INITIAL DEPOSIT: ___________________________");
	       System.out.println (" [[[[___ ]]]]]_[[[[ _]]]]] __[[[[[[ __ ]]]]]_ _ [[[[[[[_ _]]]]]] ____][[]_");
           
	       
		   double balance = Double.parseDouble(cin.nextLine());
		   int useID = u.getId();
		   ba = new bank_account(balance, useID); 
	       a_added = true;
	       System.out.println (" [[[[___ ]]]]]_[[[[ _]]]]] __[[[[[[ __ ]]]]]_ _ [[[[[[[_ _]]]]]] ____][[]_");
	       System.out.println(" ________ CHOOSE TYPE: PRESS [1] FOR CHECKING AND [2] SAVINGS ____________ ");
	       System.out.println (" [[[[___ ]]]]]_[[[[ _]]]]] __[[[[[[ __ ]]]]]_ _ [[[[[[[_ _]]]]]] ____][[]_");
	       int option = 0; 
			String type ="";
			   try {
				     option = Integer.parseInt(cin.nextLine());
			    }catch(NumberFormatException e) {
			    	System.out.println("Sorry you must enter either 1 or 2");
			    	//register();
			    }
			   switch(option) {
			    case 1:
			    	type = "Checking";
			    	break;
			    case 2:
			    	type = "Savings";
			    	break;
			    default:
			          
			    }
			   int baID = ba.getId();
			    atype = new accType(u.getId(),baID,type);
		        atype_added = true;
	      
		       userDao usr = new userDao();
		       usr.save(u);
		       AccntDao acount = new AccntDao();
		       acount.save(ba);
		       AccTypeDao atpe = new AccTypeDao();
		       atpe.save(atype);
		       
	       System.out.println("Account successfully created.");
	       System.out.println("");
	       returning();
	}
	
	static void returning() {
	   if(logged == true)
	   System.out.println("Welcome back");
	   System.out.println("Sign in");
	   System.out.println("Enter your username:");
	   String usernamelogin = cin.nextLine();
	   
	   if(checkUsername(usernamelogin)) {
			
		     System.out.println("   ░░░░░░░░░░░░░░████░░░░░░░░░░░░░░ ");
			   System.out.println("   ░░░░░░░░▄▄████████▄▄░████░░░░░░░   THE");
					   System.out.println("   ░░░░░░▄██████████████████░░░░░░░  ");
							   System.out.println("   ░░░░░▄█████▀░░████▀██████░░░░░░░  ");
									   System.out.println("   ░░░░░██████░░░████░░▀████░░░░░░░        RIGHT ");
											   System.out.println("   ░░░░░███████▄▄████░░░▀███░░░░░░░");
													   System.out.println("   ░░░░░░████████████▄▄▄░░░░░░░░░░░             PLACE");
															   System.out.println("   ░░░░░░░▀███████████████▄░░░░░░░░");
																	   System.out.println("   ░░░░░░░░░░░▀▀████████████▄░░░░░░");
	 System.out.println("   ░░░░░███▄░░░░░████▀████████░░░░░");
			   System.out.println("   ░░░░░█████░░░░████░░▀██████░░░░░");
					   System.out.println("   ░░░░░██████▄░░████░░▄██████░░░░░");
							   System.out.println("   ░░░░░████████████████████▀░░░░░░      FOR");
									   System.out.println("   ░░░░░████░▀███████████▀▀░░░░░░░░             YOUR");
											   System.out.println("   ░░░░░▀▀▀░░░░░░████▀▀░░░░░░░░░░░░                  MAZUMA!!!!");
													   System.out.println("   ░░░░░░░░░░░░░░████░░░░░░░░░░░░░░");
	               System.out.println("			");
                   System.out.println("		ALMOST THERE, YOU MUST ENTER PASSWORD:");
                
	   }else {System.out.println(""); System.out.println("This username does not exist.");}
	   
	   String passlogin = cin.nextLine();
	   
	   if(checkPassword(passlogin)){
	    	logged =true; 
	       	System.out.println("logged in "); 
	    	afterLogin();
	    }else {
	        System.out.println("Password has been entered incorrectly!");	
	        returning();
	    }
	   
	}
	static boolean checkPassword(String pass) {
		User us = new User();
		boolean v =  false;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select pwd from bankuser where pwd= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			us = new User();
			us.setPwd(info.getString(1));
			}
		  }
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(us.getPwd().equals(pass))
			v = true;
		else { System.out.println("Password entered incorrectly. Please try again");
		       returning();
			
			};
	
		 return v;
		}
	static boolean checkUsername(String u)  {
	User us = null;
	boolean v =  false;
	try(Connection conn = ConnectionFactory
			.getInstance().getConnection()){
		String sql = "select username from bankuser where username= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u);
		ResultSet info = ps.executeQuery();
		while(info.next()) {
		us = new User();
		us.setUsername(info.getString(1));
		}
	  }
	catch (SQLException e) {
		e.printStackTrace();
	}
	try {
	if(us.getUsername().equals(u))
		v = true;
	else {
		System.out.println("Wrong Password!");
		returning();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	 return v;
}
	 static boolean alogin =false;
  static void afterLogin() {
	  if(!alogin) {
	  System.out.println("CHOOSE (1) Withdraw");
	  System.out.println("CHOOSE (2) Deposit");
	  System.out.println("CHOOSE (3) Check Balance");
	  System.out.println("CHOOSE (4) Add acount");
	  System.out.println("CHOOSE (5) return acounts");
	  System.out.println("CHOOSE (6) to exit");
	  alogin =true;
	  }
	 	int choice = 0;	
		 try {
			choice = Integer.parseInt(cin.nextLine());
		 }catch(NumberFormatException e) {
			//System.out.println("Sorry you must enter either number 1, 2, 3, 4, 5 or 6.");
			 if(alogin) {
				  System.out.println("CHOOSE (1) Withdraw");
				  System.out.println("CHOOSE (2) Deposit");
				  System.out.println("CHOOSE (3) Check Balance");
				  System.out.println("CHOOSE (4) Add acount");
				  System.out.println("CHOOSE (5) return acounts");
				  System.out.println("CHOOSE (6) to exit");
			  afterLogin();
			  }
		    } 
		   switch(choice) {
		    case 1:
		    	withdraw();
		    	break;
		    case 2:
		    	deposit();
		    	break;
		    case 3: 
		    	checkbalance();
		    case 4:
		    	addaccount();
		    case 5:
		    	accountsInfo();
		    case 6:
		    	System.out.println("Good bye!");
		    	System.exit(0);
		    default:
		    	  logged=false;
		    	 
		   }
		   
	}
  
   static void addaccount() {
	   System.out.println("Enter your username:");
	   String usernamelogin = cin.nextLine();
	   try {
	   if(checkUsername(usernamelogin)) {
		   System.out.println(" ENTER PASSWORD:");       
  }else {System.out.println(""); System.out.println("This username does not exist.");}
	   }catch(NullPointerException e) {
		   e.printStackTrace();
	   }
   String passlogin = cin.nextLine();
   System.out.println(checkPassword(passlogin)); 
   if(checkPassword(passlogin)) {
	   System.out.println("Good! One moment please.");
   }else {
       System.out.println("Password has been entered incorrectly!");	
       returning();
        }
   User person = null;
   int personid = 0;
	try(Connection conn = ConnectionFactory
			.getInstance().getConnection()){
		String sql = "select userid from bankuser where username= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, usernamelogin);
		ResultSet info = ps.executeQuery();
		while(info.next()){
		person = new User();
		person.setId(info.getInt(1));
		personid = person.getId();
		}
	}catch (SQLException e) {
		System.out.println("USER EXEPTION");
		e.printStackTrace();
	}
	
	System.out.println("Enter initial amount: ");
	 
	 double ammount = Double.parseDouble(cin.nextLine());
	
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "insert into accnt values(accnt_seq.nextval,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, ammount);
			ps.setInt(2, personid);
			ps.executeQuery();
		}catch (SQLException e) {
			System.out.println("ACCOUNT EXEPTION");
			e.printStackTrace();
		}
		 int countid= 0;
		 bank_account conta=null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sqrl = "select accid from accnt, bankuser b where b.username = ? and b.userid = personid";
			PreparedStatement ps = conn.prepareStatement(sqrl);
			ps.setString(1, usernamelogin);
			ResultSet info = ps.executeQuery();
			while(info.next()){
			conta = new bank_account();
			conta.setId(info.getInt(1));
			countid = conta.getId();
			}
		}catch (SQLException e) {
			System.out.println("USER EXEPTION");
			e.printStackTrace();
		}
		
		
		
		System.out.println("Enter Account Type:");
		String theType = cin.nextLine(); 
		 
			try(Connection conn = ConnectionFactory
					.getInstance().getConnection()){
				String sql = "insert into accnttype values(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, personid);
				ps.setInt(2, countid);
				ps.setString(3, theType);
				ps.executeQuery();
	
			}catch (SQLException e) {
				System.out.println("ACCOUNTTYPE EXEPTION");
				e.printStackTrace();
			}
           System.out.println("Additional account successfully created.");
           System.out.println("");
           afterLogin();
 }
   
  
   static void withdraw() {
	   System.out.println("Enter your username:");
	   String usernamelogin = cin.nextLine();
	   
	   if(checkUsername(usernamelogin)) {
		   System.out.println(" ENTER PASSWORD:");       
  }else {System.out.println(""); System.out.println("This username does not exist.");}
   String passlogin = cin.nextLine();
   System.out.println(checkPassword(passlogin)); 
   if(checkPassword(passlogin)) {
	   System.out.println("Good! One moment please.");
   }else {
       System.out.println("Password has been entered incorrectly!");	
       returning();
   }
	   
	   double newbal =0;
	   double currentbalance =0;
	   
		   bank_account conta = null;
			try(Connection conn = ConnectionFactory
					.getInstance().getConnection()){
				String sql = "select balance from accnt a, bankuser b where b.username= ? and b.userid = a.personid";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, usernamelogin);
				ResultSet info = ps.executeQuery();
				while(info.next()){
				conta = new bank_account();
				conta.setBalance(info.getDouble(1));
				currentbalance= conta.getBalance();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("");	
			System.out.println("YOUR CURRENT BALANCE IS: $" + currentbalance + '0');
			System.out.println("");	
			System.out.println("Enter amount to be withdrawn: ");
			double money = cin.nextDouble();
		     if(currentbalance >= money) {
		 			newbal = currentbalance - money; 
		 			 
			
        	try(Connection conn = ConnectionFactory
					.getInstance().getConnection()){
				String sql = "update (select balance from accnt a, bankuser b where b.username= ? and b.userid = a.personid) set balance=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, usernamelogin);
				ps.setDouble(2,newbal);
				ps.executeUpdate();
			    
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
        	System.out.println("YOU HAVE SUCCEFULLY WITHDRAWN MONEY");
        
        	}
		     else {System.out.println("NOT ENOUGH FUNDS! Press any nummber to go to main page or [1] to exit");
		  
		} 
	     System.out.println("");	
	        afterLogin();
		     
   }

   static void deposit() {
	   System.out.println("Enter your username:");
	   String usernamelogin = cin.nextLine();
	   
	   if(checkUsername(usernamelogin)) {
		   System.out.println(" ENTER PASSWORD:");       
  }else {System.out.println(""); System.out.println("This username does not exist.");}
   String passlogin = cin.nextLine();
   System.out.println(checkPassword(passlogin)); 
   if(checkPassword(passlogin)) {
	   System.out.println("Good! One moment please.");
   }else {
       System.out.println("Password has been entered incorrectly!");	
       returning();
   }
	   
	   double newbal =0;
	   double currentbalance =0;
	   
		   bank_account conta = null;
			try(Connection conn = ConnectionFactory
					.getInstance().getConnection()){
				String sql = "select balance from accnt a, bankuser b where b.username= ? and b.userid = a.personid";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, usernamelogin);
				ResultSet info = ps.executeQuery();
				while(info.next()){
				conta = new bank_account();
				conta.setBalance(info.getDouble(1));
				currentbalance= conta.getBalance();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("");	
			System.out.println("YOUR CURRENT BALANCE IS: $" + currentbalance + '0');
			System.out.println("");	
			System.out.println("Enter deposit amount: ");
			
			double money = cin.nextDouble();
		    
		 			newbal = currentbalance + money; 
		
			
        	try(Connection conn = ConnectionFactory
					.getInstance().getConnection()){
				String sql = "update (select balance from accnt a, bankuser b where b.username= ? and b.userid = a.personid) set balance=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, usernamelogin);
				ps.setDouble(2,newbal);
				ps.executeQuery();
			    
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
        
		    System.out.println("");	
	        afterLogin();
		     
   }
   
   static void menuHeading() throws Menuheading{
	   
	   try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "{call MenuHeading}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.executeQuery();
        }catch (SQLException e) {
		e.printStackTrace();
		}
	}
    	
   static void accountsInfo() 
   {
	   
	   System.out.println("Enter your username:");
	   String usernamelogin = cin.nextLine();
	   
	   if(checkUsername(usernamelogin)) {
		   System.out.println(" ENTER PASSWORD:");       
	   		}else {System.out.println(""); }
	   String passlogin = cin.nextLine();
	   System.out.println(checkPassword(passlogin)); 
	   if(checkPassword(passlogin)) {
	   System.out.println("Good! One moment please.");
	   System.out.println("");
	   		}else {
       System.out.println("Password has been entered incorrectly!");	
       returning();
        }

	String sql = "select current_date from dual";
	String c_dat = null;
	   try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
		   Statement stmt = conn.createStatement();
		   ResultSet rs = stmt.executeQuery(sql);
		   while(rs.next()) {
			 c_dat = rs.getString(1);
		   }
		}catch (SQLException e) {
			e.printStackTrace();
		}
	   System.out.println("The Current date is: " + c_dat);
	   
	   User cliente = null;
	   accType clint =null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String squl = "select distinct bu.firstname, bu.lastname, tp.acctype from bankuser bu inner join accnttype tp on tp.userid=bu.userid and bu.username=?";
			PreparedStatement ps = conn.prepareStatement(squl);
			ps.setString(1, usernamelogin);
			ResultSet info = ps.executeQuery();
			while(info.next()){
			cliente = new User();
			clint = new accType();
			cliente.setFirstname(info.getString(1));
			cliente.setLastname(info.getString(2));
			clint.setType(info.getString(3));
			System.out.println("Firstname: " + cliente.getFirstname());
			System.out.println("lastname: " + cliente.getLastname());
			System.out.println("Account Type: " + clint.getType());
			System.out.println("_ _ _ _ _ _ _ _ _ __ _ _ _ _ _ _ _");
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	   
		System.out.println("");	
        afterLogin();
   }
   

   
   static void checkbalance() {
	   double currentbalance =0;
	   System.out.println("Enter your username:");
	   String usernamelogin = cin.nextLine();
	   
	   if(checkUsername(usernamelogin)) {
		   System.out.println(" ENTER PASSWORD:");       
  }else {System.out.println(""); System.out.println("This username does not exist.");}
   String passlogin = cin.nextLine();
   System.out.println(checkPassword(passlogin)); 
   if(checkPassword(passlogin)) {
	   System.out.println("Good! One moment please.");
   }else {
       System.out.println("Password has been entered incorrectly!");	
       returning();
   }
	   bank_account conta = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select balance from accnt a, bankuser b where b.username= ? and b.userid = a.personid";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usernamelogin);
			ResultSet info = ps.executeQuery();
			while(info.next()){
			conta = new bank_account();
			conta.setBalance(info.getDouble(1));
			currentbalance= conta.getBalance();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("");	
		System.out.println("YOUR CURRENT BALANCE IS: $" + currentbalance + '0');
		System.out.println("");	
        afterLogin();
   }
    	
}
