package info.gridworld.maze;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	private Location next;
	private boolean isEnd = false;
	private Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	private Integer stepCount = 0;
	private boolean hasShown = false;// final message has been shown

	private boolean isVisit[][];
	ArrayList<Location> branch;
	private int left, right, ahead, behind;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		int size = 100;
		isVisit = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				isVisit[i][j] = false;
			}
		}
		Location loc = getLocation();
		branch = new ArrayList<Location>();
		branch.add(loc);

		left = 1;
		right = 1;
		ahead = 1;
		behind = 1;
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		// reach the goal
		if (isEnd == true) {
			// to show step count when reach the goal
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		}
		// can move
		else if (willMove) {
			isVisit[next.getRow()][next.getCol()] = true;
			move();
			// increase step count when move
			stepCount++;
		}
		// can't move
		// go back
		else {
			goBack();
			// also increase step count
			stepCount++;
		}
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return null;
		}
		ArrayList<Location> valid = new ArrayList<Location>();
		// four directions
		int[] dirs = { Location.AHEAD, Location.LEFT, 
			Location.RIGHT, Location.HALF_CIRCLE };
		// get the valid directions in the four directions
		for (int d: dirs) {
			Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
			int row = neighborLoc.getRow();
			int col = neighborLoc.getCol();
			// judge whether neighbor locations is valid or not
			if (gr.isValid(neighborLoc)) {
				Actor a = gr.get(neighborLoc);
				// null or a Flower and haven't been visited
				// then add it to the array list
				if ((a == null || a instanceof Flower) && !isVisit[row][col]) {
					valid.add(neighborLoc);
				}
				// a Rock whose color is red
				// means it is the end.
				else if (a instanceof Rock && a.getColor().equals(Color.RED)) {
					isEnd = true;
				}
			}
		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		ArrayList<Location> loc = getValid(getLocation());
		// there is no valid locations in the array list
		if (loc.isEmpty()) {
			return false;
		}
		else {
			branch.add(getLocation());
			// the size of the array list that contains valid locations
			int locSize = loc.size();
			if (locSize >= 2) {
				crossLocation.push(branch);
				branch = new ArrayList<Location>();
				next = betterDirection(loc);
			}
			else {
				next = loc.get(0);
			}
		}
		return true;
	}
	// 进阶部分
	public Location betterDirection(ArrayList<Location> locs) {
		int direction;
		int leftD = 0;
		int rightD = 0;
		int aheadD = 0;
		int behindD = 0;
		// 从当前MazeBug的方向获取其前进方向，置1
		for (Location loc : locs) {
			direction = getLocation().getDirectionToward(loc);
			if (direction == 0) {
				aheadD = ahead;
			}
			else if (direction == 90) {
				rightD = right;
			}
			else if (direction == 180) {
				behindD = behind;
			}
			else if (direction == 270) {
				leftD = left;
			}
		}
		// 方向随机，随机时不可能往回走，所以要加1才能保证random范围为0-4
		int random = 1 + (int)(Math.random() * (leftD + rightD + aheadD + behindD));
		// 0-1
		if (random <= leftD) {
			direction = 270;
			left++;
		}
		// 1-2
		else if (random <= (leftD + rightD)) {
			direction = 90;
			right++;
		}
		// 2-3
		else if (random <= (leftD + rightD + aheadD)) {
			direction = 0;
			ahead++;
		}
		// 3-4
		else {
			direction = 180;
			behind++;
		}
		
		Location betterLoc = null;
		for (Location loc : locs) {
			if (direction == getLocation().getDirectionToward(loc)) {
				betterLoc = loc;
			}
		}
		return betterLoc;
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		Location loc = getLocation();
		// move forward
		if (gr.isValid(next)) {
			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
		}
		else {
			removeSelfFromGrid();
		}
		// put the flower
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
	// 回溯
	public void goBack() {
		if (branch.isEmpty()) {
			branch = crossLocation.pop();
			Location loc = branch.get(branch.size() - 1);
			int direction = getLocation().getDirectionToward(loc);
			if (direction == 0) {
				behind--;
			}
			else if (direction == 90) {
				left--;
			}
			else if (direction == 180) {
				ahead--;
			}
			else {
				right--;
			}
		}
		next = branch.remove(branch.size() - 1);
		move();
	}
}