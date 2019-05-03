package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Author;
import com.revature.dao.AuthorDAO;
import com.revature.dao.AuthorDAOImpl;

@Service
public class AuthorService {
	
	private AuthorDAO authorDAO;
	
	@Autowired
	public AuthorService(AuthorDAOImpl ad) {
		this.authorDAO = ad;
	}
	
	public List<Author> allAuthors() {
		return authorDAO.allAuthors();
	}
	
}
