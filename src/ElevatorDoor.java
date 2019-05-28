

public class ElevatorDoor {
	private DeviceVendor vendor;

	private String elevatorDoorStatusForLG ;
	private char elevatorDoorStatusForSamsung ;
	private int elevatorDoorOpenedForHyundai ;

	public ElevatorDoor(final DeviceVendor vendor) {
		this.vendor = vendor;
		
		switch ( vendor ) {
		case LG:
			elevatorDoorStatusForLG = "Closed";
			break;
		case Hyundai:
			elevatorDoorOpenedForHyundai = 0;
			break;
		case Samsung:
			elevatorDoorStatusForSamsung = 'C';
			break;
		}
	}
	public DoorStatus getDoorStatus() {
		DoorStatus status = null;
		switch ( vendor ) {
		case LG:
			status = elevatorDoorStatusForLG.equals("Closed") ? DoorStatus.CLOSED : DoorStatus.OPEN;
			break;
		case Hyundai:
			status = elevatorDoorOpenedForHyundai == 0 ? DoorStatus.CLOSED : DoorStatus.OPEN;
			break;
		case Samsung:
			status = elevatorDoorStatusForSamsung == 'C' ? DoorStatus.CLOSED : DoorStatus.OPEN;
			break;
		}
		return status;
	}
	public void open() {
		switch ( vendor ) {
		case LG:
			if ( elevatorDoorStatusForLG.equals("Opened") ) return ;
			System.out.println("open LG Elevator Door") ;
			elevatorDoorStatusForLG = "Opened";
			break;
		case Hyundai:
			if ( elevatorDoorOpenedForHyundai == 1 ) return ;
			System.out.println("open Hyundai Elevator Door") ;
			elevatorDoorOpenedForHyundai = 1;
			break;
		case Samsung:
			if ( elevatorDoorStatusForSamsung == 'O' ) return ;
			System.out.println("open Samsung Elevator Door") ;
			elevatorDoorStatusForSamsung = 'O';
			break;
		}	
	}
	public void close() {
		switch ( vendor ) {
		case LG:
			if ( elevatorDoorStatusForLG.equals("Closed") ) return ;
			System.out.println("close LG Elevator Door") ;		
			elevatorDoorStatusForLG = "Closed";
			break;
		case Hyundai:
			if ( elevatorDoorOpenedForHyundai == 0  ) return ;
			System.out.println("close Hyundai Elevator Door") ;		
			elevatorDoorOpenedForHyundai = 0;
			break;
		case Samsung:
			if ( elevatorDoorStatusForSamsung == 'C'  ) return ;
			System.out.println("close Samsung Elevator Door") ;		
			elevatorDoorStatusForSamsung = 'C';
			break;
		}
	}
}