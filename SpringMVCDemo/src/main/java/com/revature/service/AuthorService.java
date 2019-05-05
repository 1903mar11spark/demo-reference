package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Author;
import com.revature.dao.AuthorDAO;

@Service
public class AuthorService {
	
	private AuthorDAO authorDAO;
	
	@Autowired
	public AuthorService(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}
	
	public List<Author> allAuthors() {
		return authorDAO.allAuthors();
	}
	
	public Author getAuthorById(int id) {
		return authorDAO.getAuthorById(id);
	}
	
	public void createAuthor(Author author) {
		authorDAO.createAuthor(author);
	}
	
	public void updateAuthor(Author author) {
		authorDAO.updateAuthor(author);
	}
	
	public void deleteAuthor(Author author) {
		authorDAO.deleteAuthor(author);
	}
}
