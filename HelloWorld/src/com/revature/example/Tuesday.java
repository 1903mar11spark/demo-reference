package com.revature.example;

import java.util.ArrayList;
import java.util.List;

//does NOTHING!!!!!!!!!!!!! except save us typing 
import com.revature.transport.Car;
import com.revature.transport.Chairlift;
import com.revature.transport.Kayak;
import com.revature.transport.Steerable;
import com.revature.transport.Vehicle;

/*
 * import statements: 
 * import com.revature.transport.* => every class in the transport package (single level) 
 * import com.revature.Car => just the Car class
 * import static com.revature.someotherpackage.ClassInSomeOtherPackage.* => all static members of ClassInSomeOthePackage
 * import static com.revature.someotherpackage.ClassInSomeOtherPackage.STATICMEMBER => just STATICMEMBER
 */

public class Tuesday {

	public static void main(String[] args) {
		System.out.println("Hello World");
		funWithTransport();
	}

	static void funWithTransport() {

		// using fully qualified classname to refer to Kayak.
		// this always works!
		com.revature.transport.Kayak k1 = new com.revature.transport.Kayak(3.3, "red");

		// using import statement:
		Kayak k2 = new Kayak(4.5, "blue");

		// make some more Vehicles
		Car c1 = new Car(1999, "Mazda", "Miata");
		Car c2 = new Car(2018, "Tesla", "Model S");
		Chairlift cl1 = new Chairlift(12, 950);

		// create and populate a List of Vehicles
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(k2);
		vehicles.add(c1);
		vehicles.add(k1);
		vehicles.add(cl1);
		vehicles.add(c2);

		for (Vehicle v : vehicles) {
			System.out.println(v);
			v.move();
			if (v instanceof Steerable) {
				((Steerable) v).turnLeft();
			}
		}

	}

	static void funWithWrapperClasses() {

		// integer-valued primitives
		byte b = 5;
		short s = 6;
		int i = 7;
		long l = 8;

		Integer j = i; // autoboxing
		b = new Byte((byte) 9); // narrowing conversion - be careful!

		// String to number conversions
		String str = "55.4";
		Double d = Double.parseDouble(str);
		d = 77.4;

		// check type of d
		System.out.println(d.getClass());
		// or another way
		boolean isDouble = (d instanceof java.lang.Double);
		System.out.println(isDouble);

		// str = i; //no more loose typing

	}

}
