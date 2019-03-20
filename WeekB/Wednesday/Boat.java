public class Boat extends Vehicle {

	public Boat() {
		super();
	}
	public Boat(String name, String color) {
		this.name = name;
		this.color = color;
	}
	private String name;
	private String color;
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override 
	public String toString() {
		return "Boat: [name="+this.name+", color="+this.color+"]";
	}
	@Override
	public void move() {
		System.out.println("boat is moving");
	}

}
