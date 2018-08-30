package com.rev.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.models.User;
import com.rev.util.ConnectionUtil;

public class UserRepository {
	
	public User findById(int id) {
		return null;
	}

	public List<User> findAll(){
		
	}
	
	public User save(User u) {
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		}
		return u;
	}
	
	public void update(User u) {
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		}
	}
	
	public User findByUsername(String name) {
		
	}
	
	public User findByUsernameWithCriteria(String name) {
		User u = null;
		try (Session s = ConnectionUtil.getSession()){
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
