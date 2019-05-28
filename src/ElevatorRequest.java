
public class ElevatorRequest {
	private final int flr;
	private SimpleElevatorManager elevatorManager;

	public ElevatorRequest(final int flr, final SimpleElevatorManager elevatorManager) {
		this.flr = flr;
		this.elevatorManager = elevatorManager;
	}
	public void up() { elevatorManager.requestElevator(flr, Direction.UP); }
	public void down() { elevatorManager.requestElevator(flr, Direction.DOWN); }
}
