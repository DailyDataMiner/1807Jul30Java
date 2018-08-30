package com.ex.data;

import java.util.List;

import javax.persistence.NoResultException;
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
		User u = new User();
		try(Session session = ConnectionUtil.getSession();){		
			u = session.get(User.class, id);
		}
		return u;
	}
	
	public List<User> findAll(){
		List<User> users = null;
		try (Session session = ConnectionUtil.getSession();){		
			Query<User> q = session
					.createQuery("from User", User.class);
			users = q.getResultList();
		}
		return users;
	}
	
	public User save(User u) {

		try(Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction(); //start of tx w/ db
			
			int id = (int) session.save(u);
			u.setId(id);
			
			tx.commit(); //assuming we have successfully added bear, commit.
		}
		return u;
	}
	
	public void update(User u) {
		try(Session session = ConnectionUtil.getSession();) {
			Transaction tx = session.beginTransaction(); //start of tx w/ db
			session.update(u);
			tx.commit(); 
		}
	}
	
	public User findByUsername(String name) {
		User u = null;
		try (Session session = ConnectionUtil.getSession();){		
			Query q= session
					.createQuery("from User where lower(username) = :name");
			q.setParameter("name", name.toLowerCase());
			u = (User) q.getResultList().get(0);
		}
		return u;
	}
	
	public User findByUsernameCriteria(String name) {
		User u = null;
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("userName"), name));
			u = s.createQuery(query).getSingleResult();
		} catch(NoResultException e){
			e.printStackTrace();
		}
		return u;
	}

}
