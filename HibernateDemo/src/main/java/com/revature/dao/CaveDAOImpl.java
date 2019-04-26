package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl implements CaveDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Cave getCaveById(int id) {
		Cave c = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			c = (Cave) s.get(Cave.class, id);
			tx.commit();
			// s.close();
		}
		return c;
	}

	@Override
	public List<Cave> getAllCaves() {
		List<Cave> caves = new ArrayList<>();
		// use a Query to retrieve all caves
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			caves = s.createQuery("from Cave").getResultList();
			tx.commit();
			s.close();
		}
		return caves;
	}

	@Override
	public void addCave(Cave cave) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(cave);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateCave(Cave cave) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(cave);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteCave(Cave cave) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(cave);
			tx.commit();
			s.close();
		}
	}

}
