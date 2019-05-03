package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
