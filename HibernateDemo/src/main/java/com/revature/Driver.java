package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		makeBats(sf);
	}
	
	static void makeBats(SessionFactory sf) {
		Session s = sf.openSession();
		
		s.close();
	}

}
