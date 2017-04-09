import info.gridworld.actor.Bug;

public class ZBug extends Bug{
	private int steps;
	private int sideLength;
	
	// means the maximum of steps
	private int totalLength;
	
	public static final int NUM = 3;
	
	// ZBug faces EAST, EAST means 90 degrees
	public static final int EAST = 90;
	
	// ZBug turns 225 degrees to move forward
	public static final int SOUTHWEST = 225;
	
	public ZBug(int length) {
		steps = 0;
		sideLength = length;
		
		// the largest steps that ZBug can move
		totalLength = NUM * length;
		
		// initialize the direction of ZBug
		setDirection(EAST);
	}
	
	public void act() {
		// if steps is less than totalLength
		// then ZBug can move 
		if (steps < totalLength && canMove()) {
			move();
			steps++;
			// the first time to change direction
			// set the direction as 225 degrees(SOUTHWEST)
			if (steps / sideLength == 1 && steps % sideLength == 0) {
				setDirection(SOUTHWEST);
			}
			// the second time to change direction
			// set the direction as 90 degrees(EAST)
			else if(steps / sideLength == 2 && steps % sideLength == 0) {
				setDirection(EAST);
			}
		}
	}
}
