package com.ex.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.Account;
import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class AccountRepository {

	public Account findById(int id) {
		Account a = null;
		try (Session session = ConnectionUtil.getSession();) {
			a = session.get(Account.class, id);
		}
		return a;
	}

	public List<Account> findAll() {
		List<Account> accounts = null;
		try (Session session = ConnectionUtil.getSession();) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
		Root<Account> root = criteria.from(Account.class);
		accounts = session.createQuery(criteria).getResultList();
		}
		return accounts;
	}

	public Account save(Account a) {
		try (Session session = ConnectionUtil.getSession();){
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(a);
			a.setId(id);
			tx.commit();
		}
		return a;
	}

	public Account update(Account a) {
		try (Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.getTransaction();

			session.update(a);
			tx.commit();
		}
		return a;
	}

	public Account findByName(String name) {
		Account account = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query q = session.createQuery("from ACCOUNTS where name like :param", Account.class);
			q.setParameter("param", name.toLowerCase());
			account = (Account) q.getResultList().get(0);
		}
		return account;
	}
	public Account findByNameCriteria(String name) {
		Account a = null;
		try (Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root).where(builder.equal(root.get("name"), name));
			a = session.createQuery(query).getSingleResult();
		}
		return a;
	}
	public List<Account> findByUserCriteria(User id) {
		List<Account> a = null;
		try (Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root).where(builder.equal(root.get("owner_id"), id.getId()));
			a = session.createQuery(query).getResultList();
		}
		return a;
	}
	
}
