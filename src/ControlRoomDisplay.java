

public class ControlRoomDisplay {
	private ElevatorController ctrl ;

	public ControlRoomDisplay(final ElevatorController elevatorController) {
		this.ctrl = elevatorController ;
	}
	public void update() {
		Floor curFlr = ctrl.getCurrentElevatorFloor() ;
		System.out.println("Control Room: " + curFlr) ;
	}
}
