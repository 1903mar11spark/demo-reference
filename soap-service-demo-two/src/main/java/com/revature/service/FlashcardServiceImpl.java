package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;

@Component //this is our Spring stereotype
@WebService(endpointInterface="com.revature.service.FlashcardService")
public class FlashcardServiceImpl implements FlashcardService {

	private FlashcardDAO flashcardDAO;

	@Autowired
	public FlashcardServiceImpl(FlashcardDAO flashcardDAO) {
		this.flashcardDAO = flashcardDAO;
	}

	public List<Flashcard> allFlashcards() {
		return flashcardDAO.allFlashcards();
	}

	public Flashcard getFlashcardById(int id) {
		return flashcardDAO.getFlashcardById(id);
	}

	public void createFlashcard(Flashcard flashcard) {
		flashcardDAO.createFlashcard(flashcard);
	}

	public void updateFlashcard(Flashcard flashcard) {
		flashcardDAO.updateFlashcard(flashcard);
	}

	public void deleteFlashcard(Flashcard flashcard) {
		flashcardDAO.deleteFlashcard(flashcard);
	}

}
