package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Author;

@Repository
@Transactional
public class AuthorDAOImpl implements AuthorDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public AuthorDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Author> allAuthors() {
		List<Author> authors = new ArrayList<>();
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			authors = s.createQuery("from Author").getResultList();
			tx.commit();
		}
		return authors;
	}

}
