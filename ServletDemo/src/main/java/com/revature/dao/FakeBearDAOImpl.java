package com.revature.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;

public class FakeBearDAOImpl implements BearDAO {
	
	private List<Bear> allBears = new ArrayList<>();
	
	public FakeBearDAOImpl() {
		Cave c1 = new Cave(3, "Tampa", 5);
		BearType bt = new BearType(1, "Grizzly");
		Bear b1 = new Bear(4, "Susan", c1, bt, 500, LocalDate.of(2000, Month.DECEMBER, 14));
		Bear b2 = new Bear(5, "Bob", c1, bt, 350, LocalDate.of(1942, Month.FEBRUARY, 21));
		allBears.add(b1);
		allBears.add(b2);
	}

	@Override
	public List<Bear> getBears() {
		return allBears;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double feedBear(int bearId, int hiveId, double amt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
