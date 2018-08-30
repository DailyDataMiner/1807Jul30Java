package com.rev.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.pojos.Bear;
import com.rev.util.ConnectionUtil;

public class BearDao {

	/*
	 * CRUD DAO using hibernate methods
	 */

	public Bear addBear(Bear b) {

		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();

			int id = (int) session.save(b);
			b.setBearId(id);

			tx.commit();
		} 
		finally {
			session.close();
			return b;
		}
	}

}
