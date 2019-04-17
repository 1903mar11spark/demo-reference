package com.revature.service;

import java.util.List;

import com.revature.beans.Bear;
import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;

public class BearServiceImpl implements BearService {
	
	//this service is pretty lean right now. 
	//We're not doing anything but simple CRUD methods on Bears. 
	
	private BearDAO bd = new BearDAOImpl();

	@Override
	public List<Bear> allBears() {
		return bd.getBears();
	}

	@Override
	public Bear getBearById(int id) {
		return bd.getBearById(id);
	}

}
