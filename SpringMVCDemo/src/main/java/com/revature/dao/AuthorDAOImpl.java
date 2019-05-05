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

@Repository(value="authorDAO")
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
			Session s = sessionFactory.getCurrentSession();
			authors = s.createQuery("from Author").getResultList();
		return authors;
	}

	@Override
	public Author getAuthorById(int id) {
		return sessionFactory.getCurrentSession().get(Author.class, id);
	}

	@Override
	public void createAuthor(Author author) {
		sessionFactory.getCurrentSession().persist(author);
	}

	@Override
	public void updateAuthor(Author author) {
		sessionFactory.getCurrentSession().saveOrUpdate(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		sessionFactory.getCurrentSession().delete(author);
	}

}
