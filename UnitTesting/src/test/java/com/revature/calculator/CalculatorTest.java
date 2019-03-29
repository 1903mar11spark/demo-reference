package com.revature.calculator;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calc = new Calculator();
	
	double d = 0;
	double e = 0;
	
	@Test
	public void addTest( ) {
		//2+4 should 6
		assertThat(calc.add(2d,4d), is(equalTo(6d)));
		assertThat(calc.add(2d, -2d), is(equalTo(0d)));
	}
	
	@Test
	public void subTest() {
		assertThat(calc.sub(d, e), is(equalTo(-2d)));
	}
	
	@Test
	public void multTest() {
		assertThat(calc.mult(2d, 4d), is(equalTo(8d)));
	}
	
	@Test
	public void divTest() {
		assertThat(calc.div(2d, 4d), is(equalTo(.5d)));
	}
	
	@Before
	public void beforeEachTest() {
		this.d = 2;
		this.e = 4;
		System.out.println("I am Before Test");
	}
	
	@After
	public void afterEachTest() {
		this.d = 0;
		this.e = 0;
		System.out.println("I am After Test");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("I am Before Class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("I am After Class");
	}
}
