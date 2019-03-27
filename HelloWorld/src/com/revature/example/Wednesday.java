package com.revature.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.revature.transport.Kayak;

public class Wednesday {

	public static void main(String[] args) {
		//funWithEqualsAndHashcode();
		ArrayList<Kayak> ar1 = new ArrayList<>();
		ArrayList<Kayak> ar2 = new ArrayList<>();
		
		Kayak k1 = new Kayak(3.4, "green");
		Kayak k2 = new Kayak(3.4, "blue");
		Kayak k3 = new Kayak(2.5, "red");
		
		Kayak k4 = new Kayak(5.5, "yellow");
		Kayak k5 = new Kayak(3.4, "blue");
		Kayak k6 = new Kayak(5.5, "red");
		
		ar1.add(k1);
		ar1.add(k2);
		ar1.add(k3);
		
		ar2.add(k4);
		ar2.add(k5);
		ar2.add(k6);
		
		System.out.println(stepThroughCollections(ar1, ar2));
	}
	
	//iterate through two collections of the same type in the same position and return first matching element
	static <E> E stepThroughCollections(Collection<E> c1, Collection <E> c2) {
		E match = null;
		Iterator<E> i1 = c1.iterator();
		Iterator<E> i2 = c2.iterator();
		while (i1.hasNext() && i2.hasNext()) {
			E e = i1.next();
			if(e.equals(i2.next())) {
				match = e;
				break;
			}
		}
		return match;
	}

	static void funWithEqualsAndHashcode() {

		Kayak k1 = new Kayak(3.4, "green");
		Kayak k2 = new Kayak(3.4, "green");

		if (k1 == k2) {
			System.out.println("k1 and k2 are the same object");
		} else {
			System.out.println("k1 and k2 are not the same object");
		}
		
		if (k1.equals(k2)) {
			System.out.println("k1 and k2 are equal");
		} else {
			System.out.println("k1 and k2 are not equal");
		}
		
		System.out.println("k1 hashcode value: "+k1.hashCode());
		System.out.println("k2 hashcode value: "+k2.hashCode());
		
		Kayak k3 = new Kayak(2.5, "red");
		
		System.out.println("k3 hashcode value: "+k3.hashCode());
	}

}
