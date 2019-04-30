package com.revature.beans;

public class Flashcard {
	
	public Flashcard() {
		super();
	}
	public Flashcard(int id, String question, String answer, Author author) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.author = author;
	}
	private int id;
	private String question;
	private String answer;
	private Author author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", author=" + author + "]";
	}

}
