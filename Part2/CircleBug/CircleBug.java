import info.gridworld.actor.Bug;
public class CircleBug extends Bug {
	private int steps;
	private int sideLength;

	public CircleBug(int length) {
		steps = 0;
		sideLength = length;
	}

	public void act() {
		// if current steps is less than sideLength
		// it can move on and let steps + 1
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		}
		else {
			// only turn once to make it move as a regular hexagon
			turn();
			steps = 0;
		}
	}
}