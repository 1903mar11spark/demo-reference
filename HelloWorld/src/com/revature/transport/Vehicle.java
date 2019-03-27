package com.revature.transport;

public abstract class Vehicle {
	
	public Vehicle(int topSpeed) {
		super();
		this.topSpeed = topSpeed;
		System.out.println("vehicle args constructor completed");
	}

	public Vehicle() {
		super();
		System.out.println("vehicle noargs constructor completed");
	}
	
	private int topSpeed;
	
	public abstract void move();

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

}
