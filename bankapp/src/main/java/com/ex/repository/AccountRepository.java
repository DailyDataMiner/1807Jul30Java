package com.ex.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.ex.models.Account;
import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class AccountRepository {
	
	public Account findById(int id) {
		Account a = null;
		try(Session session = ConnectionUtil.getSession()) {
			a = session.get(Account.class, id);
		}
		return a;
		
	}
	
	public List<Account> findAll() {
		List<Account> accounts = null;
		try(Session session = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
			accounts = session.createQuery(criteria).getResultList();
		}
		return accounts;
	}

	public Account save(Account a) {
		return a;
		
	}
	
	public void update(Account a) {
		
	}

	public Account findByBalanceCriteria(int number) {
		return null;
		
	}
}
