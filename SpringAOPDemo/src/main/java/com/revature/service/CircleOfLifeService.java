package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.creatures.Animal;
import com.revature.exception.GotEatenException;

public class CircleOfLifeService {
	
	private static Logger log = Logger.getRootLogger();

	public void chase(Animal a1, Animal a2) throws GotEatenException {
		log.info(a1+" is chasing " +a2);
		if (a1.getSpeed() > a2.getSpeed()) {
			this.capture(a1, a2);
		}
	}
	
	public void capture(Animal a1, Animal a2) throws GotEatenException {
		log.warn(a1+" caught "+ a2);
		if (a1.isHungry()) {
			log.fatal(a1+" ate "+ a2);
			throw new GotEatenException();
		}
	}

}
