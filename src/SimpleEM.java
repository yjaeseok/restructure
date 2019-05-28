
import java.util.Calendar;
import java.util.List;
class SimpleEM {
	private List<EC> ctrls ;

	public SimpleEM(List<EC> ctrls) {
		this.ctrls = ctrls;
	}	
	public void requestElevator(int dest, int dir) {
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
	public void emergencyStop(boolean goTo1stFloor) {
		for ( EC ctrl: ctrls )
			if ( goTo1stFloor ) {
				ctrl.getFloorstobeVisited().clear();
				ctrl.goTo(1);
			}
			else
				ctrl.stop();
	}
	public boolean isToBeVisistedFloor(int flr) {
		for ( EC ctrl: ctrls ) {
			if ( ctrl.getFloorstobeVisited().contains(flr) ) return true;
		}
		return false;
	}
	public void print() {
		for ( EC ctrl: ctrls ) {
			print(ctrl);
		}
	}
	private void print(EC ctrl) {
		System.out.println(ctrl.getCurFlr());
		System.out.println(ctrl.getCurDir());
		System.out.println(ctrl.getFloorstobeVisited());
	}
}