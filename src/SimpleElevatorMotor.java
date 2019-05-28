
import java.util.Calendar;
import java.util.List;
class SimpleElevatorMotor {
	private List<ElevatorController> ctrls ;

	public SimpleElevatorMotor(final List<ElevatorController> ctrls) {
		this.ctrls = ctrls;
	}	
	public void requestElevator(final int dest, final Direction dir) {
		int sel;
		// 0..23
		int hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if ( hr < 12 ) { // 오전; Response Time Scheduler
			sel = ctrls.size() -1;
			System.out.println("ThroughputScheduler selects " + sel);
		}
		else { // 오후; Throughput Scheduler
			sel = 0;
			System.out.println("ThroughputScheduler selects " + sel);
		}
		ctrls.get(sel).goTo(dest) ;
	}
	public void emergencyStop(final boolean goTo1stFloor) {
		for ( ElevatorController ctrl: ctrls )
			if ( goTo1stFloor ) {
				ctrl.getFloorstobeVisited().clear();
				ctrl.goTo(1);
			}
			else
				ctrl.stop();
	}
	public boolean isToBeVisistedFloor(final int flr) {
		for ( ElevatorController ctrl: ctrls ) {
			if ( ctrl.getFloorstobeVisited().contains(flr) ) return true;
		}
		return false;
	}
	public void print() {
		for ( ElevatorController ctrl: ctrls ) {
			print(ctrl);
		}
	}
	private void print(final ElevatorController ctrl) {
		System.out.println(ctrl.getCurrentElevatorFloor());
		System.out.println(ctrl.getCurrentElevatorDirection());
		System.out.println(ctrl.getFloorstobeVisited());
	}
}