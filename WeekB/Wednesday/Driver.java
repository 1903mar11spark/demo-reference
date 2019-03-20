public class Driver {

	public static void main(String[] args) {
		checkTheOil();
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
		
		//test out inherited method
		carTwo.move();
	}

	public static void warehouse() {
		
		//create a variable warehouse which is an array of vehicles
		Vehicle[] warehouse = new Vehicle[5]; 
		warehouse[0] = new Boat("Black Pearl","black");
		warehouse[1] = new Boat("Boaty McBoatface", "red");
		warehouse[2] = new Car(1998, "Corvette", "Chevrolet");
		warehouse[3] = new Car(2002, "Sable", "Mercury");
		warehouse[4] = new Boat("Titanic", "rust");
		for (int i=0; i<warehouse.length; i++) {
			warehouse[i].move();
		}
	}

	public static void casting() {
		
		Object o = new Boat("Boaty McBoatface", "red"); //implicit upcasting 
		Vehicle v = (Vehicle) o; //downcasting
		v.move(); //this is fine! 
		//Car c = (Car) v; //this compiles! But throws a ClassCastException 
	}

	public static void checkTheOil() {
		Car myCar = new Car(2016, "Elantra", "Hyundai");
		myCar.setMilesSinceOilChange(3000);
		if (myCar.getMilesSinceOilChange() >= Car.recommendedMilesBetweenOilChange) {
			System.out.println("Change your oil");
		} else {
			int milesLeft = Car.recommendedMilesBetweenOilChange - myCar.getMilesSinceOilChange();
			System.out.println("You have "+milesLeft+" miles left");
		}
	}
 
}
