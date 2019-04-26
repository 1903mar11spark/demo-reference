package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Bat;
import com.revature.util.ConnectionUtil;

public class BatDAOImpl implements BatDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	public Bat getBatById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bat> getAllBats() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addBat(Bat bat) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateBat(Bat bat) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(bat);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBat(Bat bat) {
		// TODO Auto-generated method stub
		return false;
	}

}
