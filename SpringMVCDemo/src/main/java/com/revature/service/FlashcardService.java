package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Author;
import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;

@Service
public class FlashcardService {

	public List<Flashcard> getAll() {
		Author a = new Author("Simon", "Garfunkel");
		Flashcard f1 = new Flashcard(4, "What is the answer?", "42", FlashcardTopics.MATH, a);
		Flashcard f2 = new Flashcard(5, "What is the question?", "what is six times eight?", FlashcardTopics.MATH, a);
		List<Flashcard> fl = new ArrayList<>();
		fl.add(f1);
		fl.add(f2);
		return fl;
	}

}
