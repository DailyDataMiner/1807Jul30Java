package com.ex.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.Honey;
import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
//		Bear b = new Bear();
//		b.setBreed("Polar Bear");
//		b.setFurColor("White");
//		b.setHeight(102.8);
//
		BearDao bd = new BearDao();
//		bd.saveBear(b);

		// addBearDemo();
//		Bear b = bd.getById(1);
//		System.out.println(b);

		List<Bear> bears = bd.findAllCriteria();
		for (Bear b : bears) {
			System.out.println(bears);
		}
	}

	static void addPersonDemo() {

		Person p = new Person();
		p.setFirstName("Brijay");
		p.setLastName("Reed");

	}

	static void addBearDemo() {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();

			Honey h1 = new Honey();
			h1.setVolume(50);
			h1.setHoney("Sriracha Honey");

			Honey h2 = new Honey();
			h2.setVolume(20);
			h2.setHoney("Organic Crulty-Free Honey");

			Honey h3 = new Honey();
			h3.setVolume(70);
			h3.setHoney("Cinnamon Honey");

			Cave home = new Cave();
			home.setRent(1600);
			home.setSquareFootage(800);

			// Make cubs first

			Bear cub1 = new Bear("Brown", 30, "Polar", home, h1, null);
			Bear cub2 = new Bear("Brown", 50, "Polar", home, h2, null);
			Set<Bear> cubs = new HashSet<Bear>();
			cubs.add(cub1);
			cubs.add(cub2);
			Bear daddyBear = new Bear("Black", 100, "Polar", home, h3, null);

			session.save(h1);
			session.save(h2);
			session.save(h3);
			session.save(home);
			session.save(cub1);
			session.save(cub2);
			session.save(daddyBear);
			tx.commit();

		} finally {
			session.close();
		}
	}

}
