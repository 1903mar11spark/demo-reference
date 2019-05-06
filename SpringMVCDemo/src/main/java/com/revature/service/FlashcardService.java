package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;

@Service
public class FlashcardService {

private FlashcardDAO flashcardDAO;
	
	@Autowired
	public FlashcardService(FlashcardDAO flashcardDAO) {
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
