package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;
import com.revature.dao.FlashcardRepository;

@Service
public class FlashcardService {

private FlashcardRepository flashcardRepository;
	
	@Autowired
	public FlashcardService(FlashcardRepository flashcardRepository) {
		this.flashcardRepository = flashcardRepository;
	}
	
	public List<Flashcard> allFlashcards() {
		return flashcardRepository.findAll();
	}
	
	public List<Flashcard> getByTopic(FlashcardTopics ft) {
		return flashcardRepository.getByTopic(ft);
	}
	
	public Flashcard getFlashcardById(int id) {
		return flashcardRepository.getOne(id);
	}
	
	public void createFlashcard(Flashcard flashcard) {
		flashcardRepository.save(flashcard);
	}
	
	public void updateFlashcard(Flashcard flashcard) {
		flashcardRepository.save(flashcard);
	}
	
	public void deleteFlashcard(Flashcard flashcard) {
		flashcardRepository.delete(flashcard);
	}

}
