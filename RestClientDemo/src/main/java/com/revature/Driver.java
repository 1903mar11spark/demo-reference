package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Flashcard;
import com.revature.client.FlashcardClient;

public class Driver {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		FlashcardClient fc = ac.getBean("flashcardClient", FlashcardClient.class);
		fc.setResourceUrl("http://ec2-3-82-216-136.compute-1.amazonaws.com:8083/");
		
		for (Flashcard f : fc.getFlashcards()) {
			System.out.println(f);
		}
		
		ac.close();

	}

}
