package com.ex.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {

	public User findById(int id) {

		Session session = ConnectionUtil.getSession();
		User u = session.get(User.class, id);
		session.close();
		return u;

	}

	public List<User> findAll() {

		List<User> u = null;
		try (Session session = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);

		}

		return users;

	}

	public User save(User u) {

		try (Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(u);
			tx.commit();
		}

		return null;

	}

	public User update(User u) {

		return null;

	}

	public User findByUsername(User u) {

		return null;

	}

	public User finBydUsernameCriteria(String name) {
		User u = null;
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), name);
			u
			
		}
		
		
	}

}
