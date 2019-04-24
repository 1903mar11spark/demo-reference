package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Bat;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		makeBats(sf);
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
