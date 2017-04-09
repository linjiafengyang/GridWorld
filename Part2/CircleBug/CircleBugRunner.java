import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class CircleBugRunner {
	// set the LENGTH(sideLength) = 6
	public static final int LENGTH = 6;
	// set the initial position of Bug
	public static final int ROW = 5;
	public static final int COLUMN = 5;

	private CircleBugRunner() {}

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug(LENGTH);
        alice.setColor(Color.ORANGE);
        world.add(new Location(ROW, COLUMN), alice);
        world.show();
	}
}