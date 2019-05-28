
import java.util.Timer;

public class JavaDT {
	private Timer timer;
	private DoorTimerTask task;
	
	public JavaDT() {
		task = new DoorTimerTask() ;
		timer = new Timer() ;
	}
	public void setDoorTimeout(ElevatorController doorTimeout) {
		task.setDoorTimeout(doorTimeout);
	}
	public void start() {
		timer.schedule(task, 1000) ;
	}
	public void stop() {
		timer.cancel() ;
	}
}