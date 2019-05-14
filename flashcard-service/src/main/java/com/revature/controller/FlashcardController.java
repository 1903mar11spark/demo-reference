package com.revature.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;
import com.revature.service.FlashcardService;

/*@Controller
@ResponseBody // indicates that responses are NOT view names (skipping view resolver)*/
@RestController // Controller + ResponseBody
@RequestMapping(value = "/flashcard")
public class FlashcardController {

	private FlashcardService flashcardService;

	@Autowired // setter injection
	public void setFlashcardService(FlashcardService flashcardService) {
		this.flashcardService = flashcardService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Flashcard>> getAllFlashcards() {
		return new ResponseEntity<>(flashcardService.allFlashcards(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Flashcard> getFlashcardById(@PathVariable int id){
		Flashcard f = flashcardService.getFlashcardById(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/topic/{topic}")
	public ResponseEntity<List<Flashcard>> getFlashcardsByTopic(@PathVariable FlashcardTopics topic){
		List<Flashcard> cardList = flashcardService.getByTopic(topic);
		if (cardList == null ) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(cardList, HttpStatus.OK);
		}
	}
	
	// rewrite the above to use a query string 
	// (will also work for form data passed in request body)
	@GetMapping(value="/byId")
	public ResponseEntity<Flashcard> getFlashcardByIdWithQueryString(@RequestParam int id){
		Flashcard f = flashcardService.getFlashcardById(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> addFlashcard(@RequestBody Flashcard flashcard) {
		ResponseEntity<String> resp = null;
		flashcard.setId(0);
		try {
			flashcardService.createFlashcard(flashcard);
			resp = new ResponseEntity<>("FLASHCARD CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE FLASHCARD", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<String> updateFlashcard(@RequestBody Flashcard flashcard){
		ResponseEntity<String> resp = null;
		try {
			flashcardService.updateFlashcard(flashcard);
			resp = new ResponseEntity<>("FLASHCARD UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE FLASHCARD", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteFlashcard(@RequestBody Flashcard flashcard){
		ResponseEntity<String> resp = null;
		try {
			flashcardService.deleteFlashcard(flashcard);
			resp = new ResponseEntity<>("FLASHCARD DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO DELETE FLASHCARD", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
