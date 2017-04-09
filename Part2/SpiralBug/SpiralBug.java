import info.gridworld.actor.Bug;

public class SpiralBug extends Bug{
	private int steps;
	private int sideLength;
	
	public SpiralBug(int length) {
		// TODO Auto-generated constructor stub
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
			// turn twice
			turn();
			turn();
			steps = 0;
			// increase the sideLength
			sideLength++;
		}
	}
}
