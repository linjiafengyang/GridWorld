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

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains quick crab critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrabRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 2), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(1, 6), new Rock());
        world.add(new Location(1, 1), new Rock());
        world.add(new Location(0, 0), new Flower());
        world.add(new Location(2, 2), new Flower());
        world.add(new Location(3, 5), new Flower());
        world.add(new Location(3, 0), new Flower());
        world.add(new Location(6, 5), new Bug());
        world.add(new Location(1, 3), new Bug());
        world.add(new Location(2, 5), new QuickCrab());
        world.add(new Location(6, 1), new QuickCrab());
        world.add(new Location(1, 2), new QuickCrab());
        world.show();
    }
}