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
import java.util.LinkedList;


/**
 * A <code>SparseBoundedGrid</code> is a rectangular gird with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
	private ArrayList<LinkedList<OccupantInCol>> occupantArray;
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
	public SparseBoundedGrid(int rows, int cols) {
		// judge and throw exception
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		row = rows;
		col = cols;
		
		occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
		for (int i = 0; i < row; i++) {
			LinkedList<OccupantInCol> newList = new LinkedList<OccupantInCol>();
			occupantArray.add(newList);
		}
	}
	// return the occupied locations
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> theLocations = new ArrayList<Location>();
		// look at the occupied location
		for (int r = 0; r < getNumRows(); r++) {
			LinkedList<OccupantInCol> list = occupantArray.get(r);
			for (int i = 0; i < list.size(); i++) {
				OccupantInCol object = list.get(i);
				theLocations.add(new Location(r, object.getCol()));
			}
		}
		return theLocations;
	}
	// get the (E)object according to a location
	public E get(Location loc) {
		// judge if loc is valid, if not throw exception
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		int locRow = loc.getRow();
		int locCol = loc.getCol();
		
		LinkedList<OccupantInCol> list = occupantArray.get(locRow);
		for (int i = 0; i < list.size(); i++) {
			OccupantInCol object = list.get(i);
			if (object.getCol() == locCol) {
				// unavoidable warning
				return (E)object.getObject();
			}
		}
		return null;
	}
	// put the (E)object to the location
	public E put(Location loc, E obj) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		if (obj == null) {
			throw new NullPointerException("obj == null");
		}
		
		int locRow = loc.getRow();
		int locCol = loc.getCol();
		// add the object to the grid
		E oldOccupant = get(loc);
		OccupantInCol object;
		
		LinkedList<OccupantInCol> list = occupantArray.get(locRow);
		for (int i = 0; i < list.size(); i++) {
			object = list.get(i);
			if (object.getCol() == locCol) {
				object.setObject(obj);
				return oldOccupant;
			}
		}
		// add the new object to the LinkedList<OccupantInCol>
		object = new OccupantInCol(obj, locCol);
		list.add(object);
		
		return oldOccupant;
	}
	// remove the object from the grid
	public E remove(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location" + loc + " is not valid");
		}
		int locRow = loc.getRow();
		int locCol = loc.getCol();
		E r = get(loc);
		// remove from the LinkedList<OccupantInCol>
		LinkedList<OccupantInCol> list = occupantArray.get(locRow);
		for (int i = 0; i < list.size(); i++) {
			OccupantInCol object = list.get(i);
			if (object.getCol() == locCol) {
				list.remove(i);
			}
		}
		return r;
	}
}