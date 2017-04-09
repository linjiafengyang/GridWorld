import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class DancingBugRunner {
	// set the array with 10 integer entries
	public static final int ARRAYSIZE = 10;
	// Bug can turn 8 times at most
	public static final int MAX = 8;
	// set the initial position of Bug
	public static final int ROW = 3;
	public static final int COLUMN = 3;
	
	private DancingBugRunner() {}
	
	public static void main(String[] args) {
		// create(new) an array
		int array[] = new int[ARRAYSIZE];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			// generate a random integer, store it in an array
			array[i] = random.nextInt(MAX);
		}
		ActorWorld world = new ActorWorld();
		// pass array as a parameter
		DancingBug alice = new DancingBug(array);
		alice.setColor(Color.ORANGE);
		world.add(new Location(ROW, COLUMN), alice);
		world.show();
	}

}
