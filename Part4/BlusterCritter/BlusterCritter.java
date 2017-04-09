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
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>BlusterCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
	// set the speed of getting darker or brighter
	private static final double SPEED = 0.20;
	private static final int MAXRGB = 255;
	private static final int MINRGB = 0;
	
	private int courage;
	
	public BlusterCritter(int n, Color c) {
		courage = n;
		setColor(c);
	}
	public BlusterCritter(int n) {
		courage = n;
	}
    /**
     * A critter gets the actors within two steps of its current location.
     * @return a list of actors occupying these locations
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Grid<Actor> gr = getGrid();
        Location curLocation = getLocation();

        int gridRowNum = gr.getNumRows();
        int gridColNum = gr.getNumCols();
        int row1, row2, col1, col2;
        // judge whether the locations within two steps are valid or not
        row1 = (curLocation.getRow() - 2) < 0 ? 0 : curLocation.getRow() - 2;
        row2 = (curLocation.getRow() + 2) >= gridRowNum ? gridRowNum - 1 : curLocation.getRow() + 2;
        col1 = (curLocation.getCol() - 2) < 0 ? 0 : curLocation.getCol() - 2;
        col2 = (curLocation.getCol() + 2) >= gridColNum ? gridColNum - 1 : curLocation.getCol() + 2;

        for (int i = row1; i <= row2; i++) {
        	for (int j = col1; j <= col2; j++) {
        		Location loc = new Location(i, j);
        		Actor a = gr.get(loc);
        		if (a != null) {
        			actors.add(a);
        		}
        	}
        }
        return actors;
    }
    /**
     *Removes any rocks.
     */
    public void processActors(ArrayList<Actor> actors)
    {
    	int n = actors.size();
    	Color c = getColor();
    	// darken
    	if (n >= courage) {
    		int r = ((int)(c.getRed() * (1 - SPEED))) < MINRGB ? MINRGB : (int)(c.getRed() * (1 - SPEED));
    		int g = ((int)(c.getGreen() * (1 - SPEED))) < MINRGB ? MINRGB : (int)(c.getGreen() * (1 - SPEED));
    		int b = ((int)(c.getBlue() * (1 - SPEED))) < MINRGB ? MINRGB : (int)(c.getBlue() * (1 - SPEED));
    		
    		setColor(new Color(r, g, b));
    	}
    	// brighten
    	else {
    		int r = ((int)(c.getRed() * (1 + SPEED))) > MAXRGB ? MAXRGB : (int)(c.getRed() * (1 + SPEED));
    		int g = ((int)(c.getGreen() * (1 + SPEED))) > MAXRGB ? MAXRGB : (int)(c.getGreen() * (1 + SPEED));
    		int b = ((int)(c.getBlue() * (1 + SPEED))) > MAXRGB ? MAXRGB : (int)(c.getBlue() * (1 + SPEED));
    		
    		setColor(new Color(r, g, b));
    	}
    }

}