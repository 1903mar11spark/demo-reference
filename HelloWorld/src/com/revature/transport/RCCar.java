package com.revature.transport;

public class RCCar extends Car {

	public RCCar() {
		super();
		System.out.println("rccar noargs constructor completed");
	}

	public RCCar(int topSpeed, int yearManufactured, String make, String model) {
		super(topSpeed, yearManufactured, make, model);
		System.out.println("rccar args constructor completed");
	}

	@Override
	public String toString() {
		return "RCCar [yearManufactured=" + getYearManufactured() + ", make=" + getMake() + ", model="
				+ getModel() + ", topSpeed=" + getTopSpeed() + "]";
	}
	
	

}
