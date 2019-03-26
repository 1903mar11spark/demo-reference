package com.revature.example;

public class Tuesday {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		funWithWrapperClasses();
	}
	
	static void funWithWrapperClasses() {
		
		//integer-valued primitives
		byte b = 5;
		short s = 6;
		int i = 7;
		long l = 8; 
		
		Integer j = i; //autoboxing
		b = new Byte((byte)9);  //narrowing conversion - be careful! 
		
		//String to number conversions
		String str = "55.4";
		Double d = Double.parseDouble(str); 
		d = 77.4;
		
		//check type of d
		System.out.println(d.getClass());
		//or another way
		boolean isDouble = (d instanceof java.lang.Double);
		System.out.println(isDouble);
		
	//	str = i; //no more loose typing
		
	}

}
