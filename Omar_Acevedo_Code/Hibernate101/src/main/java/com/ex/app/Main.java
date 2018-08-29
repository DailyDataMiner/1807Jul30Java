package com.ex.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.Honey;
import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
	
		// TODO Auto-generated constructor stub
//		Bear b = new Bear();
//		b.setBreed("Polar Bear");
//		b.setFurColor("white");
//		b.setHeight(80.9);
//		
//		Person p = new Person();
//		p.setFirstName("Omar");
//		p.setLastName("Acevedo");
		
		addPersonDemo();
		
//		BearDao bd = new BearDao();
//		bd.addBear(b);
		
//		Bear b = bd.getById(1);
//		Bear b = bd.loadById(1);
//		Bear b = bd.getById(10);
//		System.out.println(b);
		
//		List<Bear> bears = bd.findAllCriteria();
//		for (Bear b : bears) {
//			System.out.println(b.toString());
//		}
		
//		List<Bear> bears = bd.findAllQuery();
//		for (Bear b : bears) {
//			System.out.println(b.toString());
//		}
		
//		List<Bear> bears = bd.findbyColor("b%");
//		for (Bear b : bears) {
//			System.out.println(b.toString());
//		}
		
//		addBearDemo();
		
	}
	
	static void addPersonDemo() {
		Person p = new Person();
		p.setFirstName("Omar");
		p.setLastName("Acevedo");
		try (Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		}
	}
	
	static void addBearDemo() {
		
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			
			// Make honey
			Honey h1 = new Honey();
			h1.setAmount(50);
			h1.setHoney("Raspberry Honey");
			
			Honey h2 = new Honey();
			h1.setAmount(25);
			h1.setHoney("Organic");

			Honey h3 = new Honey();
			h1.setAmount(30);
			h1.setHoney("Manuka Honey");
			
			
			// Family home
			Cave home = new Cave();
			home.setRent(1600);
			home.setSquareFootage(800);
			
			
			// Make bears; Make child bears first
			Bear cub1 = new Bear("Brown", 70, "Polar", h1, home, null);
			Bear cub2 = new Bear("White", 80, "Polar", h2, home, null);
			
			Set<Bear> cubs = new HashSet<Bear>();
			cubs.add(cub1);
			cubs.add(cub2);
			
			Bear poppaBear = new Bear("Black", 100, "Polar", h3, home, cubs);
			
			session.save(h1);
			session.save(h2);
			session.save(h3);
			session.save(home);
			session.save(cub1);
			session.save(cub2);
//			session.save(cubs);
			
			session.save(poppaBear);
			tx.commit();
			
		} finally {
			session.close();
		}
		
		
	}
	
}
