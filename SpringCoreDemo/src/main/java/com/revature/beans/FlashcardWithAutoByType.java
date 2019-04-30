package com.revature.beans;

public class FlashcardWithAutoByType extends Flashcard {

	private Author author;
	
	@Override
	public void methodInFlashcard() {
	}

	public Author getAuthor() {
		return author;
	}

	//method must take a parameter of the same type as the desired dependency
	//should you ever write code that looks like this? No!!
	public void setAuthorOrSomethingOfThatType(Author onlyTheTypeMatters) {
		this.author = onlyTheTypeMatters;
	}

	@Override
	public String toString() {
		return "FlashcardWithAutoByType [author=" + author + ", question=" + question + ", answer=" + answer
				+ ", topic=" + topic + "]";
	}

}
