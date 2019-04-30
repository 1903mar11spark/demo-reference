package com.revature.beans;

public class FlashcardWithAutoByName extends Flashcard {

	private Author author;
	
	@Override
	public void methodInFlashcard() {
	}

	public Author getAuthor() {
		return author;
	}

	//method identifier must match name of dependency
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "FlashcardWithAutoByName [author=" + author + ", question=" + question + ", answer=" + answer
				+ ", topic=" + topic + "]";
	}

}
