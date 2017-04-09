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
import java.util.Map;
import java.util.TreeMap;



/**
 * A <code>SparseBoundedGrid3</code> is a rectangular gird with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class SparseBoundedGrid3<E> extends AbstractGrid<E>
{
	private Map<Location, E> occupantMap;
	private int row, col;
	
	public int getNumRows() {
		return row;
	}
	public int getNumCols() {
		return col;
	}
	// judge whether the location is valid or not
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
	/**
	 * Constructs an empty bounded grid with the given dimensions.
	 * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
	 * @param rows number of rows in BoundedGrid
	 * @param cols number of columns in BoundedGrid
	 */
	public SparseBoundedGrid3(int rows, int cols) {
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		row = rows;
		col = cols;
		
		occupantMap = new TreeMap<Location, E>();
	}
	// return the occupied locations
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet()) {
            a.add(loc);
        }
        return a;
    }
    // get the (E)object according to a location
	public E get(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		if (loc == null) {
			throw new NullPointerException("loc == null");
		}

		return occupantMap.get(loc);
	}
	// put the (E)object to the location
	public E put(Location loc, E obj) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		if (loc == null) {
			throw new NullPointerException("loc == null");
		}
		if (obj == null) {
			throw new NullPointerException("obj == null");
		}
		
		return occupantMap.put(loc, obj);
	}
	// remove the object from the grid
	public E remove(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		if (loc == null) {
			throw new NullPointerException("loc == null");
		}

		return occupantMap.remove(loc);
	}
}