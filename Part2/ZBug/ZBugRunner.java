import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class ZBugRunner {
	// set the LENGTH(sideLength) = 6
	public static final int LENGTH = 6;
	// set the initial position of Bug
	public static final int ROW = 0;
	public static final int COLUMN = 0;
	
	private ZBugRunner() {}

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        ZBug alice = new ZBug(LENGTH);
        alice.setColor(Color.ORANGE);
        world.add(new Location(ROW, COLUMN), alice);
        world.show();
	}

}
