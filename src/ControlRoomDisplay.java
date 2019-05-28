

public class ControlRoomDisplay {
	private ElevatorController ctrl ;

	public ControlRoomDisplay(ElevatorController elevatorController) {
		this.ctrl = elevatorController ;
	}
	public void update() {
		int curFlr = ctrl.getCurrentElevatorFloor() ;
		System.out.println("Control Room: " + curFlr) ;
	}
}
