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

@Service //Spring stereotype
@javax.jws.WebService(serviceName = "Flashcard", portName = "FlashcardPort", targetNamespace = "http://soap.revature.com/", endpointInterface = "com.revature.soap.FlashcardWebService")
public class FlashcardWebServiceImpl implements FlashcardWebService {

	@Autowired
	private FlashcardRepository flashcardRepository;

	public FlashcardWebServiceImpl() {
	}

	@WebMethod
	public List<Flashcard> allFlashcards() {
		List<Flashcard> fl = new ArrayList<>();
		fl.add(new Flashcard(3, "question?", "answer", FlashcardTopics.MATH, new Author(4, "Frida", "Kahlo")));
		//return flashcardRepository.findAll();
		return fl;
	}

}
