

public class ElevatorMotor  {
	private ElevatorController elevatorController ;
	private MotorStatus motorStatus ;
	private DeviceVendor motorVendor;
	
	public ElevatorMotor(final DeviceVendor motorVendor) {
		this.motorVendor = motorVendor;
		motorStatus = MotorStatus.STOPPED ;
	}
	public void setElevatorController(final ElevatorController elevatorController) {
		this.elevatorController = elevatorController ;
	}
	public MotorStatus getMotorStatus() {
		return motorStatus;
	}
	private void setMotorStatus(final MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	public void move(final Floor currentFloor, final Direction direction) {
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
