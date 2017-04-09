import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Actor {
	
	// default constructor
	public Jumper() {
		setColor(Color.RED);
	}
	
	// pass color as a parameter and call setColor method
	public Jumper(Color jumperColor) {
		setColor(jumperColor);
	}
	
	// implement the act method from Actor
	public void act() {
		if (canJump()) {
			jump();
		}
		else if (canMove()) {
			move();
		}
		else {
			turn();
		}
	}
	
	private boolean canJump() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return false;
		}
		// get the current location of the Jumper
		Location loc = getLocation();
		// get the next location in the same direction
		Location next = loc.getAdjacentLocation(getDirection());
		
		// if the next location is invalid in the grid, return false(can't jump)
		if (!gr.isValid(next)) {
			return false;
		}
		
		// get the next location(nextTwo), means two steps away from the current location
		Location nextTwo = next.getAdjacentLocation(getDirection());
		
		// if the nextTwo location is invalid in the grid, then return false(can't jump)
		if (!gr.isValid(nextTwo)) {
			return false;
		}
		
		// if the neighbor in the nextTwo location is null, return true(can jump)
		Actor neighbor = gr.get(nextTwo);
		return neighbor == null;
	}
	
	private void jump() {
		Grid<Actor> gr =getGrid();
		if (gr == null) {
			return;
		}
		// get the current location of the Jumper
		Location loc = getLocation();
		// get the next location in the same direction
		Location next = loc.getAdjacentLocation(getDirection());
		
		// if the next location is valid in the grid
		if (gr.isValid(next)) {
			// get the next location(nextTwo)
			Location nextTwo = next.getAdjacentLocation(getDirection());
			
			// if the nextTwo location is valid in the grid, then move to it(two steps)
			if (gr.isValid(nextTwo)) {
				moveTo(nextTwo);
			}
			// or remove itself
			else {
				removeSelfFromGrid();
			}
		}
	}
	

	private boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return false;
		}
		// get the current location of the Jumper
		Location loc = getLocation();
		// get the next location in the same direction
		Location next = loc.getAdjacentLocation(getDirection());
		
		// if the next location is invalid in the grid, return false(can't move)
		if (!gr.isValid(next)) {
			return false;
		}
		
		// if the neighbor in the next location is null, return true(can move)
		Actor neightor = gr.get(next);
		return neightor == null;
	}
	
	private void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		// get the current location of the Jumper
		Location loc = getLocation();
		// get the next location in the same direction
		Location next = loc.getAdjacentLocation(getDirection());
		
		// if the next location is valid in the grid, then move
		if (gr.isValid(next)) {
			moveTo(next);
		}
		// or remove itself
		else {
			removeSelfFromGrid();
		}
	}
	
	private void turn() {
		// call the setDirection method implement turn method
		setDirection(getDirection() + Location.HALF_RIGHT);
	}
}
