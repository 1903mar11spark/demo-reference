package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Bat;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		// makeBats(sf);
		//getAndLoad(sf);
		//CaveDAO cd = new CaveDAOImpl();
		//System.out.println(cd.getAllCaves());
		//BatDAO bd = new BatDAOImpl();
		// these are transient, and will become persistent when we perform the update
		//Bat b = new Bat(1, "Batty McBatface", 20.0);
		//b.setCave(new Cave(27, "Tampa", 8));
		//bd.updateBat(b);
		funWithNamedQueries(sf);
	}
	
	static void funWithNamedQueries(SessionFactory sf) {
		Session s = sf.openSession();
		/*Query q = s.getNamedQuery("getAllBats");
		List<Bat> batList = q.getResultList();
		for (Bat b : batList) {
			System.out.println(b);
		}*/
		Query q2 = s.getNamedQuery("getBatsByCave");
		q2.setParameter("caveVar", 53);
		List<Bat> batList2 = q2.getResultList();
		for (Bat b : batList2) {
			System.out.println(b);
		}
		s.close();
	}
	
	static void otherSessionMethods(SessionFactory sf) {
		//create a session
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		
		//get and load
		Cave c1 = s.get(Cave.class, 33); //this will be null
		System.out.println(c1);
		
		//throws ObjectNotFoundException
		//Cave c2 = s.load(Cave.class, 35);
		//System.out.println(c2);
		
		Cave c3  = s.load(Cave.class, 27);
		c3.getName();
		
		//save and persist
		//System.out.println(s.save(c3)); //get our generated id... but this was already persistent
		
		tx.commit();
		s.close();
		
		//throws a LazyInitializationException if it was not used inside the session
		System.out.println(c3);
		
		//create another session, c3 is still detached 
		Session s2 = sf.getCurrentSession();
		Transaction tx2 = s2.beginTransaction();
		
		//throws exception
		//s2.persist(c3);
		
		//s2.save(c3); //creates duplicate record with new PK 
		
		//update and merge
		
		Cave c4 = new Cave(53, "Grand Rapids", 4);
		s2.update(c4);
		
		//get a persistent cave
		Cave c5 = s2.get(Cave.class, 27); //in persistent state
		c5.setName("Norway"); //automatic dirty checking will update this at end of session
		
		//update entity that does not exist
		//s2.update(new Cave(33,"thirty three", 33));
		
		tx2.commit();
		s2.close();
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
