package com.revature.beans;

public class Flashcard {

	public Flashcard(int id, String question, String answer, FlashcardTopics topic, Author author) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.author = author;
	}

	public Flashcard() {
		super();
	}

	private int id;
	private String question;
	private String answer;
	private FlashcardTopics topic;
	private Author author;

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

	public FlashcardTopics getTopic() {
		return topic;
	}

	public void setTopic(FlashcardTopics topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", topic=" + topic
				+ ", author=" + author + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
