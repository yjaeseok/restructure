
import java.util.ArrayList;
import java.util.List;

class ElevatorController {
	private int k; // 0: every floor stop, 1: demand only stop

	private ElevatorMotor elevatorMotor;
	private ElevatorDoor elevatorDoor;
	private List<FloorDoor> floorDoors;
	private JavaDoorTimer doorTimer;
	
	private List<Integer> floorstobeVisited = new ArrayList<>();
	private int curFlr = 1;
	private Direction curDir = Direction.NONE;
	
	private ControlRoomDisplay controlRoomDisplay;
	private ElevatorInsideDisplay elevatorInsideDisplay;
	private AbstractFloorDisplay abstractFloorDisplay;
	
	public ElevatorController(int kind, ElevatorMotor elevatorMotor,
			ElevatorDoor elevatorDoor, List<FloorDoor> floorDoors,
			JavaDoorTimer doorTimer) {
		this.k = kind;
		this.elevatorMotor = elevatorMotor;
		this.elevatorDoor = elevatorDoor;
		this.floorDoors = floorDoors;
		this.doorTimer = doorTimer;
		
		if ( doorTimer != null )
			doorTimer.setDoorTimeout(this);
	}
	public void stop() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		if ( getCurDir() != Direction.NONE) {
			elevatorMotor.stop();
			setCurDir(Direction.NONE);
		}
		// open doors
		elevatorDoor.open() ;
		floorDoors.get(getCurFlr()).open() ;
		if ( doorTimer != null ) doorTimer.start() ;
	}
	
	public void goTo(final int dst) {
		// elevatorMotor should not be null
		if ( ! floorstobeVisited.contains(dst) )
			floorstobeVisited.add(dst) ;
		
		if ( getCurDir() == Direction.NONE ) {
			Direction nxtDir;
			if ( floorstobeVisited.isEmpty() ) nxtDir = Direction.NONE ;
			
			if ( dst > curFlr ) nxtDir = Direction.UP ;
			else nxtDir =  Direction.DOWN ;
			if ( nxtDir != Direction.NONE ) {
				elevatorMotor.move(getCurFlr(), nxtDir) ;
				setCurDir(nxtDir);
			}
		}
	}
	public void approaching(int flr) {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		System.out.println("\nApproaching " + flr + "th floor") ;
		setCurFlr(flr) ;
		
		boolean needToStop;
		if ( k == 0 )
			needToStop = true;
		else
			needToStop = getFloorstobeVisited().contains(flr);
			
		if ( needToStop ) {
			elevatorMotor.stop() ;
			setCurDir(Direction.NONE);
			
			// open doors
			elevatorDoor.open() ;
			floorDoors.get(getCurFlr()).open() ;
			if ( doorTimer != null ) doorTimer.start() ;
			
			floorstobeVisited.remove(flr) ;
		}
	}
	public void doorTimeout() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null

		Direction nxtDir;
		if ( floorstobeVisited.isEmpty() ) nxtDir = Direction.NONE ;
		
		final int dst = floorstobeVisited.get(0) ;
		if ( dst > curFlr ) nxtDir = Direction.UP ;
		else nxtDir =  Direction.DOWN ;
		
		elevatorDoor.close() ;
		floorDoors.get(getCurFlr()).close() ;
		if ( doorTimer != null ) doorTimer.stop() ;
		
		if ( nxtDir != Direction.NONE ) {
			elevatorMotor.move(getCurFlr(), nxtDir) ;
			setCurDir(nxtDir);
		}
	}
	public void openDoor() {
		// elevatorDoor, floorDoors should not be null

		if ( getCurDir() == Direction.NONE  ) {
			// open doors
			elevatorDoor.open() ;
			floorDoors.get(getCurFlr()).open() ;
			if ( doorTimer != null ) doorTimer.start() ;
		}
	}
	public void closeDoor() {
		// elevatorDoor, floorDoors should not be null
		if ( getCurDir() == Direction.NONE ) {
			// closeDoor
			elevatorDoor.close() ;
			floorDoors.get(getCurFlr()).close() ;
			if ( doorTimer != null ) doorTimer.stop() ;
		}
	}
	public List<Integer> getFloorstobeVisited() {
		return floorstobeVisited;
	}
	public DoorStatus getDrSts(int floor) {
		// elevatorDoor, floorDoors should not be null
		
		DoorStatus elevatorDS = elevatorDoor.getDoorStatus();
		DoorStatus floorDS = floorDoors.get(floor).getDoorStatus();
		
		DoorStatus DS = DoorStatus.OPEN;
		if ( elevatorDS == DoorStatus.CLOSED && floorDS == DoorStatus.CLOSED )
			DS = DoorStatus.CLOSED;
		
		return DS;
	}
	public int getCurFlr() {
		return curFlr ;
	}
	public void setCurFlr(int curFlr) {
		this.curFlr = curFlr;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public Direction getCurDir() {
		return curDir;
	}
	public void setCurDir(Direction curDir) {
		this.curDir = curDir;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public ControlRoomDisplay getControlRoomDisplay() {
		return controlRoomDisplay;
	}
	public void setControlRoomDisplay(ControlRoomDisplay controlRoomDisplay) {
		this.controlRoomDisplay = controlRoomDisplay;
	}
	public ElevatorInsideDisplay getElevatorInsideDisplay() {
		return elevatorInsideDisplay;
	}
	public void setElevatorInsideDisplay(ElevatorInsideDisplay elevatorInsideDisplay) {
		this.elevatorInsideDisplay = elevatorInsideDisplay;
	}
	public AbstractFloorDisplay getAbstractFloorDisplay() {
		return abstractFloorDisplay;
	}
	public void setAbstractFloorDisplay(AbstractFloorDisplay abstractFloorDisplay) {
		this.abstractFloorDisplay = abstractFloorDisplay;
	}
}