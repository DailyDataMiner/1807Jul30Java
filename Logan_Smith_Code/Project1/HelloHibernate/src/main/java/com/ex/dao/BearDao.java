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

	public Bear addBear(Bear b) {
		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx = session.getTransaction();
		
		int id = (int) session.save(b);
		b.setBearID(id);
		tx.commit();
		}
		finally {
		session.close();
		}
		return b;
	}
	
	public Bear getByID(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}
	
	public Bear loadByID(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		session.close();
		return b;
	}
	
	public List<Bear> findByCriteria() {
		
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
		Root<Bear> root = criteria.from(Bear.class);
		bears = session.createQuery(criteria).getResultList();
		}
		return bears;
	}
	
	public List<Bear> findByHaircolorQuery(String hair) {
		List<Bear> bears = null;
		try (Session session = ConnectionUtil.getSession();) {
			Query<Bear> q = session.createQuery("from Bear where color like :param", Bear.class);
			q.setParameter("param", hair.toLowerCase());
			bears = q.getResultList();
			}
		return bears;
	}
	
}
