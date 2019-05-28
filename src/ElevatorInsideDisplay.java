

public class ElevatorInsideDisplay {
	private ElevatorController ctrl ;
	public ElevatorInsideDisplay(ElevatorController ctrl) {
		this.ctrl = ctrl ;
	}
	public void update() {
		int curFlr = ctrl.getCurFlr() ;
		System.out.println("Elevator Inside Display: " + curFlr) ;
	}
}
