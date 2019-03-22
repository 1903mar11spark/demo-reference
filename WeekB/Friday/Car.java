public class Car extends Vehicle {
	
	//constructor with no arguments

	public Car() {
		System.out.println("called noargs constructor");
	}

	//constructor which sets all the fields but milesSinceLastOilChange

	public Car(int yearManufactured, String model, String make) {
		this.yearManufactured = yearManufactured;
		this.model = model;
		this.make = make;
	}

	//static variable defining recommended miles between oil changes
	public static int recommendedMilesBetweenOilChange = 5000;

	//private instance variables, accessible only within the class

	private int yearManufactured;
	private String model;
	private String make;
	private int milesSinceOilChange;

	//getters and setters (accessors and mutators)

	public int getYearManufactured() {
		return this.yearManufactured;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getMake() {
		return this.make;
	}

	public int getMilesSinceOilChange() {
		return this.milesSinceOilChange;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setMilesSinceOilChange(int milesSinceOilChange) {
		this.milesSinceOilChange = milesSinceOilChange;
	}

	@Override //indicates to compiler that this method should override a method in a superclass
	public String toString() {
		return "Car:  [yearManufactured="+this.yearManufactured+", model="+this.model+", make="+
		this.make+" milesSinceOilChange="+this.milesSinceOilChange+"]";
	}
	
	@Override
	public void move() throws MaintenanceException {
		if (this.milesSinceOilChange >= recommendedMilesBetweenOilChange) {
			throw new MaintenanceException("oil needs to be changed");
		}
		System.out.println("car is moving");
	}

}
