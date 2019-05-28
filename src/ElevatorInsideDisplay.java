

public class ElevatorInsideDisplay {
	private EC ctrl ;
	public ElevatorInsideDisplay(EC ctrl) {
		this.ctrl = ctrl ;
	}
	public void update() {
		int curFlr = ctrl.getCurFlr() ;
		System.out.println("Elevator Inside Display: " + curFlr) ;
	}
}
