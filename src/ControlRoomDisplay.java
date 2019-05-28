

public class ControlRoomDisplay {
	private ElevatorController ctrl ;

	public ControlRoomDisplay(ElevatorController elevatorController) {
		this.ctrl = elevatorController ;
	}
	public void update() {
		int curFlr = ctrl.getCurFlr() ;
		System.out.println("Control Room: " + curFlr) ;
	}
}
