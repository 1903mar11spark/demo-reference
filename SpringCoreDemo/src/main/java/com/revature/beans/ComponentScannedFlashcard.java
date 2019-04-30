package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks class as Spring bean
@Scope(value="prototype")
public class ComponentScannedFlashcard extends Flashcard {

	public ComponentScannedFlashcard(String question, String answer, FlashcardTopics topic) {
		super(question, answer, topic);
	}

	public ComponentScannedFlashcard() {
	}
	
	//field injection! Not good practices! Can also use @Autowired on setters
	@Autowired
	private Author author;

	@Override
	public void methodInFlashcard() {
	}

	@Override
	public String toString() {
		return "ComponentScannedFlashcard [author=" + author + ", question=" + question + ", answer=" + answer
				+ ", topic=" + topic + "]";
	}

}
