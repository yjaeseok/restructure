
public class ElevatorDestinationRequest {
	private final EC ctrl;
	private int flr;
	
	public ElevatorDestinationRequest(int floor, 	EC ctrl) {
		this.flr = floor;
		this.ctrl = ctrl;
	}
	public void pressed() {
		ctrl.goTo(flr);
	}
}
