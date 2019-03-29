package com.revature.comparison;

import java.util.Comparator;

import com.revature.transport.Kayak;

public class KayakLengthCompare implements Comparator<Kayak> {
	
	@Override
	public int compare(Kayak k1, Kayak k2) {
		return (new Double(k1.getLength())).compareTo(k2.getLength());
	}

}
