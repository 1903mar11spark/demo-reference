package com.revature.service;
import org.springframework.stereotype.Component;

import com.revature.creatures.Animal;
import com.revature.exception.GotEatenException;

@Component
public class CircleOfLifeService {

	// we want to get rid of logging statements in application code

	// private static Logger log = Logger.getRootLogger();

	public void chase(Animal a1, Animal a2) throws GotEatenException {
		// log.info(a1+" is chasing " +a2);
		if (a1.getSpeed() > a2.getSpeed()) {
			this.capture(a1, a2);
		}
	}

	public void capture(Animal a1, Animal a2) throws GotEatenException {
		// log.warn(a1+" caught "+ a2);
		if (a1.isHungry()) {
			// log.fatal(a1+" ate "+ a2);
			throw new GotEatenException();
		}
	}

}
