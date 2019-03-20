public class Car extends Vehicle {

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
}
