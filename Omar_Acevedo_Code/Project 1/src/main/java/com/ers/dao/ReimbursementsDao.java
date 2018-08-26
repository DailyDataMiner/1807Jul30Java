package com.ers.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.pojos.Reimbursement;
import com.ers.utils.ConnectionFactory;


public class ReimbursementsDao implements Dao<Reimbursement, Integer> {
	
	List<Reimbursement> reimbursements = null;
	Reimbursement reimbursement = null;
	
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

	@Override
	public /*Object*/ List<Reimbursement> findWhereType(String type) {
	
		reimbursements = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql 	= "select ";
				   sql  +=  "TICKET_ID, TICKET_SATUS, CREATED_ON, " +
		   					"DESCRIPTION, REIMB_TYPE, AMOUNT, REIMB_STATUS, " +
		   					"RESOLVER, RECEIPT ";
				   sql  += "from v_tickets_reimbursements ";
				   sql  += "where upper(REIMB_TYPE) = upper(?)";
		   
		   PreparedStatement pStatement = conn.prepareStatement(sql);
		   
//		   if (type == "office") type = type + " supplies";
		   if (type.equals("office")) type = type + " supplies";
		   
		   System.out.println(type);
		   pStatement.setString(1, type);
		   
		   ResultSet results = pStatement.executeQuery();
		   
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
				//						results.getBlob("RECEIPT").toString()		// blob or string?
					));
		   }
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursements;
	}


	@Override
	public void save(Reimbursement reimbObj) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

// Reimbursement 
/*	[	ticket_id=0, ticket_status=null, created_on=null, description=qwert, 
 * 		amount=443.0, resolver=null, reimb_type=office, reimb_status=null, receipt=C:\fakepath\README.md]
			
*/
//CREATE_TICKET_REIMBURSEMENT( 2, 'My reimbursement request for office!', 101.99,  'office', null, null);
			CallableStatement cs = conn.prepareCall("{ CREATE_TICKET_REIMBURSEMENT( ?, ?, ?, ?, ?, ? ) }");
			
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
			
			
			// sixth param will be receipt
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Reimbursement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
