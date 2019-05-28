

public class SamsungFloorDisplayImplementor implements IFloorDisplayImplementor {
	private String activated = "yes";
	public void activateDisplay() {
		activated = "yes";
	}
	public void deactivateDisplay() {
		activated = "no";
	}
	public void showCurrentPosition(final Floor floor) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Display: Current Postion " + floor);
	}
	public void expressCurrentPositionByVoice(final Floor floor) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Voice: Current Postion " + floor);
	}
	public void showDirection(final Direction direction) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Display: Current Direction " + direction);
	}
	public void expressDirectionByVoice(final Direction direction) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Voice: Current Direction " + direction);
	}
}
