
public class ElevatorRequest {
	private final int flr;
	private SimpleElevatorMotor em;

	public ElevatorRequest(int flr, SimpleElevatorMotor em) {
		this.flr = flr;
		this.em = em;
	}
	public void up() { em.requestElevator(flr, Direction.UP); }
	public void down() { em.requestElevator(flr, Direction.DOWN); }
}
