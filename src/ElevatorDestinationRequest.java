
public class ElevatorDestinationRequest {
	private final ElevatorController ctrl;
	private int flr;
	
	public ElevatorDestinationRequest(int floor, 	ElevatorController ctrl) {
		this.flr = floor;
		this.ctrl = ctrl;
	}
	public void pressed() {
		ctrl.goTo(flr);
	}
}
