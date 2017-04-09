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

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


/**
 * This class runs a world that contains bluster critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BlusterCritterRunner
{
	public static final int COURAGE = 3;
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(1, 1), new BlusterCritter(COURAGE, Color.red));
        world.add(new Location(7, 2), new BlusterCritter(COURAGE, Color.black));
        world.add(new Location(3, 0), new BlusterCritter(COURAGE, Color.blue));
        world.add(new Location(0, 4), new BlusterCritter(COURAGE, Color.green));
        world.add(new Location(0, 9), new BlusterCritter(COURAGE, Color.gray));
        world.add(new Location(4, 2), new BlusterCritter(COURAGE));
        world.add(new Location(9, 0), new BlusterCritter(COURAGE));
        world.show();
    }
}