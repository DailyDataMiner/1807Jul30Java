package com.ex.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {

	public User findById(int id) {
		User u = null;
		try(Session session = ConnectionUtil.getSession()){
			u = session.get(User.class, id);
		}
		return u;
	}

	public List<User> findAll() {
		List<User> Users = null;
		try (Session session = ConnectionUtil.getSession();) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			Users = session.createQuery(criteria).getResultList();
		}
		return Users;

	}

	public User save(User u) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction(); // start of tx w db
			session.save(u);

			tx.commit(); // assuming we have successfully added bear, commit tx
		} finally {
			session.close();
		}
		return u;

	}

	public User update(User u) {
		Session session = ConnectionUtil.getSession();
		session.update(u);
		System.out.println("Just updated user");
		System.out.println(u);
		session.close();
		return u;

	}

	public User findByUsername(User u) {
		try(Session session = ConnectionUtil.getSession();){
			Query q = session.createQuery("from User where lower(username) like :uname", User.class);
			u.setParameter("uname", username.toLowerCase());
			u = q.getSingleResult();
		}
		return u;
	}
	
}
