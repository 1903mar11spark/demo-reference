package com.revature.soap;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Flashcard;

@WebService //this file represents the WSDL
public interface FlashcardWebService {
	
	public List<Flashcard> allFlashcards();

}
