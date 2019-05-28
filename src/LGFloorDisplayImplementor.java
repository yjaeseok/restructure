

public class LGFloorDisplayImplementor implements IFloorDisplayImplementor {
	private int activated = 1;
	public void activateDisplay() {
		activated = 1;
	}
	public void deactivateDisplay() {
		activated = 0;
	}
	@Override
	public void showCurrentPosition(final Floor floor) {
		if ( activated == 0 ) return;
		System.out.println("LG Display: Current Postion " + floor);
	}
	public void expressCurrentPositionByVoice(final Floor floor) {
		if ( activated == 0 ) return;
		System.out.println("LG Voice: Current Postion " + floor);
	}
	public void showDirection(final Direction direction) {
		if ( activated == 0 ) return;
		System.out.println("LG Display: Current Direction " + direction);
	}
	public void expressDirectionByVoice(final Direction direction) {
		if ( activated == 0 ) return;
		System.out.println("LG Voice: Current Direction " + direction);
	}
}
