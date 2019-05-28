

public class FD {
	private DeviceVendor vendor;
	private int floor ;
	
	private int doorOpenedForLG;
	private boolean doorOpenedForHyundai;
	private char doorOpenedForSamsung;

	public FD(DeviceVendor vendor, int floor) {
		this.vendor = vendor;
		this.floor = floor;
		
		switch ( vendor ) {
		case LG:
			doorOpenedForLG = 0;
			break;
		case Hyundai:
			doorOpenedForHyundai = false;
			break;
		case Samsung:
			doorOpenedForSamsung = 'X';
			break;
		}
	}
	public void open() {
		switch ( vendor ) {
		case LG:
			System.out.println(floor + "th Floor Door Open") ;
			doorOpenedForLG = 1;
			break;
		case Hyundai:
			System.out.println(floor + "th Floor Door Open") ;
			doorOpenedForHyundai = true;
			break;
		case Samsung:
			System.out.println(floor + "th Floor Door Open") ;
			doorOpenedForSamsung = 'O';
			break;
		}
	}
	public void close() {
		switch ( vendor ) {
		case LG:
			System.out.println(floor + "th Floor Door Close") ;	
			doorOpenedForLG = 0;
			break;
		case Hyundai:
			System.out.println(floor + "th Floor Door Close") ;	
			doorOpenedForHyundai = false;
			break;
		case Samsung:
			System.out.println(floor + "th Floor Door Close") ;	
			doorOpenedForSamsung = 'X';
			break;
		}
	}
	public DoorStatus getDoorStatus() {
		DoorStatus status = null;
		switch ( vendor ) {
		case LG:
			status = (doorOpenedForLG == 1) ? DoorStatus.OPEN : DoorStatus.CLOSED;
			break;
		case Hyundai:
			status = (doorOpenedForHyundai) ? DoorStatus.OPEN : DoorStatus.CLOSED;
			break;
		case Samsung:
			status = (doorOpenedForSamsung == 'O') ? DoorStatus.OPEN : DoorStatus.CLOSED;
			break;
		}
		return status;
	}
	public int getFloor() { return floor; }
}