/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;



/**
 * A <code>UnBoundedGrid2</code> is a rectangular gird with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class UnboundedGrid2<E> extends AbstractGrid<E>
{
	private Object[][] occupantArray;
	private int INITSIZE = 16;
	private int currentSize;
	
	public UnboundedGrid2() {
		currentSize = 16;
		occupantArray = new Object[INITSIZE][INITSIZE];
	}
	public int getNumRows() {
		return -1;
	}
	public int getNumCols() {
		return -1;
	}
	public boolean isValid(Location loc) {
		return loc.getRow() >= 0 && loc.getCol() >= 0;
	}
	// return the occupied locations
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> theLocations = new ArrayList<Location>();
		// Look at all grid locations.
		for (int r = 0; r < currentSize; r++) {
			for (int c = 0; c < currentSize; c++) {
				// If there's an object at this location, put it in the array.
				Location location = new Location(r, c);
				if (get(location) != null)
					theLocations.add(location);
			}
		}
		return theLocations;
	}
	
	public E get(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		if (loc.getRow() >= currentSize || loc.getCol() >= currentSize) {
			return null;
		}
		// unavoidable warning
		return (E) occupantArray[loc.getRow()][loc.getCol()];
	}
	
	public E put(Location loc, E obj) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		if (obj == null) {
			throw new NullPointerException("obj == null");
		}
		
		int row = loc.getRow();
		int col = loc.getCol();
		// judge and extend the size of grid
		int newSize = currentSize;
		while (row > newSize - 1 || col > newSize - 1) {
			newSize *= 2;
		}
		if (newSize != currentSize) {
			extendGrid(newSize);
		}
		
		E oldOccpuant = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = obj;
		return oldOccpuant;
	}
	// extend the size of grid
	private void extendGrid(int newSize) {
		// copy the current array to the new array
		Object[][] newoccupantArray = new Object[newSize][newSize];
		for (int i = 0; i < currentSize; i++) {
			System.arraycopy(occupantArray[i], 0, newoccupantArray[i], 0, currentSize);
		}
		occupantArray = newoccupantArray;
		currentSize = newSize;
	}
	public E remove(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		// Remove the object from the grid.
		E r = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = null;
		return r;
	}
}