public class Driver {

	public static void main(String[] args) {
		init();
	}

	public static void init() {
		System.out.println("this is the point of entry into my program");

		//make a car object with no set fields
		Car carOne = new Car();
		System.out.println("carOne: "+carOne); 
		//concatenating an object to a string will call object's toString() method
		//toString() is inherited from Object and, if overridden, should include a representation of the object's fields
		//if NOT OVERRIDDEN.. it returns the heap memory address of the object
		
		//make a car object with field values!
		Car carTwo = new Car(2011, "Accord", "Honda");
		System.out.println("carTwo: "+carTwo);
	}
 
}
