


import java.util.TimerTask;

class DoorTimerTask extends TimerTask {
	private EC doorTimeout;

	public void run() {
		doorTimeout.doorTimeout() ;
	}

	public void setDoorTimeout(EC doorTimeout) {
		this.doorTimeout = doorTimeout;
	}	
}
