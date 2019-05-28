
public class Floor implements Comparable<Floor> {
	private int floor;
	
	public Floor(int floor) {
		this.floor = floor;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	@Override
	public int compareTo(Floor other) {
		return floor - other.getFloor();
	}
	
	@Override
	public String toString() {
		return String.valueOf(floor);
	}
}
