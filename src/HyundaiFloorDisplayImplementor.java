

public class HyundaiFloorDisplayImplementor implements IFloorDisplayImplementor {
	private boolean activated = true;
	public void activateDisplay() {
		activated = true;
	}
	public void deactivateDisplay() {
		activated = false;
	}
	public void showCurrentPosition(final int floor) {
		if ( ! activated ) return;
		System.out.println("Hyundai Display: Current Postion " + floor);
	}
	public void expressCurrentPositionByVoice(final int floor) {
		if ( ! activated ) return;
		System.out.println("Hyundai Voice: Current Postion " + floor);
	}
	public void showDirection(final Direction direction) {
		if ( ! activated ) return;
		System.out.println("Hyundai Display: Current Direction " + direction);
	}
	public void expressDirectionByVoice(final Direction direction) {
		if ( ! activated ) return;
		System.out.println("Hyundai Voice: Current Direction " + direction);
	}
}
