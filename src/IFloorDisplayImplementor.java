

public interface IFloorDisplayImplementor {
	public void activateDisplay();
	public void deactivateDisplay();
	
	public void showCurrentPosition(final int floor);
	public void expressCurrentPositionByVoice(final int floor);
	public void showDirection(final Direction direction);
	public void expressDirectionByVoice(final Direction direction);
}
