

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		int floorCount = 5;
		
		List<EC> elevatorControllers = createElevatorControllers(floorCount);
		
		SimpleEM em = new SimpleEM(elevatorControllers);
		
		List<ElevatorRequest> requestButtons = new ArrayList<>();
		for ( int i = 0; i < floorCount; i ++ ) {
			int floor = i+1;
			ElevatorRequest requestButton = new ElevatorRequest(floor,em);
			requestButtons.add(requestButton);
		}
		requestButtons.get(0).down();
	}

	private static List<EC> createElevatorControllers(int floorCount) {
		List<EC> elevatorControllers = new ArrayList<>();
		
		// Devices for Elevator 1
		EM elevatorMotor1 = new EM(DeviceVendor.Samsung);
		JavaDT doorTimer1 = new JavaDT();
			
		ED elevatorDoor1 = new ED(DeviceVendor.Samsung);
		List<FD> floorDoors1 = createFloorDoors(floorCount, DeviceVendor.Samsung);
		
		// every floor stop
		EC elevatorController1 = new EC(0,
				elevatorMotor1, elevatorDoor1, floorDoors1, doorTimer1);
		doorTimer1.setDoorTimeout(elevatorController1);
		elevatorMotor1.setElevatorController(elevatorController1);

		ControlRoomDisplay controlRoomDisplay = new ControlRoomDisplay(elevatorController1);
		elevatorController1.setControlRoomDisplay(controlRoomDisplay);
		ElevatorInsideDisplay elevatorInsideDisplay = new ElevatorInsideDisplay(elevatorController1);
		elevatorController1.setElevatorInsideDisplay(elevatorInsideDisplay);

		elevatorControllers.add(elevatorController1);
		
		// Devices for Elevator 2
		EM elevatorMotor2 = new EM(DeviceVendor.Hyundai);
		ED elevatorDoor2 = new ED(DeviceVendor.Hyundai);
		List<FD> floorDoors2 = createFloorDoors(floorCount, DeviceVendor.Hyundai);
		
		// demand only stop
		EC elevatorController2 = new EC(1,
					elevatorMotor2, elevatorDoor2, floorDoors2, null);
		elevatorMotor2.setElevatorController(elevatorController2);

		IFloorDisplayImplementor imp = new SamsungFloorDisplayImplementor();
		AdvancedFloorDisplay advancedFloorDisplay = new AdvancedFloorDisplay(elevatorController2, imp);
		elevatorController2.setAbstractFloorDisplay(advancedFloorDisplay);
		
		elevatorControllers.add(elevatorController2);
		return elevatorControllers;
	}

	private static List<FD> createFloorDoors(int floorCount, DeviceVendor vendor) {
		List<FD> floorDoors = new ArrayList<>();
		
		for ( int i = 0 ; i < floorCount; i ++ )
			floorDoors.add(new FD(vendor, i));
		return floorDoors;
	}
}
