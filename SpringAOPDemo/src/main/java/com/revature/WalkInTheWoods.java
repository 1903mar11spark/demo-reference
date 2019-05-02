package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.creatures.Bear;
import com.revature.creatures.Human;
import com.revature.exception.GotEatenException;
import com.revature.service.CircleOfLifeService;

public class WalkInTheWoods {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Human h = new Human();
		h.setSpeed(20);
		
		Bear b = new Bear();
		b.setSpeed(10);
		b.setHungry(true);
		
		CircleOfLifeService cls = (CircleOfLifeService) ac.getBean("circleOfLifeService");
		try {
			cls.chase(b, h);
		} catch (GotEatenException e) {
			e.printStackTrace();
		}
		
		ac.close();
	}

}
