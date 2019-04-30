package com.revature.beans;

public abstract class Flashcard {
	
	public Flashcard(String question, String answer, FlashcardTopics topic) {
		super();
		this.question = question;
		this.answer = answer;
		this.topic = topic;
	}
	public Flashcard() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected String question;
	protected String answer;
	protected FlashcardTopics topic;
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
	
	public abstract void methodInFlashcard();
}
