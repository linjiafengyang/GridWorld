import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;


public class SparseGridRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.addGridClass("SparseBoundedGrid");
		world.addGridClass("SparseBoundedGrid2");
		world.addGridClass("SparseBoundedGrid3");
		world.addGridClass("UnboundedGrid2");
		world.add(new Location(2, 2), new Bug());
		world.show();
	}
}
