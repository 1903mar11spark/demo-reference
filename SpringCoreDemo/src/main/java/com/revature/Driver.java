package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Flashcard;

public class Driver {
	
	public static void main(String[] args) {
		// access Application Context, from which we get all our beans
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		//obtain an instance of Flashcard from the A.C
		Flashcard f = (Flashcard) ((AbstractApplicationContext) ac).getBean("flashcard");
		System.out.println(f.toString());
		
		// could we have made ac THIS supertype and not needed to cast? YES! 
		// but now you know about the hierarchy
		// always close the AC when you're finished
		((AbstractApplicationContext) ac).close();
	}

}
