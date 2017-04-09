// LinkedList<OccupantIncol>
public class OccupantInCol {
	private Object occupant;
	private int col;
	public OccupantInCol(Object object, int c) {
		occupant = object;
		col = c;
	}
	public void setObject(Object object) {
		occupant = object;
	}
	public void setCol(int c) {
		col = c;
	}
	public Object getObject() {
		return occupant;
	}
	public int getCol() {
		return col;
	}
}
