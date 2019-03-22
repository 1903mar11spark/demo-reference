public class ExceptionsDemo {
	
	public static void main(String[] args) {
		System.out.println("before exception-throwing method");		
		checkedExceptions();
		System.out.println("after exception-throwing method");
	}

	static void uncheckedExceptions() {
		Object o = null;
		//this will compile..
		System.out.println(o.toString());
	}

	static void checkedExceptions() {
		Car c = new Car();
		c.setMilesSinceOilChange(5500);
		try{
			c.move();
		} catch (MaintenanceException e) {
			e.printStackTrace();
		}
		//multiple catch blocks??
		//yes! 
		//But order them least general - most general
	}
}
