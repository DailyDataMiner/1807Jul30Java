package com.revature.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.helpers.HelperFunctions;
import com.revature.pojos.Tickets;
import com.revature.util.ConnectionFactory;

public class TicketDao extends HelperFunctions implements Dao<Tickets, Integer> {

	
	public List<Tickets> getAll() {
		// need to pass in users id
		
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String select_query = "select * from ers_reimbursement";
			
//			String select_query = "SELECT ers_users.user_first_name, ers_users.user_last_name , ers_reimbursement.reimb_amount, ers_reimbursement.reimb_submitted, " + 
//					"    ers_reimbursement.reimb_resolved, ers_reimbursement.reimb_description, ers_reimbursement_status.reimb_status " + 
//					"FROM ((ers_users " + 
//					"INNER JOIN ers_reimbursement ON ers_users.ers_users_id = ers_reimbursement.reimb_author) " + 
//					"INNER JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id) " + 
//					"WHERE ers_users.ers_users_id = 1";
			
			ResultSet selectRS = conn.createStatement().executeQuery(select_query);
			
			while(selectRS.next()) {
				Tickets tickets = new Tickets(selectRS.getString(1),
											  selectRS.getString(2),
											  selectRS.getDouble(3),
											  selectRS.getString(4),
											  selectRS.getString(5),
											  selectRS.getString(6),
											  selectRS.getString(7)
											  );
				ticketsList.add(tickets);
						
			}							  
		} catch(SQLException e) {
				e.printStackTrace();
		}
			
		return ticketsList;
	}

	@Override
	public Tickets findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets save(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets update(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(Tickets obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tickets findPw(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets findOne(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets insert(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tickets obj) {
		// TODO Auto-generated method stub
		
	}





}
