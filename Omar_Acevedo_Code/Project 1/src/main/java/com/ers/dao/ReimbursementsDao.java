package com.ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.pojos.Reimbursement;
import com.ers.utils.ConnectionFactory;


public class ReimbursementsDao implements Dao {
	
	List<Reimbursement> reimbursements = null;
	
	@Override
	public List<Reimbursement> findAll() {
		
//		int index = 0;
		reimbursements = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			
			String selectTickReimb_sql 	= "select ";
				   selectTickReimb_sql  +=  "TICKET_ID, TICKET_SATUS, CREATED_ON, " +
						   					"DESCRIPTION, REIMB_TYPE, AMOUNT, REIMB_STATUS, " +
						   					"RESOLVER, RECEIPT ";
				   selectTickReimb_sql  += "from v_tickets_reimbursements";

			Statement statementObj = conn.createStatement();
			ResultSet results = statementObj.executeQuery(selectTickReimb_sql);
			
//			ResultSet results = conn.createStatement().executeQuery(selectTickReimb_sql);
			while (results.next()) {
				
				reimbursements.add(new Reimbursement(
										results.getInt("TICKET_ID"),
										results.getString("TICKET_SATUS"),
										results.getString("CREATED_ON"), 	// getDate...?
										results.getString("DESCRIPTION"),
										results.getString("REIMB_TYPE"),
										results.getDouble("AMOUNT"),
										results.getString("REIMB_STATUS"),
										results.getString("RESOLVER"),
										null
//										results.getBlob("RECEIPT").toString()		// blob or string?
									));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbursements;
	
	}
	
}
