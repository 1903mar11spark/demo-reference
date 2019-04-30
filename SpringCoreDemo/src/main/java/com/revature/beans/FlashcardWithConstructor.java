package com.revature.beans;

public class FlashcardWithConstructor extends Flashcard {

		public FlashcardWithConstructor(Author author) {
			this();
			this.author = author;
		}
		public FlashcardWithConstructor() {
		}
		
		private Author author;
		
		@Override
		public void methodInFlashcard() {
			System.out.println(this);
		}
		public Author getAuthor() {
			return author;
		}
		
		@Override
		public String toString() {
			return "FlashcardWithConstructor [author=" + author + ", question=" + question + ", answer=" + answer + ", topic="
					+ topic + "]";
		}

}
