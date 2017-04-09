import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class JumperRunner {
	public static final int ROW = 3;
	public static final int COLUMN = 4;
	
	private JumperRunner() {}
	
	public static void main(String[] args) {
		// create a new grid world
		ActorWorld world = new ActorWorld();
		// create three actors:Jumper, Rock, Flower
		Jumper alice = new Jumper();
		world.add(new Rock());
		world.add(new Flower());
		world.add(new Location(ROW, COLUMN), alice);
		world.show();
	}

}
