package com.revature.dao;

import java.util.List;

import com.revature.beans.Author;

public interface AuthorDAO {
	
	public List<Author> allAuthors();
	public Author getAuthorById(int id);
	public void createAuthor(Author author);
	public void updateAuthor(Author author);
	public void deleteAuthor(Author author);
	
}
