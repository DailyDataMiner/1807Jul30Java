package com.ex.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ex.pojo.Bear;
import com.ex.util.ConnectionUtil;

public class BearDao {
	/*
	 * CRUD DAO using hibernate methods
	 */
	
	public Bear addBear(Bear b) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction(); //start of tx w/ db
			
			int id = (int) session.save(b);
			b.setBearId(id);
			
			tx.commit(); //assuming we have successfully added bear, commit.
		}
		finally {
			session.close();
		}
		return b;
	}
	
	
	public Bear persistBear(Bear b) {
		return b;
	}
	
	//GET
	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}
	
	//LOAD
	public Bear loadById(int id) {
		/**
		 * we must actually access the data in  our entity or we are just loading a proxy.
		 * Lazy initialization Exception will be thrown if we try to access our proxy with the session closed
		 */
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		session.close();
		return b;
	}
	
	//Update
	//Merge
	
	/*
	 * Criteria
	 * API for querying data programatically
	 * we don't need to speak any language but Java
	 * 
	 */
	public List<Bear> findAllCriteria(){
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();){		
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
			Root<Bear> root = criteria.from(Bear.class);
			bears = session.createQuery(criteria).getResultList();
		}
		return bears;		
	}
	
	/*
	 * Query
	 * Query database using HQL
	 * 
	 */
	public List<Bear> findByColor(String color){
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();){		
			Query<Bear> q = session
					.createQuery("from Bear where lower(furColor) like :param", Bear.class);
			q.setParameter("param", color.toLowerCase());
			bears = q.getResultList();
		}
		return bears;
	}
	
}
