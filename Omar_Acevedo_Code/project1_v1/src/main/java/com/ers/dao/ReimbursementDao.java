package com.ers.dao;

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

}
