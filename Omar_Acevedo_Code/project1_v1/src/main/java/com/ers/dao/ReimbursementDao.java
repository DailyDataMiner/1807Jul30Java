package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.pojos.Reimbursement;
import com.ers.utils.ConnectionFactory;

public class ReimbursementDao implements Dao<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> readAll() {
		
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql 	= "select ";
				   sql  +=  "TICKET_ID, TICKET_STATUS, CREATED_ON, " +
		   					"DESCRIPTION, REIMB_TYPE, AMOUNT, REIMB_STATUS, " +
		   					"RESOLVER, RECEIPT ";
				   sql  += "from v_tickets_reimbursements";
			
		    
		   Statement sqlStmt = conn.createStatement();
		   ResultSet sqlResult = sqlStmt.executeQuery(sql);
		   
		   while (sqlResult.next()) {
			   
			   reimbList.add(new Reimbursement(
					   sqlResult.getInt("TICKET_ID"),
					   sqlResult.getString("TICKET_STATUS"),
					   sqlResult.getString("CREATED_ON"), 	// getDate...?
					   sqlResult.getString("DESCRIPTION"),
					   sqlResult.getString("REIMB_TYPE"),
					   sqlResult.getDouble("AMOUNT"),
					   sqlResult.getString("REIMB_STATUS"),
					   sqlResult.getString("RESOLVER"),
					   null
//					   sqlResult.getBlob("RECEIPT").toString()		// blob or string?
					));
			   
		   }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbList;
	}

	@Override
	public void create(Reimbursement reimbObj) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			CallableStatement cs = conn.prepareCall("{ call CREATE_TICKET_REIMBURSEMENT( ?, ?, ?, ?, ?, ? ) }");
			
			System.out.println("-> " + reimbObj.toString());
			
			// first param will be current user id
			// user id must come from obj, which will have (logged) user id who sent the post request
			cs.setInt(1, 2);
			
			
			// second param will be description
			cs.setString(2, reimbObj.getDescription());
			
			
			// third param will be amount
			cs.setDouble(3, reimbObj.getAmount()); // or setInt...?
			
			
			// fourth param will be reimbursement type
			cs.setString(4, reimbObj.getReimb_type());
			
			
			// fifth param will be reimbursement status
//			cs.setNull(5, OracleTypes.
			cs.setString(5, reimbObj.getReimb_status());	// null... right?
			
			
			// sixth param will be receipt
//			cs.setString(6,	reimbObj.getReceipt());
//			cs.setString(6, OracleTypes.BLOB);
//			cs.setString(6, OracleTypes.NULL);
			cs.setString(6,	null);
			
			cs.execute();
			
			System.out.println("callablestatement object has been executed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
