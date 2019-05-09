package com.revature;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.dao.FlashcardRepository;
import com.revature.soap.FlashcardWebServiceImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private ApplicationContextProvider applicationContextProvider;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, flashcardWebServiceImpl());
		endpoint.publish("/flashcard");
		return endpoint;
	}
	
	@Bean
	public FlashcardWebServiceImpl flashcardWebServiceImpl() {
		FlashcardWebServiceImpl fws = new FlashcardWebServiceImpl();
		fws.setFlashcardRepository(this.applicationContextProvider.getContext().getBean(FlashcardRepository.class, "flashcardRepository"));
		return fws;
	}

}
