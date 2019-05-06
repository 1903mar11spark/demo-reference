package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Flashcard;

@Repository(value="flashcardDAO")
@Transactional
public class FlashcardDAOImpl implements FlashcardDAO {

private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public FlashcardDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Flashcard> allFlashcards() {
		List<Flashcard> flashcards = new ArrayList<>();
			Session s = sessionFactory.getCurrentSession();
			flashcards = s.createQuery("from Flashcard").getResultList();
		return flashcards;
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		return sessionFactory.getCurrentSession().get(Flashcard.class, id);
	}

	@Override
	public void createFlashcard(Flashcard flashcard) {
		sessionFactory.getCurrentSession().persist(flashcard);
	}

	@Override
	public void updateFlashcard(Flashcard flashcard) {
		sessionFactory.getCurrentSession().saveOrUpdate(flashcard);
	}

	@Override
	public void deleteFlashcard(Flashcard flashcard) {
		sessionFactory.getCurrentSession().delete(flashcard);
	}

}
