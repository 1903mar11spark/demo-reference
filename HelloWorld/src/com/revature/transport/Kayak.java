package com.revature.transport;

public class Kayak extends Vehicle implements Steerable {
	
	public Kayak() {
		super();
	}

	public Kayak(double length, String color) {
		super();
		this.length = length;
		this.color = color;
	}

	private double length;
	private String color;

	@Override
	public void move() {
		System.out.println("kayak is moving");
	}

	@Override
	public void turnRight() {
		System.out.println("paddle on the left");
	}

	@Override
	public void turnLeft() {
		System.out.println("paddle on the right");
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Kayak [length=" + length + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kayak other = (Kayak) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		return true;
	}

}
