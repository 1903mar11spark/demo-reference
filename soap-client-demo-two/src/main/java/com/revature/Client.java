package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Flashcard;
import com.revature.soap.FlashcardWebService;

public class Client {

	public static void main(String[] args) {

		FlashcardWebService fs = getFlashcardService();
		// retrieve flashcards
		List<Flashcard> cards = fs.allFlashcards();
		for (Flashcard f : cards) {
			System.out.println(f);
		}
	}

	static FlashcardWebService getFlashcardService() {
		// retrieve an object of type FlashcardWebService which represents my service
		String serviceUrl = "http://localhost:8083/services/flashcard";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(FlashcardWebService.class);
		factory.setAddress(serviceUrl);

		// set up interceptors
		/*LoggingInInterceptor inInt = new LoggingInInterceptor();
		LoggingOutInterceptor outInt = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInt);
		factory.getOutInterceptors().add(outInt);
		inInt.setPrintWriter(new PrintWriter(System.out));
		outInt.setPrintWriter(new PrintWriter(System.out));*/

		return (FlashcardWebService) factory.create();
	}

}
