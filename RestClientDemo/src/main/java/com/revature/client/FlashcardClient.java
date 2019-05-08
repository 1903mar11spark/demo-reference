package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Flashcard;

@Component
public class FlashcardClient {

	private RestTemplate restTemplate;
	private String resourceUrl;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	// call our RESTful web service and retrieve all flashcards
	public List<Flashcard> getFlashcards() {
		ResponseEntity<List<Flashcard>> response = this.restTemplate.exchange(this.resourceUrl + "/flashcard/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Flashcard>>() {
				});
		return response.getBody();
	}

}
