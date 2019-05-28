

public class EM  {
	private EC elevatorController ;
	private MotorStatus motorStatus ;
	private DeviceVendor motorVendor;
	
	public EM(DeviceVendor motorVendor) {
		this.motorVendor = motorVendor;
		motorStatus = MotorStatus.STOPPED ;
	}
	public void setElevatorController(EC elevatorController) {
		this.elevatorController = elevatorController ;
	}
	public MotorStatus getMotorStatus() {
		return motorStatus;
	}
	private void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	public void move(int currentFloor, int direction) {
		if (  getMotorStatus() == MotorStatus.MOVING ) return ;
		
		assert elevatorController != null;
		DoorStatus doorStatus = elevatorController.getDrSts(currentFloor) ;
		if ( doorStatus == DoorStatus.OPEN )
			return;
		
		switch ( motorVendor ) {
		case Hyundai:
			System.out.println("move Hyundai Motor, Direction: " + direction) ;
			break;
		case LG:
			System.out.println("move LG Motor, Direction: " + direction) ;
			break;
		case Samsung:
			System.out.println("move Samsung Motor, Direction: " + direction) ;
			break;
		default:
			break;
		}
		setMotorStatus(MotorStatus.MOVING) ;
	}
	public void stop() {
		switch ( motorVendor ) {
		case Hyundai:
			System.out.println("Hyundai Elevator Motor Stop") ;
			break;
		case LG:
			System.out.println("LG Elevator Motor Stop") ;
			break;
		case Samsung:
			System.out.println("Samsung Elevator Motor Stop") ;
			break;
		default:
			break;
		}
		setMotorStatus(MotorStatus.STOPPED);
	}
}
