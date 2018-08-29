package com.ex.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {

	// LOAD,
	public User loadById(int id) {
		
		Session session = ConnectionUtil.getSession();
		User u = session.load(User.class, id);
		
		System.out.println("Just loaded User");
		System.out.println(u);
		
		session.close();
		return u;
	}
	
	public User findById(int id) {

		Session session = ConnectionUtil.getSession();
		User user = session.get(User.class, id);
		session.close();
		return user;
	}

	public List<User> findAll() {

		/**
		 * Query Query database using HQL
		 */

		List<User> users = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query<User> q = session.createQuery("from BANK_USERS", User.class);
			users = q.getResultList();
		}
		return users;

	}

	public User save(User u) {

		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			u.setId(id);
			tx.commit();
		} finally {
			session.close();
		}
		return u;
	}

	public User findByUserName(String name) {
		User u = null;
		try (Session session = ConnectionUtil.getSession()) {
			Query query = session.createQuery("from BANK_USERS where lower(username) = :uname");
			query.setParameter("uname", name.toLowerCase());
			u = (User) query.getResultList();
		}
		return u;
	}
	
	/*
	 * Back in simpler times aka hibernate 4
	 * Criteria c = session.createCrirteria(User.class)
	 * c.addRestriction
	 * c.list
	 * */
	public User findByUsernameCriteria(String name) {
		
		User u = null;
		try (Session s = ConnectionUtil.getSession()) {
			
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			
			query.select(root).where(builder.equal(root.get("username"), name));
			u = s.createQuery(query).getSingleResult();
			
		}
		return u;
		
	}

}
