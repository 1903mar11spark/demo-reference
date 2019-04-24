/**
 * 
 */
package com.revature.dao;

import java.util.List;

import com.revature.beans.Bat;

/**
 * @author emily
 *
 */
public interface BatDAO {
	
	public Bat getBatById(int id);
	
	public List<Bat> getAllBats();
	
	public boolean addBat(Bat bat);
	
	public boolean updateBat(Bat bat);
	
	public boolean deleteBat(Bat bat);

}
