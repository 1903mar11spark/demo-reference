package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FLASHCARD")
public class Flashcard {
	
	public Flashcard(String question, String answer, FlashcardTopics topic, Author author) {
		super();
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.author = author;
	}


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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1, name="flashcardSequence", sequenceName="SQ_FLASHCARD_PK")
	@Column(name="FLASHCARD_ID")
	private int id;
	@Column(name="QUESTION")
	private String question;
	@Column(name="ANSWER")
	private String answer;
	@Column(name="TOPIC")
	private FlashcardTopics topic;
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
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
