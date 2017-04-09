import info.gridworld.actor.Bug;

public class DancingBug extends Bug{
	private int[] array;
	private int init;
	
	public DancingBug(int[] arr) {
		init = 0;
		array = new int[arr.length];
		System.arraycopy(arr, 0, array, 0, arr.length);
	}
	
	public void act() {
		// the times that Bug should turn
		int temp = array[init++];
		while (temp-- != 0) {
			turn();
		}
		// if the Bug has carried out the last turn
		// it should start again
		if (init == array.length) {
			init = 0;
		}
		if (canMove()) {
			move();
		}
	}

}
