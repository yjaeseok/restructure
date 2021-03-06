
import java.util.Calendar;
import java.util.List;
class SimpleElevatorManager {
	private List<ElevatorController> ctrls ;

	public SimpleElevatorManager(final List<ElevatorController> ctrls) {
		this.ctrls = ctrls;
	}	
	public void requestElevator(final Floor dest, final Direction dir) {
		int select;
		// 0..23
		if ( isBefore12AM() ) { // ����; Response Time Scheduler
			select = ctrls.size() -1;
		}
		else { // ����; Throughput Scheduler
			select = 0;
		}
		printRequestElevator(select);
		ctrls.get(select).goTo(dest) ;
	}

	private void printRequestElevator(int select) {
		System.out.println("ThroughputScheduler selects " + select);
	}

	private boolean isBefore12AM() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 12;
	}

	public void emergencyStop(final boolean goTo1stFloor) {
		for ( ElevatorController ctrl: ctrls )
			if ( goTo1stFloor ) {
				ctrl.getFloorstobeVisited().clear();
				ctrl.goTo(new Floor(1));
			}
			else
				ctrl.stop();
	}
	public boolean isToBeVisistedFloor(final Floor flr) {
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