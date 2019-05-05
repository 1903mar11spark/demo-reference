package com.revature.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.service.AuthorService;

@RestController // combines @Controller and @ResponseBody
@RequestMapping(value="/author")
public class AuthorController {

	private AuthorService authorService;
	
	@Autowired 
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Author>> getAllAuthors() {
		return new ResponseEntity<>(authorService.allAuthors(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Author> getById(@PathVariable int id){
		Author a = authorService.getAuthorById(id);
		if (a == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(a, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> createAuthor(@RequestBody Author author){
		ResponseEntity<String> resp = null;
		try {
			authorService.createAuthor(author);
			resp = new ResponseEntity<>("AUTHOR CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE AUTHOR", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<String> updateAuthor(@RequestBody Author author){
		ResponseEntity<String> resp = null;
		try {
			authorService.updateAuthor(author);
			resp = new ResponseEntity<>("AUTHOR UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE AUTHOR", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAuthor(@RequestBody Author author){
		ResponseEntity<String> resp = null;
		try {
			authorService.deleteAuthor(author);
			resp = new ResponseEntity<>("AUTHOR DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO DELETE AUTHOR", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
