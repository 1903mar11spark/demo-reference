package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;
import com.revature.beans.ComponentScannedFlashcard;
import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopics;
import com.revature.beans.FlashcardWithAutoByName;
import com.revature.beans.FlashcardWithAutoByType;
import com.revature.beans.FlashcardWithConstructor;
import com.revature.beans.FlashcardWithSetter;

public class StudySession {

	public static void main(String[] args) {

		// access IoC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		funWithFlashcards(ac);
		
		// close ApplicationContext
		((AbstractApplicationContext) ac).close();

	}
	
	static void funWithFlashcards(ApplicationContext ac) {
		Flashcard f1 = (FlashcardWithSetter) ac.getBean("flashcardWithSetter");
		f1.setTopic(FlashcardTopics.BEARS);
		f1.setQuestion("How many bears are there?");
		f1.setAnswer("7 bears");
		System.out.println(f1);
		
		Flashcard f2 = (FlashcardWithConstructor) ac.getBean("flashcardWithConstructor");
		f2.setTopic(FlashcardTopics.MATH);
		f2.setQuestion("What's 9 plus 10?");
		f2.setAnswer("7 bears");
		System.out.println(f2);
		/*
		Flashcard f3 = (FlashcardWithAutoByName) ac.getBean("flashcardWithAutoByName");
		f3.setTopic(FlashcardTopics.CODING);
		f3.setQuestion("What is Java?");
		f3.setAnswer("7 bears");
		System.out.println(f3);
		
		Flashcard f4 = (FlashcardWithAutoByType) ac.getBean("flashcardWithAutoByType");
		f4.setTopic(FlashcardTopics.CODING);
		f4.setQuestion("What is JavaScript?");
		f4.setAnswer("7 bears, or maybe not");
		System.out.println(f4);
		
		Flashcard f5 = (ComponentScannedFlashcard) ac.getBean("componentScannedFlashcard");
		f5.setTopic(FlashcardTopics.BEARS);
		f5.setQuestion("What's for lunch?");
		f5.setAnswer("People and/or various plants");
		System.out.println(f5); */
	}

	static void funWithAuthors(ApplicationContext ac) {
		// throws NoSuchBeanDefinitionException if name provided does not match anything
		// in IoC container
		Author a1 = (Author) ac.getBean("author");
		Author a2 = (Author) ac.getBean("author");
		// default scope of a Spring bean is SINGLETON
		// one instance per application context
		System.out.println("a1 and a2 are the same object: " + (a1 == a2));
	}

}
