package com.revature.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;
import com.revature.dao.FlashcardRepository;

@Service
@javax.jws.WebService(serviceName = "FlashcardService", portName = "FlashcardPort", targetNamespace = "http://service.flashcard.ex/", endpointInterface = "com.revature.soap.FlashcardWebService")
public class FlashcardWebServiceImpl implements FlashcardWebService {

	@Autowired
	private FlashcardRepository flashcardRepository;

	public FlashcardWebServiceImpl() {
	}

	@WebMethod
	public List<Flashcard> allFlashcards() {
		return flashcardRepository.findAll();
	}

}
