package com.ex.data;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ex.models.Account;
import com.ex.models.Account;
import com.ex.util.ConnectionUtil;

public class AccountRepository {
	
	public Account findById(int id) {
		Account a = new Account();
		try(Session session = ConnectionUtil.getSession();){		
			a = session.get(Account.class, id);
		}
		return a;
	}
	
	public List<Account> findAll(){
		List<Account> accounts = null;
		try (Session session = ConnectionUtil.getSession();){		
			Query<Account> q = session
					.createQuery("from Account", Account.class);
			accounts = q.getResultList();
		}
		return accounts;
	}
	
	public Account save(Account a) {

		try(Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction(); //start of tx w/ db
			
			int id = (int) session.save(a);
			a.setId(id);
			
			tx.commit(); //assuming we have successfully added bear, commit.
		}
		return a;
	}
	
	public void update(Account a) {
		try(Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction(); //start of tx w/ db
			session.update(a);
			tx.commit(); 
		}
	}
	
	public Account findByAccountname(String name) {
		Account a = null;
		try (Session session = ConnectionUtil.getSession();){		
			Query q= session
					.createQuery("from Account where lower(Accountname) = :name");
			q.setParameter("name", name.toLowerCase());
			a = (Account) q.getResultList().get(0);
		}
		return a;
	}
	
	public Account findByAccountnameCriteria(String name) {
		Account a = null;
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root).where(builder.equal(root.get("AccountName"), name));
			a = s.createQuery(query).getSingleResult();
		} catch(NoResultException e){
			e.printStackTrace();
		}
		return a;
	}

}
