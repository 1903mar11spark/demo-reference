package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Flashcard;

@WebService //this is our Apache CXF annotation
public interface FlashcardService {
	
	public List<Flashcard> allFlashcards();
	
	public Flashcard getFlashcardById(int id);
	
	public void createFlashcard(Flashcard flashcard);
	
	public void updateFlashcard(Flashcard flashcard);
	
	public void deleteFlashcard(Flashcard flashcard);

}
