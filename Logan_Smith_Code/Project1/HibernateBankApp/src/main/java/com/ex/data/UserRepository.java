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

	public User findById(int id) {
		User u = null;
		try (Session session = ConnectionUtil.getSession();) {
			u = session.get(User.class, id);
		}
		return u;
	}

	public List<User> findAll() {
		List<User> users = null;
		try (Session session = ConnectionUtil.getSession();) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		users = session.createQuery(criteria).getResultList();
		}
		return users;
	}

	public User save(User u) {
		try (Session session = ConnectionUtil.getSession();){
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			u.setId(id);
			tx.commit();
		}
		return u;
	}

	public User update(User u) {
		try (Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.getTransaction();

			session.update(u);
			tx.commit();
		}
		return u;
	}

	public User findByName(String name) {
		User user = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query q = session.createQuery("from BANK_USERS where name like :param", User.class);
			q.setParameter("param", name.toLowerCase());
			user = (User) q.getResultList().get(0);
		}
		return user;
	}
	public User findByUsernameCriteria(String name) {
		User u = null;
		try (Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), name));
			u = session.createQuery(query).getSingleResult();
		}
		return u;
	}

}
