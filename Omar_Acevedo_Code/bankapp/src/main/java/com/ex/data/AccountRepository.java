package com.ex.data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.Account;
import com.ex.util.ConnectionUtil;

public class AccountRepository {

	
	// LOAD,
	public Account loadById(int id) {
		
		Session session = ConnectionUtil.getSession();
		Account a = session.load(Account.class, id);
		
		System.out.println("Just loaded Account");
		System.out.println(a);
		
		session.close();
		return a;
	}
	
	public Account findById(int id) {
		
		Session session = ConnectionUtil.getSession();
		Account account = session.get(Account.class, id);
		session.close();
		return account;	
	}
	
	public List<Account> findAll() {
		
	/**
	 * 	Query
	 *  Query database using HQL
	 */
		
		List<Account> accounts = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query<Account> q = session.createQuery("from BANK_ACCOUNTS", Account.class);
			accounts = q.getResultList();
		}
		return accounts;
		
	}
	
	public Account save(Account a) {
		
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(a);
			a.setId(id);
			tx.commit();
		} finally {
			session.close();
		}
		return a;
	}
	
	public void update(Account a) {
		
		try (Session s = ConnectionUtil.getSession()) {
			
			Transaction tx = s.beginTransaction();
			s.update(a);
			tx.commit();
			
		}
		
	}

//	public Account findByUsernameCriteria(String name) {
//		
//	}
	
	public List<Account> findByAccountName(String aName) {
		List<Account> accounts = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query<Account> q = session.createQuery("from BANK_ACCOUNTS where lower(furColor) like :param", Account.class);
			q.setParameter("param", aName.toLowerCase());
			accounts = q.getResultList();
		}
		return accounts;
	}
	
}
