

public class ElevatorInsideDisplay {
	private ElevatorController ctrl ;
	public ElevatorInsideDisplay(final ElevatorController ctrl) {
		this.ctrl = ctrl ;
	}
	public void update() {
		Floor curFlr = ctrl.getCurrentElevatorFloor() ;
		System.out.println("Elevator Inside Display: " + curFlr) ;
	}
}
