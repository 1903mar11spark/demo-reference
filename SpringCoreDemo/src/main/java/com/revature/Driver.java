package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;

public class Driver {
	
	public static void main(String[] args) {
		// access Application Context, from which we get all our beans
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		//obtain an instance of Author from the A.C
		Author a = (Author) (ac).getBean("author");
		System.out.println(a.toString());
		
		// always close the AC when you're finished
		ac.close();
	}

}
