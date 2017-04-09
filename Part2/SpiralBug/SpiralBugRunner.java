import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class SpiralBugRunner {
	// set the LENGTH(sideLength) = 3
	public static final int LENGTH = 3;
	// set the initial position of Bug
	public static final int ROW = 5;
	public static final int COLUMN = 5;

	private SpiralBugRunner() {}

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        SpiralBug alice = new SpiralBug(LENGTH);
        alice.setColor(Color.ORANGE);
        world.add(new Location(ROW, LENGTH), alice);
        world.show();
	}

}
