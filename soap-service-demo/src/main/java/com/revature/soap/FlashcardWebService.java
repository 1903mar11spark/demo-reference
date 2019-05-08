package com.revature.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.revature.beans.Flashcard;

@WebService(targetNamespace = "http://service.flashcard.ex/", name = "Flashcard")
public interface FlashcardWebService {

	/*
	 * a contract (WSDL) will be generated based on this interface user ...?wsdl to
	 * access
	 */

	@WebResult(name = "return", targetNamespace = "")
	@RequestWrapper(localName = "allFlashcards", targetNamespace = "http://service.flashcard.ex/", className = "ex.flashcard.service.allFlashcards")
	@WebMethod(action = "urn:AllFlashcards")
	@ResponseWrapper(localName = "allFlashcardsResponse", targetNamespace = "http://ex.flashcard.service/", className = "service.flashcard.ex.AllFlashcardsResponse")
	public List<Flashcard> allFlashcards();

}
