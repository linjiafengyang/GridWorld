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

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * A <code>QuickCrab</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
    /**
     * @return list of empty locations immediately to the right and to the left in two steps
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        
        Location loc1 = getLocation().getAdjacentLocation(getDirection() + Location.LEFT);
        if (gr.isValid(loc1) && gr.get(loc1) == null) {
            int[] dirs = { Location.LEFT };
            for (Location loc : getLocationsInDirections(dirs, loc1)) {
                if (getGrid().get(loc) == null) {
                	locs.add(loc);
                }
            }
        }

        Location loc2 = getLocation().getAdjacentLocation(getDirection() + Location.RIGHT);
        if (gr.isValid(loc2) && gr.get(loc2) == null) {
            int[] dirs = { Location.RIGHT };
            for (Location loc : getLocationsInDirections(dirs, loc2)) {
                if (getGrid().get(loc) == null) {
                	locs.add(loc);
                }
            }
        }

        return locs;
    }
    
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions, Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc)) {
            	locs.add(neighborLoc);
            }
        }
        return locs;
    }
}