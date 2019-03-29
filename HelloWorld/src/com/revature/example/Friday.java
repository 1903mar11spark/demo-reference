package com.revature.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.comparison.KayakLengthCompare;
import com.revature.transport.Kayak;

public class Friday {

	public static void main(String[] args) {

		List<Kayak> kayakList = new ArrayList<>();
		kayakList.add(new Kayak(3.4, "green"));
		kayakList.add(new Kayak(4.7, "red"));
		kayakList.add(new Kayak(2.0, "green"));
		kayakList.add(new Kayak(5.2, "blue"));

		//
		//sortWithComparator(kayakList, new KayakLengthCompare());
		
		//anonynmous inner class to define comparsion by color
		kayakList.sort(new Comparator<Kayak>() {
			@Override
			public int compare(Kayak k1, Kayak k2) {
				return k1.getColor().compareTo(k2.getColor());
			}
		});
		
		//or comparsion with lambdas!
		kayakList.sort((Kayak k1, Kayak k2)-> k1.getColor().compareTo(k2.getColor()));
		for (Kayak k : kayakList) {
			System.out.println(k);
		}
		//lists have sort method as of Java 8, so Collections.sort() is not REALLY necessary. 
	}

	static void sortWithComparable(List<Kayak> kl) {

		Collections.sort(kl);
		for (Kayak k : kl) {
			System.out.println(k);
		}

	}

	static void sortWithComparator(List<Kayak> kl, Comparator<Kayak> c) {

		Collections.sort(kl, c);
		for (Kayak k : kl) {
			System.out.println(k);
		}

	}

}
