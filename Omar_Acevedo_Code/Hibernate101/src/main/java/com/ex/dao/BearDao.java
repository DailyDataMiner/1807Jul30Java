package com.ex.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.util.ConnectionUtil;

public class BearDao {
	
	/*
	 * CRUD DAO using hibernate methods. 
	 */
	
	public Bear addBear(Bear b) {
		
		Session session = ConnectionUtil.getSession();
		
		try {
			
			Transaction tx = session.beginTransaction();
			
			int id = (int) session.save(b);
			b.setBearId(id);
			
			tx.commit();
			
		} finally {
			session.close();
		}
		
		return b;
		
	}
	
	public Bear persistBear(Bear b) {
		return b;
	}
	
	// GET, 
	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}
	
	// LOAD,
	public Bear loadById(int id) {
		
		/*
		 * 
		 * 
		 * 
		 */
		
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		
		System.out.println("Just loaded Bear");
		System.out.println(b);
		
		session.close();
		return b;
	}
	
	// UPDATE, 
	// MERGE,
		
	
	/**
	 * 	Criteria
	 */

	public List<Bear> findAllCriteria() {
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
			Root<Bear> root = criteria.from(Bear.class);
			
//			root.
			
			bears = session.createQuery(criteria).getResultList();
		}
		return bears;
	}
	
	
	/**
	 * 	Query
	 *  Query database using HQL
	 */
	
	public List<Bear> findAllQuery() {
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query<Bear> q = session.createQuery("from Bear", Bear.class);
			bears = q.getResultList();
		}
		return bears;
	}
	
	public List<Bear> findbyColor(String color) {
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query<Bear> q = session.createQuery("from Bear where lower(furColor) like :param", Bear.class);
			q.setParameter("param", color.toLowerCase());
			bears = q.getResultList();
		}
		return bears;
	}
	
}
