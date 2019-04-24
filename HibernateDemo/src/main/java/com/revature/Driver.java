package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Bat;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		// makeBats(sf);
		getAndLoad(sf);
	}

	static void getAndLoad(SessionFactory sf) {
		Session s = sf.openSession();

		// get a bat we know that we have.
		Bat b = s.get(Bat.class, 3);
		System.out.println(b);

		// get a bat we don't have (will be null)
		Bat b2 = s.get(Bat.class, 17);
		System.out.println(b2);

		// load a bat we know that we have.
		Bat b3 = s.load(Bat.class, 4);
		System.out.println(b3);

		// load a bat that we don't have. (throws ObjectNotFoundException)
		// Bat b4 = s.load(Bat.class, 18);
		// System.out.println(b4);

		// load a bat we know that we have, but don't access it (leave it as a proxy)
		Bat b5 = s.load(Bat.class, 5);

		s.close();

		// try to print the details of proxy bat (throws LazyInitializationException)
		// System.out.println(b5);

	}

	static void makeBats(SessionFactory sf) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(new Bat("Batty McBatface"));
		s.save(new Bat("Chad", 40.0));
		s.save(new Bat("Batthew", 90.0));
		s.save(new Bat("Battholomew", 85.0));
		s.save(new Bat("Batty White", 200.0));
		tx.commit();
		s.close();
	}

}
