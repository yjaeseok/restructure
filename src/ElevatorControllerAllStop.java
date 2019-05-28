import java.util.List;

public class ElevatorControllerAllStop extends ElevatorController {
	public ElevatorControllerAllStop(final ElevatorMotor elevatorMotor,
			final ElevatorDoor elevatorDoor, final List<FloorDoor> floorDoors,
			final JavaDoorTimer doorTimer) {
		super(elevatorMotor, elevatorDoor, floorDoors, doorTimer);
	}

	@Override
	protected boolean getNeedToStop(final Floor floor) {
		return true;
	}
}
