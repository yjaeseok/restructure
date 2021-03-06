
import java.util.ArrayList;
import java.util.List;

abstract class ElevatorController {
	private ElevatorMotor elevatorMotor;
	private ElevatorDoor elevatorDoor;
	private List<FloorDoor> floorDoors;
	private JavaDoorTimer doorTimer;
	
	private List<Floor> floorstobeVisited = new ArrayList<>();
	private Floor curFlr = new Floor(1);
	private Direction curDir = Direction.NONE;
	
	private ControlRoomDisplay controlRoomDisplay;
	private ElevatorInsideDisplay elevatorInsideDisplay;
	private AbstractFloorDisplay abstractFloorDisplay;
	
	public ElevatorController(final ElevatorMotor elevatorMotor,
			final ElevatorDoor elevatorDoor, final List<FloorDoor> floorDoors,
			final JavaDoorTimer doorTimer) {
		this.elevatorMotor = elevatorMotor;
		this.elevatorDoor = elevatorDoor;
		this.floorDoors = floorDoors;
		this.doorTimer = doorTimer;
		
		if ( doorTimer != null )
			doorTimer.setDoorTimeout(this);
	}
	public void stop() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		if ( getCurrentElevatorDirection() != Direction.NONE) {
			elevatorMotor.stop();
			setCurDir(Direction.NONE);
		}
		// open doors
		elevatorDoor.open() ;
		floorDoors.get(getCurrentElevatorFloor().getFloor()).open() ;
		if ( doorTimer != null ) doorTimer.start() ;
	}
	
	public void goTo(final Floor dst) {
		// elevatorMotor should not be null
		if ( ! floorstobeVisited.contains(dst) )
			floorstobeVisited.add(dst) ;
		
		if ( getCurrentElevatorDirection() == Direction.NONE ) {
			Direction nxtDir;
			if ( floorstobeVisited.isEmpty() ) nxtDir = Direction.NONE ;
			
			if ( dst.compareTo(curFlr) > 0 ) nxtDir = Direction.UP ;
			else nxtDir =  Direction.DOWN ;
			if ( nxtDir != Direction.NONE ) {
				elevatorMotor.move(getCurrentElevatorFloor(), nxtDir) ;
				setCurDir(nxtDir);
			}
		}
	}
	
	abstract boolean getNeedToStop(Floor floor);
	
	public void approaching(final Floor floor) {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		notifyApproaching(floor);
		setCurFlr(floor) ;
		
		boolean needToStop = getNeedToStop(floor);
		if ( needToStop ) {
			stop();
			floorstobeVisited.remove(floor) ;
		}
	}

	private void notifyApproaching(final Floor floor) {
		System.out.println("\nApproaching " + floor + "th floor") ;
	}
	public void doorTimeout() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null

		Direction nxtDir;
		if ( floorstobeVisited.isEmpty() ) nxtDir = Direction.NONE ;
		
		final Floor dst = floorstobeVisited.get(0) ;
		if ( dst.compareTo(curFlr) > 0 ) nxtDir = Direction.UP ;
		else nxtDir =  Direction.DOWN ;
		
		elevatorDoor.close() ;
		floorDoors.get(getCurrentElevatorFloor().getFloor()).close() ;
		if ( doorTimer != null ) doorTimer.stop() ;
		
		if ( nxtDir != Direction.NONE ) {
			elevatorMotor.move(getCurrentElevatorFloor(), nxtDir) ;
			setCurDir(nxtDir);
		}
	}
	public void openDoor() {
		// elevatorDoor, floorDoors should not be null

		if ( getCurrentElevatorDirection() == Direction.NONE  ) {
			// open doors
			elevatorDoor.open() ;
			floorDoors.get(getCurrentElevatorFloor().getFloor()).open() ;
			if ( doorTimer != null ) doorTimer.start() ;
		}
	}
	public void closeDoor() {
		// elevatorDoor, floorDoors should not be null
		if ( getCurrentElevatorDirection() == Direction.NONE ) {
			// closeDoor
			elevatorDoor.close() ;
			floorDoors.get(getCurrentElevatorFloor().getFloor()).close() ;
			if ( doorTimer != null ) doorTimer.stop() ;
		}
	}
	public List<Floor> getFloorstobeVisited() {
		return floorstobeVisited;
	}
	public DoorStatus getDrSts(final Floor floor) {
		// elevatorDoor, floorDoors should not be null
		
		DoorStatus elevatorDS = elevatorDoor.getDoorStatus();
		DoorStatus floorDS = floorDoors.get(floor.getFloor()).getDoorStatus();
		
		DoorStatus DS = DoorStatus.OPEN;
		if ( elevatorDS == DoorStatus.CLOSED && floorDS == DoorStatus.CLOSED )
			DS = DoorStatus.CLOSED;
		
		return DS;
	}
	public Floor getCurrentElevatorFloor() {
		return curFlr ;
	}
	public void setCurFlr(final Floor curFlr) {
		this.curFlr = curFlr;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public Direction getCurrentElevatorDirection() {
		return curDir;
	}
	public void setCurDir(final Direction curDir) {
		this.curDir = curDir;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public ControlRoomDisplay getControlRoomDisplay() {
		return controlRoomDisplay;
	}
	public void setControlRoomDisplay(final ControlRoomDisplay controlRoomDisplay) {
		this.controlRoomDisplay = controlRoomDisplay;
	}
	public ElevatorInsideDisplay getElevatorInsideDisplay() {
		return elevatorInsideDisplay;
	}
	public void setElevatorInsideDisplay(final ElevatorInsideDisplay elevatorInsideDisplay) {
		this.elevatorInsideDisplay = elevatorInsideDisplay;
	}
	public AbstractFloorDisplay getAbstractFloorDisplay() {
		return abstractFloorDisplay;
	}
	public void setAbstractFloorDisplay(final AbstractFloorDisplay abstractFloorDisplay) {
		this.abstractFloorDisplay = abstractFloorDisplay;
	}
}