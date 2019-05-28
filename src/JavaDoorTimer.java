
import java.util.Timer;

public class JavaDoorTimer {
	private Timer timer;
	private DoorTimerTask task;
	
	public JavaDoorTimer() {
		task = new DoorTimerTask() ;
		timer = new Timer() ;
	}
	public void setDoorTimeout(final ElevatorController doorTimeout) {
		task.setDoorTimeout(doorTimeout);
	}
	public void start() {
		timer.schedule(task, 1000) ;
	}
	public void stop() {
		timer.cancel() ;
	}
}