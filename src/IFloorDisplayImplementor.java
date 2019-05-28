

public interface IFloorDisplayImplementor {
	public void activateDisplay();
	public void deactivateDisplay();
	
	public void showCurrentPosition(final Floor floor);
	public void expressCurrentPositionByVoice(final Floor floor);
	public void showDirection(final Direction direction);
	public void expressDirectionByVoice(final Direction direction);
}
