


import java.util.TimerTask;

class DoorTimerTask extends TimerTask {
	private ElevatorController doorTimeout;

	public void run() {
		doorTimeout.doorTimeout() ;
	}

	public void setDoorTimeout(ElevatorController doorTimeout) {
		this.doorTimeout = doorTimeout;
	}	
}
