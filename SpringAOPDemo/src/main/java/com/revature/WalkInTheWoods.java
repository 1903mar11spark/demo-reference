package com.revature;

import com.revature.creatures.Bear;
import com.revature.creatures.Human;
import com.revature.exception.GotEatenException;
import com.revature.service.CircleOfLifeService;

public class WalkInTheWoods {

	public static void main(String[] args) {
		
		Human h = new Human();
		h.setSpeed(20);
		
		Bear b = new Bear();
		b.setSpeed(30);
		b.setHungry(true);
		
		CircleOfLifeService cls = new CircleOfLifeService();
		try {
			cls.chase(b, h);
		} catch (GotEatenException e) {
			e.printStackTrace();
		}
	}

}
