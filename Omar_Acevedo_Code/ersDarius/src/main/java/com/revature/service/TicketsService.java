package com.revature.service;


import com.revature.dao.Dao;
import com.revature.dao.TicketDao;
import com.revature.pojos.Tickets;

public class TicketsService {
	static Dao<Tickets, Integer> tickdao = new TicketDao();
	
	public Tickets addTicket(Tickets t) {
		return tickdao.save(t);
	}

}
