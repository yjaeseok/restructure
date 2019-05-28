import java.util.List;

public class ElevatorControllerDemandOnlyStop extends ElevatorController {
	public ElevatorControllerDemandOnlyStop(final ElevatorMotor elevatorMotor,
			final ElevatorDoor elevatorDoor, final List<FloorDoor> floorDoors,
			final JavaDoorTimer doorTimer) {
		super(elevatorMotor, elevatorDoor, floorDoors, doorTimer);
	}

	@Override
	protected boolean getNeedToStop(final int floor) {
		return getFloorstobeVisited().contains(floor);
	}
}
