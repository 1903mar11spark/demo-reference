package com.revature.service;

import com.revature.creatures.Animal;
import com.revature.exception.GotEatenException;

public class CircleOfLifeService {

	public void chase(Animal a1, Animal a2) throws GotEatenException {
		System.out.println(a1+" is chasing " +a2);
		if (a1.getSpeed() > a2.getSpeed()) {
			this.capture(a1, a2);
		}
	}
	
	public void capture(Animal a1, Animal a2) throws GotEatenException {
		System.out.println(a1+" caught "+ a2);
		if (a1.isHungry()) {
			throw new GotEatenException();
		}
	}

}
