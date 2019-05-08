package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {

	// other choices besides JpaRepository - CrudRepository (supertype) and
	// PagingAndSortingRepository
	
	public List<Flashcard> getByTopic(FlashcardTopics ft);

}
