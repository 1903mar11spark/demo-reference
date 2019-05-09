package com.revature.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Author;
import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;
import com.revature.dao.FlashcardRepository;

@javax.jws.WebService(serviceName = "Flashcard", portName = "FlashcardPort", targetNamespace = "http://soap.revature.com/", endpointInterface = "com.revature.soap.FlashcardWebService")
public class FlashcardWebServiceImpl implements FlashcardWebService {

	private FlashcardRepository flashcardRepository;
	
	public void setFlashcardRepository(FlashcardRepository flashcardRepository) {
		this.flashcardRepository = flashcardRepository;
	}

	public FlashcardWebServiceImpl() {
	}

	@WebMethod
	public List<Flashcard> allFlashcards() {
		return flashcardRepository.findAll();
	}

}
